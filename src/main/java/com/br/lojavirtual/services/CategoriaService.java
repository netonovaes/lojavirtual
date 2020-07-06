package com.br.lojavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lojavirtual.domain.Categoria;
import com.br.lojavirtual.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private  CategoriaRepository repo;
	
	/*
	 * public Categoria buscar(Integer id) { Categoria obj = repo.findOne(id);
	 * return obj; }
	 */
	
	public Categoria buscar(Integer id) { 
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		}
	
	
	
}
