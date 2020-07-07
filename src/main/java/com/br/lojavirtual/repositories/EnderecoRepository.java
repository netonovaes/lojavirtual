package com.br.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.lojavirtual.domain.Endereco;

@Repository
public interface  EnderecoRepository extends  JpaRepository<Endereco, Integer> {

}
