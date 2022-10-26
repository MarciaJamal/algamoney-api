package com.example.algamoneyapi.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa actualizar(Long codigo, Pessoa pessoa)
	{
		 Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
			 BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
			return pessoaRepository.save(pessoaSalva);
	}

	

	public void actualizarPropriedadeActivo(Long codigo, Boolean activo) {
		Pessoa pessoaSalva=buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setActivo(activo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findByCodigo(codigo);
			 if(pessoaSalva  == null)
			 {
				 throw new EmptyResultDataAccessException(1);
			 }
		return pessoaSalva;
	}
}
