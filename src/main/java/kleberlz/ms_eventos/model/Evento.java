package kleberlz.ms_eventos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento", nullable = false)
	private Long idEvento;

	@Column(name = "nome_evento", nullable = false)
	private String nomeEvento;

	@Enumerated(EnumType.STRING)
	private CategoriaEvento categoria;

	@Enumerated(EnumType.STRING)
	private TipoEvento tipo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data_hora", nullable = false)
	private LocalDateTime dataHora;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "quantidade_ingressos", nullable = false)
	private Integer quantidadeIngressos;

	@Column(name = "ingressos_disponiveis", nullable = false)
	private Integer ingressosDisponiveis;

	public Evento(Long idEvento, String nomeEvento, CategoriaEvento categoria, TipoEvento tipo, String descricao,
			LocalDateTime dataHora, String endereco, Status status, Integer quantidadeIngressos,
			Integer ingressosDisponiveis) {

		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.categoria = categoria;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.endereco = endereco;
		this.status = status;
		this.quantidadeIngressos = quantidadeIngressos;
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	public Evento() {

	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public CategoriaEvento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEvento categoria) {
		this.categoria = categoria;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(Integer quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public Integer getIngressosDisponiveis() {
		return ingressosDisponiveis;
	}

	public void setIngressosDisponiveis(Integer ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nomeEvento=" + nomeEvento + ", categoria=" + categoria + ", tipo="
				+ tipo + ", descricao=" + descricao + ", dataHora=" + dataHora + ", endereco=" + endereco + ", status="
				+ status + ", quantidadeIngressos=" + quantidadeIngressos + ", ingressosDisponiveis="
				+ ingressosDisponiveis + "]";
	}

}
