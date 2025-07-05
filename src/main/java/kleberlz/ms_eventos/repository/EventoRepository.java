package kleberlz.ms_eventos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.ms_eventos.model.CategoriaEvento;
import kleberlz.ms_eventos.model.Evento;
import kleberlz.ms_eventos.model.Status;
import kleberlz.ms_eventos.model.TipoEvento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	List<Evento> findByNomeEventoContainingIgnoreCase(String nomeEvento);
	
	List<Evento> findByCategoriaEvento(CategoriaEvento categoria);
	
	List<Evento> findByTipoEvento(TipoEvento tipo);
	
	List<Evento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
	
	List<Evento> findByEndereco(String endereco);
	
	List<Evento> findByStatus(Status status);
	
	List<Evento> findByQuantidadeIngressos(Integer quantidadeIngressos);
	
	List<Evento> findByIngressosDisponiveis(Integer ingressosDisponiveis);
}
