package com.generation.fitness.controller;

import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.generation.fitness.model.Produto;
import com.generation.fitness.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")  //busca produto por ID
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

 
    @PostMapping // criar um novo produto
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));
    }

    @PutMapping // atualizar produto
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {
        if (produto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID do produto deve ser informado!");
        }
        
        return produtoRepository.findById(produto.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}") //excluir produto
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        
        if(produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
        
        produtoRepository.deleteById(id);
    }
    
    @GetMapping("/nome/{nome}") // procura por nome do produto
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }
}
