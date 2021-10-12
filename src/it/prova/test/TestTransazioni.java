package it.prova.test;

import java.sql.Connection;
import java.sql.Statement;

import it.prova.connection.MyConnection;

public class TestTransazioni {

	public static void main(String[]args) {
		
		Connection c= MyConnection.getConnection();
		
		try {
			
			c.setAutoCommit(false);
			Statement s=c.createStatement();
			s.executeUpdate("INSERT INTO autore(nome, cognome) VALUES('Mario', 'Rossi')");
			s.executeUpdate("INSERT INTO autore(nome, cognome) VALUES('Giuseppe', 'Verdi')");
			c.commit();
			s.close();
			System.out.println("Successo");
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			System.out.println("Fallimento");
			c.rollback();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
