package com.generation.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.fitness.model.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    public List<Categoria> findAllByDescricaoContainingIgnoreCase(String  descricao);
}