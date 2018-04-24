package ControlArtist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import ViewArtistes.FrmAddArtist;
import ViewArtistes.FrmAffichArtisteBldr;
import ViewArtistes.ModelArtiste;

//chris
public class GererFrmAffichArtiste implements ActionListener {

	private JTable tabjArtists;
	private ModelArtiste modelArtist;
	private FrmAffichArtisteBldr parent;
	private String [] nomBtnGestion;

	JLabel [] lblphotoArtists;
	JLabel [] lblphotoAlbums;


	boolean gestionArtiste;
	

	public GererFrmAffichArtiste(JTable tabjArtists, ModelArtiste modelArtist, FrmAffichArtisteBldr parent,
			String[] nomBtnGestion) {
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

				JOptionPane.showMessageDialog(null, "Voulez vous ajouter");
				FrmAddArtist openModalFrmAdd = new FrmAddArtist(parent);
				openModalFrmAdd.setVisible(true);

			}
			//2- Update (Mis à jour)
			else if (e.getActionCommand().equalsIgnoreCase("Modifier")&& i==1) {
				JOptionPane.showMessageDialog(null, "Voulez vous Modifier");
			
						
					
				}
				//3- Suppression
				else if (e.getActionCommand().equalsIgnoreCase("Suprimer")&& i==3) {

					JOptionPane.showMessageDialog(null, "Voulez vous supprimer");
										
					if(modelArtist.getRowCount() > 1) {
						int indicDel = tabjArtists.getSelectedRow();
						
						if(indicDel >= 0) {

							
							modelArtist.effaceArtist(indicDel);
							


						}

					}

				}

				//3- Rechercher
				else if (e.getActionCommand().equalsIgnoreCase("Rechercher") && i==4) {


					JOptionPane.showMessageDialog(null, "Voulez vous Rechercher");

				}
				else if (e.getActionCommand().equalsIgnoreCase("Quitter")) {

					parent.dispose();

				}


			}


		}



	}