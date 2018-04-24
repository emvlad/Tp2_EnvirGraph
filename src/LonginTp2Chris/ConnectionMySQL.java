package LonginTp2Chris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;




public class ConnectionMySQL {

	private static  Connection circuit;
	private static String urlSQL = "jdbc:mysql://localhost/gestionalbumzks";    
	private static String piloteName = "com.mysql.jdbc.Driver";   
	private static String user = "root";   
	private static String password = "vlad2312";

	public static void Connecter() {

		try {

			if(circuit ==null || circuit.isClosed()) {

				//3-charger le pilote
				Class.forName(piloteName);


				//4- charger le diver pour se connecter � la base de donn�es du dossier local
				circuit = DriverManager.getConnection(urlSQL,user,password);
				JOptionPane.showMessageDialog(null," Connect\u00E9 � la BD.","ALERTE", 
						JOptionPane.INFORMATION_MESSAGE);	
			}

		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null," ERREUR: V�rifier l'installation du pilote");

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null," ERREUR: V�rifier l'existence de la base de donn\u00E9es ");		

		}
	

	}
	
	public static void fermerSession() {
		
		try {
			
			if(circuit !=null || !circuit.isClosed()) {
				circuit.close();
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERREUR: La fermeture de la connection a �chou�e");
		}
		
	}
	
	
	public static Connection getLaConnection() {
		
		return circuit;
		
		
	}

}


