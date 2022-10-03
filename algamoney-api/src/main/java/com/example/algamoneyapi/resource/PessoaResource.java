package com.example.algamoneyapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;
import java.util.List;
import javax.validation.Valid;
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
	public Pessoa criar(@Valid @RequestBody Pessoa pessoa) throws Exception {
		pessoa = pessoaRepository.save(pessoa);
           return pessoa;
	 }
	 
	 @GetMapping("/{codigo}")
	 public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo)
	 {
		 Pessoa pessoa = pessoaRepository.findByCodigo(codigo);
		 return pessoa != null ? ResponseEntity.ok(pessoa): ResponseEntity.notFound().build();
	 }

}

