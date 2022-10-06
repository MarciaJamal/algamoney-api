package com.example.algamoneyapi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.dto.PersonRequest;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

 @Autowired
 private PessoaRepository pessoaRepository;
		
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
	 
	 @DeleteMapping
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void remover(@PathVariable Long codigo)
	 {
		  pessoaRepository.delete(codigo);
	 }

}

