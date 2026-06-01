package com.generation.fitness.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório!")
    @Size(min = 2, max = 100, message = "O nome do produto deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "O preço é obrigatório!")
    @PositiveOrZero(message = "O preço deve ser igual ou maior que zero!")
    private Double preco;

    @NotNull(message = "A quantidade de calorias é obrigatória!")
    @PositiveOrZero(message = "As calorias não podem ser negativas!")
    private Integer calorias; 

    @NotBlank(message = "A marca é obrigatória!")
    private String marca;

    @NotNull(message = "O produto deve estar associado a uma categoria!")
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    

}
