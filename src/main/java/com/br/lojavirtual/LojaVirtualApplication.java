package com.br.lojavirtual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.lojavirtual.domain.Categoria;
import com.br.lojavirtual.repositories.CategoriaRepository;

@SpringBootApplication
public class LojaVirtualApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}
	//Metodo auxiliar para executar a operaçao de instanciação  savar a lista quando a aplicacao iniciar
	@Override
	public void run(String... args) throws Exception {
		
		  Categoria cat1 = new Categoria(null,"Informatica");
		  Categoria cat2 = new Categoria(null,"Escritorio");
		  
		  categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		 
	}
		
} 