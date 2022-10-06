package com.example.algamoneyapi.dto;

import javax.validation.constraints.NotNull;

import com.example.algamoneyapi.model.Endereco;

public class PersonRequest { 
    @NotNull
	private String nome;
	private Endereco endereco;
    @NotNull
	private Boolean activo;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean isActivo() {
        return this.activo;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
