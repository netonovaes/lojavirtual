package com.br.lojavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lojavirtual.domain.Categoria;
import com.br.lojavirtual.repositories.CategoriaRepository;
import com.br.lojavirtual.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private  CategoriaRepository repo;
	
	
	public Categoria find(Integer id) { 
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(    "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		}
	//Metodo de inserir
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	// Metodo updade
	public Categoria update(Categoria obj) {
		find(obj.getId());// verifica se o objeto existe e lança uma exceção  personalizada do metodo find
		return repo.save(obj);
	}
	
}
