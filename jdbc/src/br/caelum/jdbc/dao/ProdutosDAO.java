package br.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.caelum.jdbc.modelo.Produto;

public class ProdutosDAO {
	
	private Connection con;
	
	public ProdutosDAO(Connection con){
		this.con = con;
	}
	
	public void salva(Produto prod) throws SQLException {
		
		String sql = "insert into PRODUTO (nome, descricao) values (?,?)";
		
		try(PreparedStatement ste = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				ste.setString(1, prod.getNome());
				ste.setString(2, prod.getDescricao());
				
				ste.execute();
			
			try(ResultSet rs = ste.getGeneratedKeys()){
					rs.next();
					
					prod.setId( rs.getInt("id"));
			}
		}
	}
	
	
	public ArrayList<Produto> getLista() throws SQLException {
			ArrayList<Produto> lista = new ArrayList<>();
			
			//Pegando um meio para executar script SQL
			try(PreparedStatement statement = con.prepareStatement("select * from Produto") ){;
			
				//Executando uma query e pegando o resultado
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				//listando os itens da query (Funciona que nem um Iterator)
				while(resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String descricao = resultSet.getString("descricao");
					
					lista.add( new Produto(nome, descricao, id) );
					
					System.out.println(id);
					System.out.println(nome);
					System.out.println(descricao);
				}
				
			}
			
			return lista;
	}
}
