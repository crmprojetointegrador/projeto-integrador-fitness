package com.generation.fitness.service;


public class Imc {
    private Double imc;
    private String classificacao;

    public Imc(Double imc, String classificacao) {
        this.imc = imc;
        this.classificacao = classificacao;
    }

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
}


