package kleberlz.ms_eventos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataHoraInvalidaException.class)
	public ResponseEntity<ErroResposta> handleDataHoraInvalida(DataHoraInvalidaException ex) {
		ErroResposta erro = new ErroResposta(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), "Data e hora inválidos.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(EnderecoInvalidoException.class)
	public ResponseEntity<ErroResposta> handleEnderecoInvalido(EnderecoInvalidoException ex) {
		ErroResposta erro = new ErroResposta(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), "Endereco inválido.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(NomeEventoInvalidoException.class)
	public ResponseEntity<ErroResposta> handleNomeEventoInvalido(NomeEventoInvalidoException ex) {
		ErroResposta erro = new ErroResposta(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), "Nome inválido.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
