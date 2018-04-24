package ControlArtist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ViewArtistes.Artistes;
import ViewArtistes.FrmAddArtist;
import ViewArtistes.FrmAffichArtisteBldr;


public class GererFrmAddArtiste implements ActionListener{

	//attributs ou composants
	private JTextField txtNumero,txtNom;
	private JCheckBox checkBoxMembre;
	private JButton btnAnnuler, btnConfirmer;

	boolean membre;

	private FrmAffichArtisteBldr frmAffichArtistParent;
	private FrmAddArtist frmEnfantParent;

	//constructeur des composants
	public GererFrmAddArtiste(JTextField txtNumero, JTextField txtNom, 
			JCheckBox checkBoxMembre, JButton btnAnnuler,
			JButton btnConfirmer, FrmAffichArtisteBldr frmAffichArtistParent, FrmAddArtist frmEnfantParent) {
		super();
		this.txtNumero = txtNumero;
		this.txtNom = txtNom;
		this.checkBoxMembre = checkBoxMembre;
		this.btnAnnuler = btnAnnuler;
		this.btnConfirmer = btnConfirmer;
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

				membre =checkBoxMembre.isSelected();

				//Créer une variable musicien
				Artistes artist = new Artistes(numero, nom, membre);

				//Ajouter la variable artist au modèle de table
				frmAffichArtistParent.getModelArtiste().addArtist(artist);

				//Appeler la méthode pour vider les champs 
				//du formulaire de saisie d'ajout des artistes
				emptyFields();
			}
			catch (NumberFormatException  nfe){
				JOptionPane.showMessageDialog(null, "Le numero n'est pas un nombre");
			}		

		}else if(e.getSource()==btnAnnuler) {
			this.frmEnfantParent.dispose();
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
