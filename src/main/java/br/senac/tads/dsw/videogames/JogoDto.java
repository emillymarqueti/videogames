package br.senac.tads.dsw.videogames;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogoDto(
	Long id,
	@NotBlank(message = "O título é obrigatório")
	String titulo,
	@NotNull(message = "O ano de lançamento é obrigatório")
	@Min(value = 1950, message = "O ano de lançamento deve ser maior ou igual a 1950")
	Integer anoLancamento,
	@NotNull(message = "A plataforma é obrigatória")
	Long plataformaId,
	String plataformaNome,
	@NotNull(message = "A disponibilidade é obrigatória")
	Boolean disponivel,
	String observacoes
) {
}
