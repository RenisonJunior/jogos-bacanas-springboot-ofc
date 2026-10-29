package br.com.jogosbacanas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jogosbacanas.model.Sugestao;

public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {
    List<Sugestao> findAllByOrderByIdDesc();
}
