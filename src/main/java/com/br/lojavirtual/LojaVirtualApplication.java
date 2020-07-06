package com.br.lojavirtual;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.br.lojavirtual.domain.Categoria;
import com.br.lojavirtual.domain.Produto;
import com.br.lojavirtual.repositories.CategoriaRepository;
import com.br.lojavirtual.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaVirtualApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}
	//Metodo auxiliar para executar a operaçao de instanciação  savar a lista quando a aplicacao iniciar
	@Override
	public void run(String... args) throws Exception {
		
		  Categoria cat1 = new Categoria(null,"Informatica");
		  Categoria cat2 = new Categoria(null,"Escritorio");
		  
		 
		  Produto p1 = new Produto(null,"Computador", 2000.00);
		  Produto p2 = new Produto(null,"Impressora", 800.00);
		  Produto p3 = new Produto(null,"Mouse", 80.00);
		 
		  
		  //Implementacao do diagrama de instancia com relacionamento muitos para muitos entre categoria e produto
		  cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		  cat2.getProdutos().addAll(Arrays.asList(p2));
		  
		  p1.getCategorias().addAll(Arrays.asList(cat1));
		  p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		  p3.getCategorias().addAll(Arrays.asList(cat1));
	
		  categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		  produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
		
} 