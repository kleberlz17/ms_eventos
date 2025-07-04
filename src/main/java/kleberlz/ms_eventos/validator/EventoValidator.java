package kleberlz.ms_eventos.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import kleberlz.ms_eventos.exceptions.DataHoraInvalidaException;
import kleberlz.ms_eventos.exceptions.EnderecoInvalidoException;
import kleberlz.ms_eventos.exceptions.NomeEventoInvalidoException;

@Component
public class EventoValidator {

	
	public void validarDataHora(LocalDateTime dataHora) {
		// Não pode cadastrar evento anterior a data do dia que está sendo cadastrado.
		LocalDateTime agora = LocalDateTime.now(); 
	
		if (dataHora.isBefore(agora)) {
			throw new DataHoraInvalidaException("A data e hora do evento não pode ser no passado.");
		}
	}
	
	public void validarNome(String nomeEvento) {
		if (nomeEvento == null || nomeEvento.isBlank()) {
			throw new NomeEventoInvalidoException("O nome do evento não pode ser nulo ou em branco.");
		}
	}
	
	public void validarEndereco(String endereco) {
		if (endereco == null || endereco.isBlank()) {
			throw new EnderecoInvalidoException("O endereço do evento não pode ser nulo ou em branco.");
		}
	}
}
