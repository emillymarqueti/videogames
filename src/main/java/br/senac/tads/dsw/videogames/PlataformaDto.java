package br.senac.tads.dsw.videogames;

import jakarta.validation.constraints.NotBlank;

public record PlataformaDto(
	Long id,
	@NotBlank(message = "O nome da plataforma é obrigatório")
	String nome
) {
}
