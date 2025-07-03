package kleberlz.ms_eventos.dto;

import java.time.LocalDateTime;

public class EventoCompraDTO { // DTO que se comunicará com o ms-compras;

	private Long idEvento;
	private String nomeEvento;
	private Integer quantidadeIngressosComprados;
	private String endereco;
	private LocalDateTime dataHora;

	public EventoCompraDTO(Long idEvento, String nomeEvento, Integer quantidadeIngressosComprados,
			String endereco, LocalDateTime dataHora) {

		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.quantidadeIngressosComprados = quantidadeIngressosComprados;
		this.endereco = endereco;
		this.dataHora = dataHora;
	}

	public EventoCompraDTO() {

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

	public Integer getQuantidadeIngressosComprados() {
		return quantidadeIngressosComprados;
	}

	public void setQuantidadeIngressosComprados(Integer quantidadeIngressosComprados) {
		this.quantidadeIngressosComprados = quantidadeIngressosComprados;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
