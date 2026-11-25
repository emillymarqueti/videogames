package br.senac.tads.dsw.videogames.entidade;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo")
public class JogoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String titulo;

	@Column(nullable = false)
	private Integer anoLancamento;

	//Relacionamento: vários jogos podem pertencer a uma mesma plataforma
	@ManyToOne(optional = false)
	@JoinColumn(name = "plataforma_id", nullable = false)
	private PlataformaEntity plataforma;

	@Column(nullable = false)
	private Boolean disponivel;

	@Column(length = 500)
	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public PlataformaEntity getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaEntity plataforma) {
		this.plataforma = plataforma;
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
