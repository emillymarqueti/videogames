package br.senac.tads.dsw.videogames;

import br.senac.tads.dsw.videogames.entidade.JogoEntity;
import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;
import br.senac.tads.dsw.videogames.repositorio.JogoRepository;
import br.senac.tads.dsw.videogames.repositorio.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

	private final JogoRepository jogoRepository;
	private final PlataformaRepository plataformaRepository;

	public JogoService(JogoRepository jogoRepository, PlataformaRepository plataformaRepository) {
		this.jogoRepository = jogoRepository;
		this.plataformaRepository = plataformaRepository;
	}

	public List<JogoDto> listarTodos() {
		return jogoRepository.findAll().stream()
			.map(this::toDto)
			.toList();
	}

	public JogoDto buscarPorId(Long id) {
		JogoEntity entity = jogoRepository.findById(id)
			.orElseThrow(() -> new NaoEncontradoException("Jogo não encontrado: " + id));
		return toDto(entity);
	}

	public JogoDto incluir(JogoDto dto) {
		PlataformaEntity plataforma = plataformaRepository.findById(dto.plataformaId())
			.orElseThrow(() -> new NaoEncontradoException("Plataforma não encontrada: " + dto.plataformaId()));

		JogoEntity entity = new JogoEntity();
		entity.setTitulo(dto.titulo().trim());
		entity.setAnoLancamento(dto.anoLancamento());
		entity.setPlataforma(plataforma);
		entity.setDisponivel(dto.disponivel());
		entity.setObservacoes(dto.observacoes());

		return toDto(jogoRepository.save(entity));
	}

	public JogoDto alterar(Long id, JogoDto dto) {
		JogoEntity entity = jogoRepository.findById(id)
			.orElseThrow(() -> new NaoEncontradoException("Jogo não encontrado: " + id));

		PlataformaEntity plataforma = plataformaRepository.findById(dto.plataformaId())
			.orElseThrow(() -> new NaoEncontradoException("Plataforma não encontrada: " + dto.plataformaId()));

		entity.setTitulo(dto.titulo().trim());
		entity.setAnoLancamento(dto.anoLancamento());
		entity.setPlataforma(plataforma);
		entity.setDisponivel(dto.disponivel());
		entity.setObservacoes(dto.observacoes());

		return toDto(jogoRepository.save(entity));
	}

	public void excluir(Long id) {
		if (!jogoRepository.existsById(id)) {
			throw new NaoEncontradoException("Jogo não encontrado: " + id);
		}
		jogoRepository.deleteById(id);
	}

	private JogoDto toDto(JogoEntity entity) {
		return new JogoDto(
			entity.getId(),
			entity.getTitulo(),
			entity.getAnoLancamento(),
			entity.getPlataforma().getId(),
			entity.getPlataforma().getNome(),
			entity.getDisponivel(),
			entity.getObservacoes()
		);
	}
}
