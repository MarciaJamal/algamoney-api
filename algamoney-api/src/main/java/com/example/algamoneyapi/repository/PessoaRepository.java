package com.example.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.algamoneyapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
   
	public Pessoa findByCodigo(Long codigo);

	@Modifying
	public void deleteByCodigo(Long codigo);

	//public Pessoa findOne(Long codigo);
	
}