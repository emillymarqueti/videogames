package br.senac.tads.dsw.videogames.repositorio;

import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlataformaRepository extends JpaRepository<PlataformaEntity, Long> {
}
