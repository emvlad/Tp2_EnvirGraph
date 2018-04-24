package DataModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import LonginTp2Chris.ConnectionMySQL;
import ViewArtistes.Artistes;

public class GestionArtiste {

	private Connection connection = ConnectionMySQL.getLaConnection();

	private ArrayList<Artistes> lstArtists;

	public GestionArtiste() {

		lstArtists = obtenirListArtistes();

	}

	private ArrayList<Artistes> obtenirListArtistes() {


		lstArtists = new ArrayList<Artistes>();

		String requete = "SELECT * FROM artiste ORDER BY nom";

		try(Statement statement = connection.createStatement();
				ResultSet paketResultat= statement.executeQuery(requete) ){

			while(paketResultat.next()) {
				int numero = paketResultat.getInt("numero");
				String nom = paketResultat.getString("nom");
				boolean membre = paketResultat.getBoolean("membre");
		
				lstArtists.add(new Artistes(numero,nom,membre) );

			}

		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E8 : " 
					+ sqle.getMessage(),"Résultat" , JOptionPane.ERROR_MESSAGE);			
		}

		return lstArtists;
	}



	public 	boolean ajouterArist (Artistes artiste) {

		int intMembre =0;
		boolean boolAjout =false;
		
		
		if(artiste.isMembre()) {
			intMembre = 1;

			String requete = "INSERT INTO artiste(numero, nom, membre) VALUES ('" 
					+ artiste.getNumero() +   "','"
					+ artiste.getNom() +   "','"
					+ intMembre +   "' " + ")";

			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(requete);

			} catch(SQLException sqle) {

				JOptionPane.showMessageDialog(null, "Probl\\u00E8me rencontr\\u00E9 lors de l'enregistrement\r\n" + 
						" de l'artiste: " + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

			}
		}
		return boolAjout;

	}


	public 	boolean supprimerArist (Artistes artiste) {
		
		boolean boolDel = false;
			
		if(artiste.getNumero() >0) {
	
		String requete = "DELETE from artiste where numero = " + artiste.getNumero() ;

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(requete);

		} catch(SQLException sqle) {

			JOptionPane.showMessageDialog(null, "Probl\\u00E8me rencontr\\u00E9 lors de la suppression "
					+ " de l'artiste: " + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

		}
		
		}
		
		return boolDel;

	}
		
	public 	boolean upDateArtist (Artistes artiste) {
		
		int intMembre =0;
		boolean boolUpDate = false;

		if(artiste.isMembre()) {
			intMembre = 1;

			String requete = "UPDATE artiste SET ('" 
					+ artiste.getNumero() +   "','"
					+ artiste.getNom() +   "','"
					+ intMembre +   "' " + ")";

			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(requete);

			} catch(SQLException sqle) {

				JOptionPane.showMessageDialog(null, "Probl\\u00E8me rencontr\\u00E9 lors de la mise à jour \r\n" + 
						" de l'artiste: " + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

			}
		}
		return boolUpDate;

	}

}


