package br.com.caelum.jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection connection = new Database().getConnection();
		connection.setAutoCommit(false);
		try{
			String sql = "insert into produto (nome, descricao) values ( ? , ?)";
				
			try (PreparedStatement ste = connection.prepareStatement
							(sql, Statement.RETURN_GENERATED_KEYS);) {
				
				adiciona("Notebook' i5", "Notebook i5", connection, ste);
				adiciona("TV LCD", "32 polegadas", connection, ste);
				adiciona("Blueray", "Full HDMI", connection, ste);
				
				connection.commit();
			} 
			
		} catch (Exception e) {
			
			System.out.println("Fazendo o rollback");
			connection.rollback();
			System.out.println("Fiz o rollback");
			connection.close();
			
			e.printStackTrace();
			
		}
	}

	private static void adiciona(String nome, String descricao, Connection connection, PreparedStatement ste)
			throws SQLException {
		
		if(nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}
		
		ste.setString(1, nome);
		ste.setString(2, descricao);
		
		boolean exe = ste.execute();
		
		System.out.println(exe + " | LINHAS ALTERADAS: " + ste.getUpdateCount());
		
		ResultSet rs = ste.getGeneratedKeys();
		
		
		//LISTA DE RESULTADOS COMEÇA COM O ITERADOR APONTANDO PARA ANTES DO PRIMEIRO ITEM
		rs.next();
		
		
		System.out.println("Novo id " + rs.getInt("id") );
		
		
		
	}

}
