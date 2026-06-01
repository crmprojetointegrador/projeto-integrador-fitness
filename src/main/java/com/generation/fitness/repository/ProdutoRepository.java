package com.generation.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.fitness.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   
	
}