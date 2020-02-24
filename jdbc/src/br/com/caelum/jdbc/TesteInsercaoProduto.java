package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.caelum.jdbc.dao.ProdutosDAO;
import br.com.caelum.jdbc.Database;
import br.com.caelum.jdbc.modelo.Produto;

public class TesteInsercaoProduto {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try(Connection con = new Database().getConnection()){
			
			PreparedStatement ste = con.prepareStatement
					("insert into PRODUTO(nome,descricao) values (?,?)");
			
			Produto produto = new Produto("Mesa Azul", "Mesa com 4 pés");
		
			ProdutosDAO dao = new ProdutosDAO(con);
			
			dao.salva(produto);
			
		}
		
		
	}
	

}
