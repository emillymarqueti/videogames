package br.senac.tads.dsw.videogames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;

@Repository
public interface PlataformaRepository extends JpaRepository<PlataformaEntity, Integer> {
}