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
	
	
	
}
