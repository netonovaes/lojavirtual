package com.br.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.lojavirtual.domain.ItemPedido;

@Repository
public interface  ItemPedidoRepository extends  JpaRepository<ItemPedido, Integer> {

}
