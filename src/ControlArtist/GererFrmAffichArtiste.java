package ControlArtist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;

import DataModel.GestionRecherche;
import DataModel.ModelArtiste;
import DataModel.Artistes;
import DataModel.GestionArtiste;
import ViewArtistes.FrmAddArtist;
import ViewArtistes.FrmAffichArtisteBldr;

public class GererFrmAffichArtiste implements ActionListener {

	private JTable tabjArtists;
	private ModelArtiste modelArtist;
	
	private String [] nomBtnGestion;
	
	private FrmAffichArtisteBldr parent;
	
	JLabel [] lblphotoArtist;
	
	JLabel [] lblphotoAlbums;

	
	GestionRecherche findArtist = new GestionRecherche();

	GestionArtiste gererArtiste = new GestionArtiste ();
	Artistes artiste;
	

	public GererFrmAffichArtiste(JTable tabjArtists, ModelArtiste modelArtist, FrmAffichArtisteBldr parent,
			String[] nomBtnGestion,JTextField txtNom) {
		super();
		this.tabjArtists = tabjArtists;
		this.modelArtist = modelArtist;
		this.parent = parent;
		this.nomBtnGestion = nomBtnGestion;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//1- Ajouter
		for (int i = 0; i < nomBtnGestion.length; i++) {

			if (e.getActionCommand().equalsIgnoreCase("Ajouter") && i==0) {

				FrmAddArtist openModalFrmAdd = new FrmAddArtist(parent);
				openModalFrmAdd.setVisible(true);

			}
			//2- Update (Mis à jour)
			else if (e.getActionCommand().equalsIgnoreCase("Modifier") && i==1) {

				JOptionPane.showMessageDialog(null, "TestVoulez vous MODIFIER");


				if(modelArtist.getRowCount() > 1) {					

					int indicDel = tabjArtists.getSelectedRow();

					if(indicDel >= 0 ) {
						gererArtiste.upDateArtist(artiste);

						if(gererArtiste.upDateArtist(artiste))

							modelArtist.upDateArtist(indicDel, artiste);

						JOptionPane.showMessageDialog(null, "Modification réussie");
					}			
				}


			}
			//3- Suppression
			else if (e.getActionCommand().equalsIgnoreCase("Supprimer") && i==2) {

				JOptionPane.showMessageDialog(null, "TestVoulez vous AFFACER");

				int confirmation = JOptionPane.showConfirmDialog(null, 
						"Voulez-vous supprimer?","Confirmez",JOptionPane.YES_NO_OPTION); 

				if (confirmation == JOptionPane.YES_OPTION) {	

					if(modelArtist.getRowCount() > 1 && gererArtiste.supprimerArtist(artiste)) {					

						int indicDel = tabjArtists.getSelectedRow();
						if(indicDel >= 0 ) {
							
							modelArtist.effaceArtist(indicDel);


						}
					}



				}


			}
			
			
			//3- Rechercher
			else if (e.getActionCommand().equalsIgnoreCase("Rechercher") && i==3) {

			
			GererRecherche search = new GererRecherche(); 
			
			search.actionPerformed(e);


			}
			else if (e.getActionCommand().equalsIgnoreCase("Quitter") && i==4) {

				parent.dispose();

			}//4-

		}
	}

}