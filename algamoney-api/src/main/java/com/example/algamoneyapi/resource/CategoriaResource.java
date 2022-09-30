package com.example.algamoneyapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.repository.CategoriaRepository;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource 
{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
    @GetMapping
	public List<Categoria> listar()
   {
		return categoriaRepository.findAll();
   }
 
 @PostMapping("/save")
 public Categoria criar(@Valid @RequestBody Categoria categoria) throws Exception {
	 if(categoria.getNome() ==null) {
		 throw new Exception("Mensagem invalida");
	 }
	 categoria = categoriaRepository.save(categoria);
//	 URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").
//	    buildAndExpand(categoriaSalva.getCodigo()).toUri();
//	 response.setHeader("Location", uri.toASCIIString());
//	 
	 return categoria;
 }
 
 @GetMapping("/{codigo}")
 public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo)
 {
	 Categoria categoria = categoriaRepository.findByCodigo(codigo);
	 return categoria != null ? ResponseEntity.ok(categoria): ResponseEntity.notFound().build();
 }

}
