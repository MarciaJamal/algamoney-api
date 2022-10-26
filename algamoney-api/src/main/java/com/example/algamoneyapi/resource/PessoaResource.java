package com.example.algamoneyapi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.dto.PersonRequest;
//import com.example.algamoneyapi.dto.PersonRequest;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;
import com.example.algamoneyapi.service.PessoaService;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

 @Autowired
 private PessoaRepository pessoaRepository;
 
 @Autowired
 private PessoaService pessoaService;
 
 @GetMapping
 public List<Pessoa> listar()
 {
	return pessoaRepository.findAll();
 }
	 
	@PostMapping("/save")
	public Pessoa criar(@Valid @RequestBody PersonRequest personRequest) throws Exception {
		Pessoa pessoa = new Pessoa();
		BeanUtils.copyProperties(personRequest, pessoa);
		pessoa = pessoaRepository.save(pessoa);
           return pessoa;
	 }
	 
	 @GetMapping("/{codigo}")
	 public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo)
	 {
		 Pessoa pessoa = pessoaRepository.findByCodigo(codigo);
		 return pessoa != null ? ResponseEntity.ok(pessoa): ResponseEntity.notFound().build();
	 }
	 
	 @DeleteMapping("/{codigo}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public ResponseEntity<Boolean> remover(@PathVariable Long codigo)
	 {
		 try {
		       Pessoa pessoa = pessoaRepository.findByCodigo(codigo);
		       pessoaRepository.delete(pessoa);
		       return ResponseEntity.ok(true);
		 }
		 catch(Exception exception)
		 {
			 
		       return ResponseEntity.ok(false);

		 }
			 
		 
	 }

	 
	 @PutMapping("/{codigo}")
		 public ResponseEntity<Pessoa>actualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa)
		 {
			 Pessoa pessoaSalva = pessoaService.actualizar(codigo,pessoa);
			 return ResponseEntity.ok(pessoaSalva);
		 }
		 
	 @PutMapping("/{codigo}/activo")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void actualizarPropriedadeActivo(@PathVariable Long codigo,@RequestBody Boolean activo)
	 {
		 pessoaService.actualizarPropriedadeActivo(codigo,activo);
	 }
}

