package kleberlz.ms_eventos.mapper;

import org.springframework.stereotype.Component;

import kleberlz.ms_eventos.dto.EventoDetalhadoDTO;
import kleberlz.ms_eventos.model.Evento;

@Component
public class EventoMapper {
	
	public Evento dtoParaEntidade(EventoDetalhadoDTO dto) {
		Evento evento = new Evento();
		evento.setIdEvento(dto.getIdEvento());
		evento.setNomeEvento(dto.getNomeEvento());
		evento.setCategoria(dto.getCategoria());
		evento.setTipo(dto.getTipo());
		evento.setDescricao(dto.getDescricao());
		evento.setDataHora(dto.getDataHora());
		evento.setEndereco(dto.getEndereco());
		evento.setStatus(dto.getStatus());
		evento.setQuantidadeIngressos(dto.getQuantidadeIngressos());
		evento.setIngressosDisponiveis(dto.getIngressosDisponiveis());
		
		return evento;
	}
	
	public EventoDetalhadoDTO entidadeParaDTO(Evento entidade) {
		return new EventoDetalhadoDTO(
				entidade.getIdEvento(),
				entidade.getNomeEvento(),
				entidade.getDescricao(),
				entidade.getCategoria(),
				entidade.getTipo(),
				entidade.getDataHora(),
				entidade.getEndereco(),
				entidade.getStatus(),
				entidade.getQuantidadeIngressos(),
				entidade.getIngressosDisponiveis()
				);
	}

}
