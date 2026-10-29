package br.com.jogosbacanas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jogosbacanas.model.Desenvolvedora;

public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {
    Optional<Desenvolvedora> findByNomeIgnoreCase(String nome);
}
