package com.br.lojavirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.lojavirtual.domain.Categoria;
import com.br.lojavirtual.repositories.CategoriaRepository;
import com.br.lojavirtual.services.exceptions.DataIntegrityException;
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
	//Metodo delete
	public void delete(Integer id) {
		
		find(id);// verifica se o objeto existe e lança uma exceção  personalizada do metodo find
		
		try {
		repo.deleteById(id);
	}
	 catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");	 
	 
	 }
    }
	public List<Categoria> findAll(){
		return repo.findAll();
		
	}
	public  Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy,String direction){
			PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
	}
}
