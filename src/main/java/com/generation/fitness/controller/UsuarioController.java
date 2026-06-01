package com.generation.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.fitness.model.Usuario;
import com.generation.fitness.repository.UsuarioRepository;

import jakarta.validation.Valid;

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
	    return usuarioRepository.findById(id)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioRepository.save(usuario));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.findById(usuario.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(usuarioRepository.save(usuario)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
		
		@PostMapping("/logar")
		public ResponseEntity<Usuario> autenticar(@Valid @RequestBody Usuario usuarioLogin) {
			return usuarioRepository.findByUsuario(usuarioLogin.getUsuario())
					.filter(usuarioBanco -> usuarioBanco.getSenha().equals(usuarioLogin.getSenha()))
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			return usuarioRepository.findById(id)
					.map(resposta -> {
						usuarioRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					})
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
	}
