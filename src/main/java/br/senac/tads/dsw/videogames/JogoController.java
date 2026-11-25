package br.senac.tads.dsw.videogames;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

	private final JogoService service;

	public JogoController(JogoService service) {
		this.service = service;
	}

	@GetMapping
	public List<JogoDto> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public JogoDto buscarPorId(@PathVariable("id") Integer id) {
		Optional<JogoDto> optJogo = service.buscarPorId(id);
		if (optJogo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optJogo.get();
	}

	@PostMapping
	public ResponseEntity<JogoDto> incluir(@RequestBody @Valid JogoDto dto) {
		JogoDto salvo = service.incluir(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}

	@PutMapping("/{id}")
	public JogoDto alterar(@PathVariable("id") Integer id, @RequestBody @Valid JogoDto dto) {
		return service.alterar(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
}