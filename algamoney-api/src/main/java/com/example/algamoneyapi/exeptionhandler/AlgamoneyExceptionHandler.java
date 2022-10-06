package com.example.algamoneyapi.exeptionhandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AlgamoneyExceptionHandler {

	// @Autowired
	// private MessageSource messageSource;
	@ExceptionHandler(value = {
			MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorsApi> handleHttpMessageRedable() {
		String mensagemUsuario = "Erro";
		String mensagemDesenvolvedor = "teste";
		// List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario,
		// mensagemDesenvolvedor));
		return new ResponseEntity<>(new ErrorsApi(HttpStatus.BAD_REQUEST, mensagemUsuario, mensagemDesenvolvedor),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { EmptyResultDataAccessException.class })
	public HandleErr handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {
		String mensagemUsuario = "recurso nao encontrado";
		String mensagemDesenvolvedor = ex.toString();
		return new HandleErr(ex, mensagemUsuario, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	// protected ResponseEntity<Object>
	// handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	// HttpHeaders headers, HttpStatus status, WebRequest request )
	// {
	// List<Erro> erros = criarListaDeErros(ex.getBindingResult());
	// return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST,
	// request);
	//
	// }



	private class HandleErr {

		private EmptyResultDataAccessException ex;
		private String mensagemUsuario;
		private HttpHeaders httpHeaders;
		private HttpStatus notFound;
		private WebRequest request;
		public EmptyResultDataAccessException getEx() {
			return this.ex;
		}
	
		public void setEx(EmptyResultDataAccessException ex) {
			this.ex = ex;
		}
	
		public String getMensagemUsuario() {
			return this.mensagemUsuario;
		}
	
		public void setMensagemUsuario(String mensagemUsuario) {
			this.mensagemUsuario = mensagemUsuario;
		}
	
		public HttpHeaders getHttpHeaders() {
			return this.httpHeaders;
		}
	
		public void setHttpHeaders(HttpHeaders httpHeaders) {
			this.httpHeaders = httpHeaders;
		}
	
		public HttpStatus getNotFound() {
			return this.notFound;
		}
	
		public void setNotFound(HttpStatus notFound) {
			this.notFound = notFound;
		}
	
		public WebRequest getRequest() {
			return this.request;
		}
	
		public void setRequest(WebRequest request) {
			this.request = request;
		}

		public HandleErr(EmptyResultDataAccessException ex, String mensagemUsuario, HttpHeaders httpHeaders, HttpStatus notFound, WebRequest request) {
			this.ex = ex;
			this.mensagemUsuario = mensagemUsuario;
			this.httpHeaders = httpHeaders;
			this.notFound = notFound;
			this.request = request;
		}

	}
	// private List<Erro> criarListaDeErros(BindingResult bindingResult)
	// {
	// List<Erro> erros = new ArrayList<>();
	//
	// for(FieldError fieldError :bindingResult.getFieldErrors())
	// {
	// String mensagemUsuario = messageSource.getMessage(fieldError,
	// LocaleContextHolder.getLocale()) ;
	// String mensagemDesenvolvedor = fieldError.toString();
	// erros.add(new Erro(mensagemUsuario,mensagemDesenvolvedor));
	// }
	// return erros;
	// }
	//

	// public static class Erro {
	// private String mensagemUsuario;
	// private String mensagemDesenvolvedor;
	//
	//
	// public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
	// super();
	// this.mensagemUsuario = mensagemUsuario;
	// this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	// }
	//
	// public String getMensagemUsuario() {
	// return mensagemUsuario;
	// }
	//
	// public String getMensagemDesenvolvedor() {
	// return mensagemDesenvolvedor;
	// }
	//
	// }
}
