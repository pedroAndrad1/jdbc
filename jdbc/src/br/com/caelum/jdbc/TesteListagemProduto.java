package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.caelum.jdbc.dao.ProdutosDAO;
import br.com.caelum.jdbc.modelo.Produto;

public class TesteListagemProduto {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Pegando uma conexao com o banco
		Connection connection = new Database().getConnection();
		
		//Criando o DAO
		ProdutosDAO dao = new ProdutosDAO(connection);
		
		ArrayList<Produto> lista = dao.getLista();
		
		for (Produto produto : lista) {
			
			int id = produto.getId();
			String nome = produto.getNome();
			String descricao = produto.getDescricao();
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
	}

}
