package br.com.jogosbacanas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.jogosbacanas.model.Genero;
import br.com.jogosbacanas.model.Sugestao;
import br.com.jogosbacanas.model.SugestaoForm;
import br.com.jogosbacanas.model.Usuario;
import br.com.jogosbacanas.repository.GeneroRepository;
import br.com.jogosbacanas.repository.SugestaoRepository;
import br.com.jogosbacanas.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Controller
public class SugestaoController {
    private final SugestaoRepository sugestaoRepository;
    private final GeneroRepository generoRepository;
    private final UsuarioRepository usuarioRepository;
    private final List<String> statusOpcoes = List.of("Pendente", "Em análise", "Aprovada", "Recusada");

    public SugestaoController(SugestaoRepository sugestaoRepository,
                              GeneroRepository generoRepository,
                              UsuarioRepository usuarioRepository) {
        this.sugestaoRepository = sugestaoRepository;
        this.generoRepository = generoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/sugestoes")
    public String listar(Model model) {
        model.addAttribute("sugestoes", sugestaoRepository.findAllByOrderByIdDesc());
        return "sugestao";
    }

    @GetMapping("/sugestoes/nova")
    public String nova(Model model) {
        SugestaoForm form = new SugestaoForm();
        form.setStatus("Pendente");
        model.addAttribute("form", form);
        carregarOpcoes(model);
        return "sugestao-formulario";
    }

    @GetMapping("/sugestoes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Sugestao sugestao = sugestaoRepository.findById(id).orElse(null);
        if (sugestao == null) {
            return "redirect:/sugestoes";
        }

        SugestaoForm form = new SugestaoForm();
        form.setId(sugestao.getId());
        form.setNome(sugestao.getUsuario().getNome());
        form.setEmail(sugestao.getUsuario().getEmail());
        form.setNascimento(sugestao.getUsuario().getNascimento());
        form.setNomeJogo(sugestao.getNomeJogo());
        form.setGeneroId(sugestao.getGenero().getId());
        form.setDescricao(sugestao.getDescricao());
        form.setStatus(sugestao.getStatus());
        model.addAttribute("form", form);
        carregarOpcoes(model);
        return "sugestao-formulario";
    }

    @GetMapping("/sugestoes/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Sugestao sugestao = sugestaoRepository.findById(id).orElse(null);
        if (sugestao == null) {
            return "redirect:/sugestoes";
        }
        model.addAttribute("sugestao", sugestao);
        return "sugestao-detalhes";
    }

    @PostMapping("/sugestoes/salvar")
    public String salvar(@Valid @ModelAttribute("form") SugestaoForm form,
                         BindingResult resultado, Model model) {
        if (form.getGeneroId() == null || !generoRepository.existsById(form.getGeneroId())) {
            resultado.rejectValue("generoId", "genero.invalido", "Selecione um gênero válido.");
        }
        if (form.getId() != null && !statusOpcoes.contains(form.getStatus())) {
            resultado.rejectValue("status", "status.invalido", "Selecione um status válido.");
        }
        if (resultado.hasErrors()) {
            carregarOpcoes(model);
            return "sugestao-formulario";
        }

        Usuario usuario = usuarioRepository.findByEmailIgnoreCase(form.getEmail().trim()).orElseGet(Usuario::new);
        usuario.setNome(form.getNome().trim());
        usuario.setEmail(form.getEmail().trim());
        usuario.setNascimento(form.getNascimento());
        usuario = usuarioRepository.save(usuario);

        Sugestao sugestao;
        if (form.getId() == null) {
            sugestao = new Sugestao();
            sugestao.setStatus("Pendente");
        } else {
            sugestao = sugestaoRepository.findById(form.getId()).orElse(null);
            if (sugestao == null) {
                return "redirect:/sugestoes";
            }
            sugestao.setStatus(form.getStatus());
        }

        Genero genero = generoRepository.findById(form.getGeneroId()).orElseThrow();
        sugestao.setNomeJogo(form.getNomeJogo().trim());
        sugestao.setDescricao(form.getDescricao().trim());
        sugestao.setUsuario(usuario);
        sugestao.setGenero(genero);
        sugestaoRepository.save(sugestao);
        return "redirect:/sugestoes";
    }

    @PostMapping("/sugestoes/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        if (sugestaoRepository.existsById(id)) {
            sugestaoRepository.deleteById(id);
        }
        return "redirect:/sugestoes";
    }

    private void carregarOpcoes(Model model) {
        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("statusOpcoes", statusOpcoes);
    }
}
