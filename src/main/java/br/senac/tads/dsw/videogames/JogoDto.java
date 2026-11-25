package br.senac.tads.dsw.videogames;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JogoDto {

	private Integer id;

	@NotBlank(message = "O título é obrigatório")
	@Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
	private String titulo;

	@NotNull(message = "O ano de lançamento é obrigatório")
	@Min(value = 1950, message = "O ano de lançamento deve ser maior ou igual a 1950")
	private Integer anoLancamento;

	@NotNull(message = "A plataforma é obrigatória")
	private Integer plataformaId;

	private String plataformaNome;

	@NotNull(message = "A disponibilidade é obrigatória")
	private Boolean disponivel;

	@Size(max = 500, message = "As observações devem ter no máximo 500 caracteres")
	private String observacoes;

	public JogoDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Integer getPlataformaId() {
		return plataformaId;
	}

	public void setPlataformaId(Integer plataformaId) {
		this.plataformaId = plataformaId;
	}

	public String getPlataformaNome() {
		return plataformaNome;
	}

	public void setPlataformaNome(String plataformaNome) {
		this.plataformaNome = plataformaNome;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}