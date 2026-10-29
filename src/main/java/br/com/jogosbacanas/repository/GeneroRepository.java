package br.com.jogosbacanas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jogosbacanas.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNomeIgnoreCase(String nome);
}
