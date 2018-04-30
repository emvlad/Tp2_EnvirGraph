package ControlArtist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataModel.Artistes;
import DataModel.GestionArtiste;
import ViewArtistes.FrmAddArtist;
import ViewArtistes.FrmAffichArtisteBldr;


public class GererFrmAddArtiste implements ActionListener{

	//attributs ou composants
	private JTextField txtNumero,txtNom,txtPhoto;
	private JCheckBox checkBoxMembre;
	private JButton btnAnnuler, btnConfirmer, btnAddPhoto;
	private JTextField txtPathPhoto = new JTextField();

	boolean membre;

	private FrmAffichArtisteBldr frmAffichArtistParent;
	private FrmAddArtist frmEnfantParent;
	private Artistes artiste;
	private GestionArtiste gererArtiste = new GestionArtiste();

	//constructeur des composants
	public GererFrmAddArtiste(JTextField txtNumero, JTextField txtNom, 
			JCheckBox checkBoxMembre, JTextField txtPhoto,JButton btnAnnuler,
			JButton btnConfirmer,JButton btnAddPhoto, FrmAffichArtisteBldr frmAffichArtistParent, FrmAddArtist frmEnfantParent) {
		super();
		this.txtNumero = txtNumero;
		this.txtNom = txtNom;
		this.txtPhoto =txtPhoto;
		this.checkBoxMembre = checkBoxMembre;
		this.btnAnnuler = btnAnnuler;
		this.btnConfirmer = btnConfirmer;
		this.btnAddPhoto = btnAddPhoto;	
		
		this.frmAffichArtistParent = frmAffichArtistParent;
		this.frmEnfantParent = frmEnfantParent;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnConfirmer ){
			try{
							
				//récupérer les champs dans des variables (numero, nom,...)
				int numero = Integer.parseInt(txtNumero.getText());
				String nom = txtNom.getText();
			int photo =  Integer.parseInt(txtPhoto.getText()) ;
				membre =checkBoxMembre.isSelected();
				

				//Créer une variable artiste
				artiste = new Artistes(numero,nom,membre,photo);
				
				if(gererArtiste.ajouterArist(artiste)) {
					//Ajouter la variable artist au modèle de table
					frmAffichArtistParent.getModelArtiste().addArtist(artiste);
	
					//Appeler la méthode pour vider les champs 
					//du formulaire de saisie d'ajout des artistes
					emptyFields();
				}
					
			}
			catch (NumberFormatException  nfe){
				JOptionPane.showMessageDialog(null, "Le numero n'est pas un nombre");
			}		

		}else if(e.getSource()==btnAnnuler) {
			this.frmEnfantParent.dispose();
			
		}else if(e.getSource()==btnAddPhoto) {
			
			JFileChooser choixDir = new JFileChooser();
			choixDir.showOpenDialog(null);
			File f = choixDir.getSelectedFile();
			String fileName = f.getAbsolutePath();
			txtPathPhoto.setText(fileName);
		}
		
		

	}

	//methode pour vider les champs
	private void emptyFields(){
		txtNumero.setText("");
		txtNom.setText("");
		checkBoxMembre.setSelected(false);

		//pour avoir le focus
		txtNumero.requestFocus();
	}

}
