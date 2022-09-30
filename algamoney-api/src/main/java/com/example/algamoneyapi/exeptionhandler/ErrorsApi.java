package com.example.algamoneyapi.exeptionhandler;

import org.springframework.http.HttpStatus;

public class ErrorsApi {

	private boolean result;
    private HttpStatus httpStatus;
    private Object object;
    private String mensagemDesenvolvedor;
    private String mensagemUsuario;

    public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}

	public boolean isResult() {
        return this.result;
    }

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    public ErrorsApi() {
    }


    public ErrorsApi(boolean result, HttpStatus httpStatus, Object object) {
        this.result = result;
        this.httpStatus = httpStatus;
        this.object = object;
    }

	public ErrorsApi(HttpStatus httpStatus, String mensagemDesenvolvedor, String mensagemUsuario) {
		super();
		this.httpStatus = httpStatus;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		this.mensagemUsuario = mensagemUsuario;
	}

}
