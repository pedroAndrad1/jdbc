package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = new Database().getConnection();
		Statement ste = connection.createStatement();
		
		boolean exe = ste.execute
				("delete from PRODUTO where id > 3");
		
		System.out.println(exe + " |Linhas alteradas " + ste.getUpdateCount());
		
		ste.close();
		connection.close();
		
			
	}

}
