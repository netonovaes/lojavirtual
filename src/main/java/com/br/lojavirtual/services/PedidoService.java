package com.br.lojavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lojavirtual.domain.Pedido;
import com.br.lojavirtual.repositories.PedidoRepository;
import com.br.lojavirtual.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private  PedidoRepository repo;
	
	
	public Pedido find(Integer id) { 
		Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
		}
	
	
	
}
