package br.senac.tads.dsw.videogames;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;
import br.senac.tads.dsw.videogames.repositorio.PlataformaRepository;

@Service
public class PlataformaService {

	private final PlataformaRepository plataformaRepository;

	public PlataformaService(PlataformaRepository plataformaRepository) {
		this.plataformaRepository = plataformaRepository;
	}

	private PlataformaDto toDto(PlataformaEntity entity) {
		PlataformaDto dto = new PlataformaDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		return dto;
	}

	@Transactional(readOnly = true)
	public List<PlataformaDto> listarTodas() {
		List<PlataformaDto> resultado = new ArrayList<>();
		for (PlataformaEntity entity : plataformaRepository.findAll()) {
			resultado.add(toDto(entity));
		}
		return resultado;
	}

	@Transactional
	public PlataformaDto incluir(PlataformaDto dto) {
		PlataformaEntity entity = new PlataformaEntity();
		entity.setNome(dto.getNome().trim());
		PlataformaEntity salva = plataformaRepository.save(entity);
		return toDto(salva);
	}
}