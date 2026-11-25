package br.senac.tads.dsw.videogames;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

	private final PlataformaService service;

	public PlataformaController(PlataformaService service) {
		this.service = service;
	}

	@GetMapping
	public List<PlataformaDto> listar() {
		return service.listarTodas();
	}

	@PostMapping
	public ResponseEntity<PlataformaDto> incluir(@RequestBody @Valid PlataformaDto dto) {
		PlataformaDto salvo = service.incluir(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
}