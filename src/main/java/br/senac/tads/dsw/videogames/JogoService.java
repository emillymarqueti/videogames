package br.senac.tads.dsw.videogames;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.videogames.entidade.JogoEntity;
import br.senac.tads.dsw.videogames.entidade.PlataformaEntity;
import br.senac.tads.dsw.videogames.repositorio.JogoRepository;
import br.senac.tads.dsw.videogames.repositorio.PlataformaRepository;

@Service
public class JogoService {

	private final JogoRepository jogoRepository;
	private final PlataformaRepository plataformaRepository;

	public JogoService(JogoRepository jogoRepository, PlataformaRepository plataformaRepository) {
		this.jogoRepository = jogoRepository;
		this.plataformaRepository = plataformaRepository;
	}

	private JogoDto toDto(JogoEntity entity) {
		JogoDto dto = new JogoDto();
		dto.setId(entity.getId());
		dto.setTitulo(entity.getTitulo());
		dto.setAnoLancamento(entity.getAnoLancamento());
		dto.setPlataformaId(entity.getPlataforma().getId());
		dto.setPlataformaNome(entity.getPlataforma().getNome());
		dto.setDisponivel(entity.getDisponivel());
		dto.setObservacoes(entity.getObservacoes());
		return dto;
	}

	@Transactional(readOnly = true)
	public List<JogoDto> listarTodos() {
		List<JogoDto> resultado = new ArrayList<>();
		for (JogoEntity entity : jogoRepository.findAll()) {
			resultado.add(toDto(entity));
		}
		return resultado;
	}

	@Transactional(readOnly = true)
	public Optional<JogoDto> buscarPorId(Integer id) {
		Optional<JogoEntity> optEntity = jogoRepository.findById(id);
		if (optEntity.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(toDto(optEntity.get()));
	}

	@Transactional
	public JogoDto incluir(JogoDto dto) {
		Optional<PlataformaEntity> optPlat = plataformaRepository.findById(dto.getPlataformaId());
		if (optPlat.isEmpty()) {
			throw new NaoEncontradoException("Plataforma não encontrada: " + dto.getPlataformaId());
		}

		JogoEntity entity = new JogoEntity();
		entity.setTitulo(dto.getTitulo().trim());
		entity.setAnoLancamento(dto.getAnoLancamento());
		entity.setPlataforma(optPlat.get());
		entity.setDisponivel(dto.getDisponivel());
		entity.setObservacoes(dto.getObservacoes());

		JogoEntity salvo = jogoRepository.save(entity);
		return toDto(salvo);
	}

	@Transactional
	public JogoDto alterar(Integer id, JogoDto dto) {
		Optional<JogoEntity> optEntity = jogoRepository.findById(id);
		if (optEntity.isEmpty()) {
			throw new NaoEncontradoException("Jogo não encontrado: " + id);
		}

		Optional<PlataformaEntity> optPlat = plataformaRepository.findById(dto.getPlataformaId());
		if (optPlat.isEmpty()) {
			throw new NaoEncontradoException("Plataforma não encontrada: " + dto.getPlataformaId());
		}

		JogoEntity entity = optEntity.get();
		entity.setTitulo(dto.getTitulo().trim());
		entity.setAnoLancamento(dto.getAnoLancamento());
		entity.setPlataforma(optPlat.get());
		entity.setDisponivel(dto.getDisponivel());
		entity.setObservacoes(dto.getObservacoes());

		JogoEntity salvo = jogoRepository.save(entity);
		return toDto(salvo);
	}

	@Transactional
	public void excluir(Integer id) {
		if (!jogoRepository.existsById(id)) {
			throw new NaoEncontradoException("Jogo não encontrado: " + id);
		}
		jogoRepository.deleteById(id);
	}
}