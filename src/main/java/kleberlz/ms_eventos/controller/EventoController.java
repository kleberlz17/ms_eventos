package kleberlz.ms_eventos.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kleberlz.ms_eventos.dto.EventoDetalhadoDTO;
import kleberlz.ms_eventos.mapper.EventoMapper;
import kleberlz.ms_eventos.model.CategoriaEvento;
import kleberlz.ms_eventos.model.Evento;
import kleberlz.ms_eventos.model.Status;
import kleberlz.ms_eventos.model.TipoEvento;
import kleberlz.ms_eventos.service.EventoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/eventos")
@Slf4j
public class EventoController {
	
	private final EventoService eventoService;
	private final EventoMapper eventoMapper;
	
	public EventoController(EventoService eventoService, EventoMapper eventoMapper) {
		this.eventoService = eventoService;
		this.eventoMapper = eventoMapper;
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar (@RequestBody @Valid EventoDetalhadoDTO eventoDTO) {
		log.info("Iniciando salvamento de novo evento no sistema...");
		Evento evento = eventoMapper.dtoParaEntidade(eventoDTO);
		Evento eventoSalvo = eventoService.salvarInterno(evento);
		
		URI uri = URI.create("/eventos/" + eventoSalvo.getIdEvento());
		
		log.info("Evento salvo com sucesso. ID gerado: {}", eventoSalvo.getIdEvento());
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{idEvento}")
	public ResponseEntity<Evento> buscarPorId (@PathVariable Long idEvento) {
		log.info("Buscando evento pelo ID no sistema...");
		Optional<Evento> evento = eventoService.buscarPorId(idEvento);
		
		if (evento.isPresent()) {
			log.info("Evento encontrado pelo ID com sucesso.");
			return ResponseEntity.ok(evento.get());
		} else {
			log.error("Evento não encontrado, ID inexistente no sistema.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nomeEvento/{nomeEvento}")
	public ResponseEntity<List<Evento>> buscarPorNomeEvento (@PathVariable String nomeEvento) {
		log.info("Buscando evento(s) pelo nome no sistema...");
		List<Evento> eventoNome = eventoService.buscarPorNomeEvento(nomeEvento);
		
		if(eventoNome.isEmpty()) {
			log.error("Evento não encontrado, nome inexistente no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pelo nome com sucesso.");
			return ResponseEntity.ok(eventoNome);
		}
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Evento>> buscarPorCategoria (@RequestBody @Valid CategoriaEvento categoria) {
		log.info("Buscando evento(s) pela categoria no sistema...");
		List<Evento> eventoCategoria = eventoService.buscarPorCategoria(categoria);
		
		if(eventoCategoria.isEmpty()) {
			log.error("Não há eventos com a categoria buscada no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pela categoria com sucesso.");
			return ResponseEntity.ok(eventoCategoria);
		}	
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Evento>> buscarPorTipo (@RequestBody @Valid TipoEvento tipo) {
		log.info("Buscando evento(s) pelo tipo no sistema...");
		List<Evento> eventoTipo = eventoService.buscarPorTipo(tipo);
		
		if(eventoTipo.isEmpty()) {
			log.error("Não há eventos com o tipo buscado no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pelo tipo com sucesso.");
			return ResponseEntity.ok(eventoTipo);
		}
	}
	
	@GetMapping("/data/{data}")
	public ResponseEntity<List<Evento>> buscarPorData (@PathVariable LocalDate data) {
		log.info("Buscando evento(s) pela data no sistema...");
		List<Evento> eventoData = eventoService.buscarPorData(data);
		
		if(eventoData.isEmpty()) {
			log.error("Não há eventos agendados com a data buscada no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pela data com sucesso.");
			return ResponseEntity.ok(eventoData);
		}	
	}
	
	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Evento>> buscarPorEndereco (@PathVariable String endereco) {
		log.info("Buscando evento(s) pelo endereço no sistema...");
		List<Evento> eventoEndereco = eventoService.buscarPorEndereco(endereco);
		
		if(eventoEndereco.isEmpty()) {
			log.error("Não há eventos agendados pro endereço buscado no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pelo endereço com sucesso.");
			return ResponseEntity.ok(eventoEndereco);
		}
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Evento>> buscarPorStatus (@RequestBody @Valid Status status) {
		log.info("Buscando evento(s) pelo status no sistema...");
		List<Evento> eventoStatus = eventoService.buscarPorStatus(status);
		
		if(eventoStatus.isEmpty()) {
			log.error("Não há eventos com o status buscado no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pelo status com sucesso.");
			return ResponseEntity.ok(eventoStatus);
		}
	}
	
	@GetMapping("/quantidade/{quantidadeIngressos}")
	public ResponseEntity<List<Evento>> buscarPorQuantidadeIngressos (@PathVariable Integer quantidadeIngressos) {
		log.info("Buscando evento(s) pela quantidade de ingressos total no sistema...");
		List<Evento> eventoQtdIngressos = eventoService.buscarPorQuantidadeIngressos(quantidadeIngressos);
		
		if(eventoQtdIngressos.isEmpty()) {
			log.error("Não há eventos com a quantidade de ingressos total buscada no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pela quantidade de ingressos total com sucesso.");
			return ResponseEntity.ok(eventoQtdIngressos);
		}
	}
	
	@GetMapping("/disponiveis/{ingressosDisponiveis}")
	public ResponseEntity<List<Evento>> buscarPorIngressosDisponiveis (@PathVariable Integer ingressosDisponiveis) {
		log.info("Buscando evento(s) por ingressos disponiveis no sistema...");
		List<Evento> eventoIngDisponiveis = eventoService.buscarPorIngressosDisponiveis(ingressosDisponiveis);
		
		if(eventoIngDisponiveis.isEmpty()) {
			log.error("Não há eventos com a quantidade de ingressos disponíveis buscada no sistema.");
			return ResponseEntity.notFound().build();
		} else {
			log.info("Evento(s) encontrado(s) pela quantidade de ingressos disponíveis com sucesso.");
			return ResponseEntity.ok(eventoIngDisponiveis);
		}
	}
	
	@DeleteMapping("/{idEvento}/deletar")
	public ResponseEntity<Void> deletarEventoPorId (@PathVariable Long idEvento) {
		log.info("Deletando evento de ID {} do sistema...", idEvento);
		eventoService.deletarEventoPorId(idEvento);
		
		log.info("Evento foi deletado com sucesso.");
		return ResponseEntity.noContent().build();
	}
	
	

}
