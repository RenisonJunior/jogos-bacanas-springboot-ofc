package br.com.jogosbacanas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jogosbacanas.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findTop3ByOrderByIdAsc();
}
