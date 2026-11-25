package br.senac.tads.dsw.videogames.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_jogos")
public class JogoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String titulo;

	@Column(name = "ano_lancamento", nullable = false)
	private Integer anoLancamento;

	// Relacionamento: vários jogos podem pertencer a uma plataforma
	@ManyToOne(optional = false)
	@JoinColumn(name = "plataforma_id", nullable = false)
	private PlataformaEntity plataforma;

	@Column(nullable = false)
	private Boolean disponivel;

	@Column(length = 500)
	private String observacoes;

	public JogoEntity() {
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