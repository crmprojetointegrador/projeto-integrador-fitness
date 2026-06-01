package com.generation.fitness.service;

import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    public Imc calcularIMC(Double peso, Double altura) {
        if (peso == null || altura == null || altura <= 0 || peso <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser valores maiores que zero!");
        }

        // peso dividido por altura ao quadrado
        double imcValor = peso / (altura * altura);
        
        // arredonda 
        imcValor = Math.round(imcValor * 100.0) / 100.0;

        // define o grau/classificação
        String classificacao;
        if (imcValor < 18.5) {
            classificacao = "Abaixo do peso";
            
        } else if (imcValor >= 18.5 && imcValor < 25.0) {
            classificacao = "Peso normal";
            
        } else if (imcValor >= 25.0 && imcValor < 30.0) {
            classificacao = "Sobrepeso";
            
        } else if (imcValor >= 30.0 && imcValor < 35.0) {
            classificacao = "Obesidade Grau I";
            
        } else if (imcValor >= 35.0 && imcValor < 40.0) {
            classificacao = "Obesidade Grau II";
            
        } else {
            classificacao = "Obesidade Grau III (Mórbida)";
        }

        return new Imc(imcValor, classificacao);
    }
}