package br.com.jogosbacanas.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SugestaoForm {
    private Long id;

    @NotBlank(message = "Informe seu nome.")
    private String nome;

    @NotBlank(message = "Informe seu e-mail.")
    @Email(message = "Digite um e-mail válido.")
    private String email;

    @NotNull(message = "Informe sua data de nascimento.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate nascimento;

    @NotBlank(message = "Informe o nome do jogo.")
    private String nomeJogo;

    @NotNull(message = "Selecione um gênero.")
    private Long generoId;

    @NotBlank(message = "Escreva por que você recomenda o jogo.")
    private String descricao;

    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }
    public String getNomeJogo() { return nomeJogo; }
    public void setNomeJogo(String nomeJogo) { this.nomeJogo = nomeJogo; }
    public Long getGeneroId() { return generoId; }
    public void setGeneroId(Long generoId) { this.generoId = generoId; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
