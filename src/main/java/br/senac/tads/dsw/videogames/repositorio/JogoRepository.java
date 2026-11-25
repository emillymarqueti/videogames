package br.senac.tads.dsw.videogames.repositorio;

import br.senac.tads.dsw.videogames.entidade.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<JogoEntity, Long> {
}
