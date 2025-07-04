package kleberlz.ms_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kleberlz.ms_eventos.dto.EventoDetalhadoDTO;
import kleberlz.ms_eventos.exceptions.DataHoraInvalidaException;
import kleberlz.ms_eventos.mapper.EventoMapper;
import kleberlz.ms_eventos.model.CategoriaEvento;
import kleberlz.ms_eventos.model.Evento;
import kleberlz.ms_eventos.repository.EventoRepository;
import kleberlz.ms_eventos.validator.EventoValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventoService {

	private final EventoRepository eventoRepository;
	private final EventoValidator eventoValidator;
	private final EventoMapper eventoMapper;
	
	public EventoService(EventoRepository eventoRepository, EventoValidator eventoValidator, EventoMapper eventoMapper) {
		this.eventoRepository = eventoRepository;
		this.eventoValidator = eventoValidator;
		this.eventoMapper = eventoMapper;
	}
	
	//Cadastro interno, feito pelo sistema, sem DTO.
	public Evento salvarInterno(Evento evento) {
		
		eventoValidator.validarNome(evento.getNomeEvento());
		eventoValidator.validarEndereco(evento.getEndereco());
		
		if (evento.getDataHora() == null) {
			throw new DataHoraInvalidaException("A data e hora do evento não pode ser nula.");
		}
		
		eventoValidator.validarDataHora(evento.getDataHora());
	
		evento = eventoRepository.save(evento);
		log.info("Evento salvo com o nome: {}", evento.getNomeEvento());
		
		return evento;
	}
	
	// Cadastro vindo de fora (usuário externo)
	public EventoDetalhadoDTO salvar(EventoDetalhadoDTO dto) { //MOVER ESSE MÉTODO PARA O MS-USUARIOS
		
		eventoValidator.validarDataHora(dto.getDataHora());
		
		//Converte o DTO recebido em entidade.
		Evento evento = eventoMapper.dtoParaEntidade(dto);
		
		//Salva como entidade.
		evento = eventoRepository.save(evento);
		log.info("Evento salvo com o nome: {}", evento.getNomeEvento());
		
		//Converte a entidade salva para DTO novamente e retorna, agora com ID.
		return eventoMapper.entidadeParaDTO(evento);
	}
	
	public Optional<Evento> buscarPorId(Long idEvento) {
		
		Optional<Evento> evento = eventoRepository.findById(idEvento);
		log.info("Buscando pelo ID: '{}'. Evento encontrado: {}", idEvento, evento);
		return evento;
	}
	
	public List<Evento> buscarPorNomeEvento(String nomeEvento) {
		
		List<Evento> eventos = eventoRepository.findByNomeEventoContainingIgnoreCase(nomeEvento);
		log.info("Buscando pelo nome do evento: '{}'. Evento(s) encontrado(s): {}", nomeEvento, eventos);
		return eventos;
	}
	
	public List<Evento> buscarPorCategoria(CategoriaEvento categoria) {
		
		List<Evento> eventos = eventoRepository.findByCategoriaEvento(categoria);
		log.info("Buscando eventos pela categoria: '{}'. Evento(s) encontrado(s): {}", categoria, eventos);
		return eventos;
	}
	
	
			
}
