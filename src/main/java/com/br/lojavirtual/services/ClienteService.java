package com.br.lojavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lojavirtual.domain.Cliente;
import com.br.lojavirtual.repositories.ClienteRepository;
import com.br.lojavirtual.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private  ClienteRepository repo;
	
	
	public Cliente find(Integer id) { 
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(    "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
		}
	
	
	
}
