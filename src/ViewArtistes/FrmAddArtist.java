package ViewArtistes;

import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ControlArtist.GererFrmAddArtiste;


public class FrmAddArtist extends JDialog {
	private static final long serialVersionUID = 1L;	

	//attributs ou composants
	private JLabel lblNumero, lblNom;
	
	private JTextField txtNumero,txtNom;
	private JCheckBox checkBoxMembre;
	private JButton btnAnnuler, btnConfirmer;

	//instance pour la classe modale (declare self-parent)
	private FrmAffichArtisteBldr frmAffichArtistParent;
	
	//////////////////////////////////////////

	//constructeur de la fenêtre reçoit l'instance pour la classe modale
	public FrmAddArtist (FrmAffichArtisteBldr frmEnfantParent){

		//adapt self-parent pour la forme modale
		super(frmEnfantParent,true);
		this.frmAffichArtistParent=frmEnfantParent;

		//titre et size
		setTitle("Ajout d'un nouvel Employ\u00E9"); 
		setSize(300,300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLocationRelativeTo(frmEnfantParent);


		//tag tous les composants
		lblNumero=new JLabel("Num\u00E9ro");
		lblNom=new JLabel("Nom");

		//text fields
		txtNumero= new JTextField(15);
		txtNom= new JTextField(20);
		//checkbox
		checkBoxMembre = new JCheckBox();

		//boutons gestion2
		btnAnnuler= new JButton("Annuler");		
		btnConfirmer= new JButton("Confirmer");

		//Ajouter listener aux boutons
		//		btnAnnuler.addActionListener(this);
		//		btnConfirmer.addActionListener(this);
		
		GererFrmAddArtiste gererComposants = new GererFrmAddArtiste(txtNumero, txtNom,
				checkBoxMembre, btnAnnuler,btnConfirmer,  frmAffichArtistParent, FrmAddArtist.this);
		
		btnAnnuler.addActionListener(gererComposants);
		btnConfirmer.addActionListener(gererComposants);

		//fields
		composantAjout();	

		//fermeture de la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	//fields method
	private void composantAjout() {
		JPanel panneau1= new JPanel();
		panneau1.add(lblNumero);
		panneau1.add(txtNumero);

		JPanel panneau2= new JPanel();
		panneau2.add(lblNom);
		panneau2.add(txtNom);

		JPanel panneau3= new JPanel();

		panneau3.add(checkBoxMembre);

		JPanel panneau4= new JPanel();
		panneau4.add(btnAnnuler);
		panneau4.add(btnConfirmer);

		add(panneau1);
		add(panneau2);
		add(panneau3);		
		add(panneau4);

	}



}
