package br.senac.tads.dsw.videogames;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
