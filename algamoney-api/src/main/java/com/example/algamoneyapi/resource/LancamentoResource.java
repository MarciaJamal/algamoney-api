package com.example.algamoneyapi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.model.Lancamento;
import com.example.algamoneyapi.repository.LancamentoRepository;
import com.example.algamoneyapi.repository.filter.LancamentoFilter;
import com.example.algamoneyapi.service.LancamentoService;
import com.example.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

 @Autowired
 private LancamentoRepository lancamentoRepository;
 
 @Autowired
 private LancamentoService lancamentoService;

 @Autowired
 private MessageSource messageSource;
 
 @GetMapping
 public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
	 
	@PostMapping("/save")
	public Lancamento criar(@Valid @RequestBody Lancamento lancamento) throws Exception {
		lancamento = lancamentoService.salvar(lancamento);
           return lancamento;
	 }
	 @ExceptionHandler
	 public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex)
	 {
		 
		 String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		// String mensagemDesenvolvedor = ex.toString();
		 //List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(mensagemUsuario);
		 
	 }
	
	 @GetMapping("/{codigo}")
	 public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo)
	 {
		 Lancamento lancamento = lancamentoRepository.findByCodigo(codigo);
		 return lancamento != null ? ResponseEntity.ok(lancamento): ResponseEntity.notFound().build();
	 }
	 
	 @DeleteMapping("/{codigo}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public ResponseEntity<Boolean> remover(@PathVariable Long codigo)
	 {
		 try {
		       Lancamento lancamento = lancamentoRepository.findByCodigo(codigo);
		       lancamentoRepository.delete(lancamento);
		       return ResponseEntity.ok(true);
		 }
		 catch(Exception exception)
		 {
			 
		       return ResponseEntity.ok(false);

		 }
			 
		 
	 }
}
	 