package kleberlz.ms_eventos.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kleberlz.ms_eventos.model.CategoriaEvento;
import kleberlz.ms_eventos.model.Status;
import kleberlz.ms_eventos.model.TipoEvento;

public class EventoDetalhadoDTO {

	private Long idEvento;

	@NotBlank(message = "O nome do evento não deve estar em branco.")
	@Size(min = 2, max = 100, message = "Fora do tamanho padrão permitido.")
	private String nomeEvento;

	@NotBlank(message = "A descrição do evento não deve estar em branco.")
	@Size(min = 10, max = 50, message = "Fora do tamanho padrão permitido.")
	private String descricao;

	@NotNull(message = "A categoria do evento é obrigatória.")
	private CategoriaEvento categoria;

	@NotNull(message = "O tipo do evento é obrigatório.")
	private TipoEvento tipo;

	@NotNull(message = "A data e hora do evento é obrigatória.")
	private LocalDateTime dataHora;

	@NotBlank(message = "O endereço do evento não deve estar em branco.")
	private String endereco;

	@NotNull(message = "O status do evento é obrigatório.")
	private Status status;

	@NotNull(message = "A quantidade de ingressos total é obrigatória.")
	@Min(value = 1, message = "A quantidade de ingressos total deve ser no mínimo 1. ")
	private Integer quantidadeIngressos;

	@NotNull(message = "A quantidade de ingressos disponiveis é obrigatória.")
	@Min(value = 0, message = "A quantidade de ingressos disponiveis deve ser no minimo 0. ")
	private Integer ingressosDisponiveis;

	public EventoDetalhadoDTO(Long idEvento, String nomeEvento, String descricao, CategoriaEvento categoria,
			TipoEvento tipo, LocalDateTime dataHora, String endereco, Status status, Integer quantidadeIngressos,
			Integer ingressosDisponiveis) {

		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.descricao = descricao;
		this.categoria = categoria;
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.endereco = endereco;
		this.status = status;
		this.quantidadeIngressos = quantidadeIngressos;
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	public EventoDetalhadoDTO() {

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

}
