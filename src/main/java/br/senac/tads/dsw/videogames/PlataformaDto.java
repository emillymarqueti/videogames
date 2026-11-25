package br.senac.tads.dsw.videogames;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlataformaDto {

	private Integer id;

	@NotBlank(message = "O nome da plataforma é obrigatório")
	@Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
	private String nome;

	public PlataformaDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}