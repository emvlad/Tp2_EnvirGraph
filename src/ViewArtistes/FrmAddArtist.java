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
	private JLabel lblNumero, lblNom,lblPhoto,lblMembre;

	private JTextField txtNumero,txtNom,txtPhoto;
	private JCheckBox checkBoxMembre;
	private JButton btnAnnuler, btnConfirmer,btnAddPhoto;
	
	private JTextField txtPathPhoto = new JTextField(15);

	//instance pour la classe modale (declare self-parent)
	private FrmAffichArtisteBldr frmAffichArtistParent;
	
	//////////////////////////////////////////

	//constructeur de la fenêtre reçoit l'instance pour la classe modale
	public FrmAddArtist (FrmAffichArtisteBldr frmEnfantParent){

		//adapt self-parent pour la forme modale
		super(frmEnfantParent,true);
		this.frmAffichArtistParent=frmEnfantParent;

		//titre et size
		setTitle("Ajout d'un nouvel artiste"); 
		setSize(400,300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLocationRelativeTo(frmEnfantParent);


		//tag tous les composants
		lblNumero=new JLabel("Num\u00E9ro");
		lblNom=new JLabel("Nom");
		lblPhoto=new JLabel("Photo No.");
		lblMembre = new JLabel("Membre");

		//text fields
		txtNumero= new JTextField(15);
		txtNom= new JTextField(20);
		txtPhoto= new JTextField(11);
		//checkbox
		checkBoxMembre = new JCheckBox();

		//boutons gestion2
		btnAnnuler= new JButton("Annuler");		
		btnConfirmer= new JButton("Confirmer");
		btnAddPhoto = new JButton("Ajouter Photo");

				
		GererFrmAddArtiste gererComposants = new GererFrmAddArtiste(txtNumero, txtNom,
				checkBoxMembre, txtPhoto, btnAnnuler,btnConfirmer, btnAddPhoto, frmAffichArtistParent, FrmAddArtist.this);
		
		btnAnnuler.addActionListener(gererComposants);
		btnConfirmer.addActionListener(gererComposants);
		btnAddPhoto.addActionListener(gererComposants);

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
		panneau3.add(lblMembre);
		panneau3.add(checkBoxMembre);
		
		
		JPanel panneau4= new JPanel();
		panneau4.add(btnAnnuler);
		panneau4.add(btnConfirmer);
		
		
		JPanel panneau5= new JPanel();
		
		
		JLabel lblPath_pict = new JLabel();
		txtPathPhoto.setToolTipText("Chemin pour accéder au dossier photoID_existante");
		panneau5.add(lblPhoto);
		panneau5.add(txtPathPhoto);
		
		panneau5.add(lblPath_pict);				
		panneau5.add(btnAddPhoto);

		add(panneau1);
		add(panneau2);
		add(panneau3);	
		
		add(panneau5);
		add(panneau4);

	}



}
