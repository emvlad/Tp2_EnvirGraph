package DataModel;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import MainLoginTp2Chris.ConnectionMySQL;


public class GestionRecherche {
		
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

	}


