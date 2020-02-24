package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Pegando uma conexao com o banco
		Connection connection = new Database().getConnection();
		
		//Pegando um meio para executar script SQL
		Statement statement = connection.createStatement();
		
		//Executando uma query e pegando o resultado
		boolean resultado = statement.execute("select * from Produto");
		ResultSet resultSet = statement.getResultSet();
		
		//listando os itens da query (Funciona que nem um Iterator)
		while(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
			
		}
		
		//Fechando as conexoes
		
		resultSet.close();
		statement.close();

		connection.close();
		
	}



}
