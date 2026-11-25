package br.senac.tads.dsw.videogames;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public JogoDto buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public ResponseEntity<JogoDto> incluir(@RequestBody @Valid JogoDto dto) {
		JogoDto salvo = service.incluir(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}

	@PutMapping("/{id}")
	public JogoDto alterar(@PathVariable Long id, @RequestBody @Valid JogoDto dto) {
		return service.alterar(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
