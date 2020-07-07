package com.br.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.lojavirtual.domain.Pedido;

@Repository
public interface  PedidoRepository extends  JpaRepository<Pedido, Integer> {

}
