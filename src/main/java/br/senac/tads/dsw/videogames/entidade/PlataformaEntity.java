package br.senac.tads.dsw.videogames.entidade;

import jakarta.persistence.*;

// Tabela separada para as plataformas
@Entity
@Table(name = "plataforma")
public class PlataformaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
