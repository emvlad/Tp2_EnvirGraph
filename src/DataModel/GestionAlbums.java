package DataModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MainLoginTp2Chris.ConnectionMySQL;

public class GestionAlbums {

	Connection con = null;//demande connection

	ResultSet rsList = null; // instance du resultat de la requête (list)
	PreparedStatement prepS = null;//instance du statement préparé (select *)

	public ResultSet find(String s){
		try{
			con = ConnectionMySQL.getLaConnection();
			String txtNom = null;
			prepS = con.prepareStatement("SELECT * FROM artiste WHERE nom like" + txtNom + '%'  );
			prepS.setString(1,s);
			rsList = prepS.executeQuery();

		}catch(Exception e){

			JOptionPane.showMessageDialog(null,e.getMessage());

		}
		return rsList;
	}

	public ArrayList<Albums> obtenirListAlbums() {

		ArrayList<Albums> lstAlbums = new ArrayList <Albums>();
		String requete = "SELECT * FROM album ORDER BY titre";

		try(Statement statement = con.createStatement();
				ResultSet paketResultat= statement.executeQuery(requete) ){

			while(paketResultat.next()) {
				int id = paketResultat.getInt("id");
				int anneeSortie = paketResultat.getInt("anneSortie");
				String titre = paketResultat.getString("titre");
				String genre = paketResultat.getString("genre");
				String distribut = paketResultat.getString("distributeur");


				double prix = paketResultat.getDouble("prix");
				String imgCover = paketResultat.getString("imgCover");
				int numArtiste = paketResultat.getInt("numArtist");

				lstAlbums.add(new Albums(id, anneeSortie, titre, genre, distribut, prix, imgCover, numArtiste));

			}

		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error Connection : " 
					+ sqle.getMessage(),"Résultat" , JOptionPane.ERROR_MESSAGE);			
		}

		return lstAlbums;
	}

}


