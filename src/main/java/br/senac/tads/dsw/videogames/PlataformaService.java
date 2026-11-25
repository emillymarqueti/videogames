package br.senac.tads.dsw.videogames;

import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;
import br.senac.tads.dsw.videogames.repositorio.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaService {

	private final PlataformaRepository repository;

	public PlataformaService(PlataformaRepository repository) {
		this.repository = repository;
	}

	public List<PlataformaDto> listarTodas() {
		return repository.findAll().stream()
			.map(p -> new PlataformaDto(p.getId(), p.getNome()))
			.toList();
	}

	public PlataformaDto incluir(PlataformaDto dto) {
		PlataformaEntity entity = new PlataformaEntity();
		entity.setNome(dto.nome().trim());
		PlataformaEntity salvo = repository.save(entity);
		return new PlataformaDto(salvo.getId(), salvo.getNome());
	}
}
