package br.com.jogosbacanas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.jogosbacanas.repository.JogoRepository;

@Controller
public class PaginaController {
    private final JogoRepository jogoRepository;

    public PaginaController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("jogosDestaque", jogoRepository.findTop3ByOrderByIdAsc());
        return "index";
    }

    @GetMapping("/jogos")
    public String jogos(Model model) {
        model.addAttribute("jogos", jogoRepository.findAll());
        return "jogos";
    }

    @GetMapping("/generos")
    public String generos() {
        return "generos";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }
}
