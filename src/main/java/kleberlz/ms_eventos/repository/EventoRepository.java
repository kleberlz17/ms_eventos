package kleberlz.ms_eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.ms_eventos.model.CategoriaEvento;
import kleberlz.ms_eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	List<Evento> findByNomeEventoContainingIgnoreCase(String nomeEvento);
	
	List<Evento> findByCategoriaEvento(CategoriaEvento categoria);
}
