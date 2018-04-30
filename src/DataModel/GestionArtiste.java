package DataModel;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import MainLoginTp2Chris.ConnectionMySQL;

public class GestionArtiste {

	private Connection connection = ConnectionMySQL.getLaConnection();

	private ArrayList<Artistes> lstArtists;
//	private ArrayList<Albums> lstAlbums;

	public GestionArtiste() {

		lstArtists = obtenirListArtistes();

	}

	public ArrayList<Artistes> obtenirListArtistes() {


		lstArtists = new ArrayList<Artistes>();

		String requete = "SELECT * FROM artiste ORDER BY nom";

		try(Statement statement = connection.createStatement();
				ResultSet paketResultat= statement.executeQuery(requete) ){

			while(paketResultat.next()) {
				int numero = paketResultat.getInt("idArtiste");
				String nom = paketResultat.getString("nom");
				boolean membre = paketResultat.getBoolean("membre");
				int photo = paketResultat.getInt("photo");
				
				lstArtists.add(new Artistes(numero,nom,membre,photo) );

			}

		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR : " 
					+ sqle.getMessage(),"Résultat" , JOptionPane.ERROR_MESSAGE);			
		}

		return lstArtists;
	}

	public 	boolean ajouterArist (Artistes artiste) {

		int intMembre =0;
		boolean boolAjout = false;
			
		if(artiste.getNumero() >0  && artiste.isMembre() ) {
			intMembre = 1;}
		else if (artiste.getNumero() >0  && !artiste.isMembre() ) {
			intMembre = 0;
			String requete = "INSERT INTO artiste(idArtiste, nom, membre,photo) VALUES (" 
					+ artiste.getNumero() +   ",'"
					+ artiste.getNom() +   "',"
					+ intMembre 
					+ artiste.getPhoto()+ ")";

			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(requete);
				boolAjout = true;
			} catch(SQLException sqle) {

				JOptionPane.showMessageDialog(null, "Erreur d'enregistrement\r\n" + 
						" de l'artiste: " + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

			}
		}
		
		
		return boolAjout;

	}


	public 	boolean supprimerArtist (Artistes artiste) {
		
		boolean boolDel = false;
			
		if(artiste.getNumero() > 0) {
	
		String requete = "DELETE from artiste where numero = " + artiste.getNumero() ;

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(requete);
			boolDel = true;

		} catch(SQLException sqle) {

			JOptionPane.showMessageDialog(null, "ERRORS: suppression "
					 + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

		}
		
		}
		
		return boolDel;

	}
		
	public 	boolean upDateArtist (Artistes artiste) {
		
		int intMembre =0;
		boolean boolUpDate = false;

		if(artiste.getNumero() >0  && artiste.isMembre() ) {
			intMembre = 1;}
		else if (artiste.getNumero() >0  && !artiste.isMembre() ) {
			intMembre = 0;
			
			String requete = "UPDATE artiste SET ("
					+ artiste.getNumero() +   ",'"
					+ artiste.getNom() +   "',"
					+ intMembre + ")";

			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(requete);
				boolUpDate = true;

			} catch(SQLException sqle) {

				JOptionPane.showMessageDialog(null, "Problme rencontr\u00E9 lors de la mise à jour \r\n" + 
						" de l'artiste: " + sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);

			}
		}
		return boolUpDate;

	}
	
	

	



}


