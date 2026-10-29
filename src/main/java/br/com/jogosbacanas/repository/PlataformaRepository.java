package br.com.jogosbacanas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jogosbacanas.model.Plataforma;

public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {
    Optional<Plataforma> findByNomeIgnoreCase(String nome);
}
