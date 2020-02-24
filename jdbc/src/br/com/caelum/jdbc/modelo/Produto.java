package br.com.caelum.jdbc.modelo;

public class Produto {
	
	private String nome;
	private String descricao;
	private Integer id;
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	public Produto(String nome2, String descricao2, int id2) {
		this.nome = nome2;
		this.descricao = descricao2;
		this.id = id2;
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public int getId() {
		return id;
	}
	
	
}	
