package ViewArtistes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ControlArtist.GererFrmAffichArtiste;



import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.ArrayList;

public class FrmAffichArtisteBldr extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textNom;
	private JTable table;
	JPanel panelBtnGestion;

	//self-parent
	FrmAffichArtisteBldr parent = this;
	


	//model
	private ModelArtiste modelArtist = new ModelArtiste(premierArtiste());
	public JTable tabjArtistes = new JTable(modelArtist);



	String [] nomBtnGestion = new String [] {"Ajouter","Modifier",
			"Suprimer","Rechercher","Quitter" };

	private JButton[] btnGestion = new JButton[nomBtnGestion.length];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAffichArtisteBldr frame = new FrmAffichArtisteBldr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAffichArtisteBldr() {
		setSize(850,500);
		setResizable(false);
		setTitle("Gestion des artistes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAffichArtisteBldr.class.getResource("/icons/dvd.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo (null);


		GererFrmAffichArtiste gereArtist= new GererFrmAffichArtiste(tabjArtistes, modelArtist,
				parent, nomBtnGestion);

		panelBtnGestion = new JPanel();

		for(int i=0; i<nomBtnGestion.length;i++) {


			btnGestion[i] = new JButton(nomBtnGestion[i]);

			btnGestion[i].setActionCommand(nomBtnGestion[i]);

			btnGestion[i].addActionListener(gereArtist);

			panelBtnGestion.add(btnGestion[i]);


		}


		contentPane.add(panelBtnGestion, BorderLayout.WEST);
		panelBtnGestion.setLayout(new GridLayout(5, 1, 5, 50));


		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_FormHaut = new JPanel();
		panel.add(panel_FormHaut, BorderLayout.NORTH);
		GridBagLayout gbl_panel_FormHaut = new GridBagLayout();
		gbl_panel_FormHaut.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_FormHaut.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_FormHaut.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_FormHaut.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_FormHaut.setLayout(gbl_panel_FormHaut);

		JLabel lblNumero = new JLabel("Num\u00E9ro");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.fill = GridBagConstraints.BOTH;
		gbc_lblNumero.anchor = GridBagConstraints.WEST;
		gbc_lblNumero.insets = new Insets(10, 30, 5, 5);
		gbc_lblNumero.gridx = 3;
		gbc_lblNumero.gridy = 1;
		panel_FormHaut.add(lblNumero, gbc_lblNumero);

		textNumero = new JTextField();
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.anchor = GridBagConstraints.WEST;
		gbc_textNumero.gridwidth = 5;
		gbc_textNumero.insets = new Insets(10, 0, 5, 5);
		gbc_textNumero.gridx = 6;
		gbc_textNumero.gridy = 1;
		panel_FormHaut.add(textNumero, gbc_textNumero);
		textNumero.setColumns(10);
		textNumero.setEditable(false);

		JLabel lblPhotoArtiste = new JLabel("");
		lblPhotoArtiste.setIcon(new ImageIcon(FrmAffichArtisteBldr.class.getResource("/icons/artistPicts/1.jpg")));
		lblPhotoArtiste.setToolTipText("Photo Artiste");
		GridBagConstraints gbc_lblPhotoArtiste = new GridBagConstraints();
		gbc_lblPhotoArtiste.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhotoArtiste.gridwidth = 3;
		gbc_lblPhotoArtiste.gridheight = 3;
		gbc_lblPhotoArtiste.insets = new Insets(10, 0, 5, 5);
		gbc_lblPhotoArtiste.gridx = 11;
		gbc_lblPhotoArtiste.gridy = 1;
		panel_FormHaut.add(lblPhotoArtiste, gbc_lblPhotoArtiste);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.fill = GridBagConstraints.BOTH;
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 30, 5, 5);
		gbc_lblNom.gridx = 3;
		gbc_lblNom.gridy = 2;
		panel_FormHaut.add(lblNom, gbc_lblNom);

		textNom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridwidth = 6;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 2;
		panel_FormHaut.add(textNom, gbc_textField);
		textNom.setColumns(10);
		textNom.setEditable(false);


		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMembre = new GridBagConstraints();
		gbc_lblMembre.fill = GridBagConstraints.BOTH;
		gbc_lblMembre.insets = new Insets(0, 30, 5, 5);
		gbc_lblMembre.gridx = 3;
		gbc_lblMembre.gridy = 3;
		panel_FormHaut.add(lblMembre, gbc_lblMembre);

		JCheckBox chckbxMembre = new JCheckBox("");
		chckbxMembre.setEnabled(false);
		
		GridBagConstraints gbc_chckbxMembre = new GridBagConstraints();
		gbc_chckbxMembre.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMembre.anchor = GridBagConstraints.WEST;
		gbc_chckbxMembre.gridx = 6;
		gbc_chckbxMembre.gridy = 3;
		panel_FormHaut.add(chckbxMembre, gbc_chckbxMembre);

		JLabel lblphotoAlbum = new JLabel("");
		lblphotoAlbum.setIcon(new ImageIcon(FrmAffichArtisteBldr.class.getResource("/icons/artistPicts/2.jpg")));
		lblphotoAlbum.setToolTipText("Photo Album");
		GridBagConstraints gbc_lblphotoAlbum = new GridBagConstraints();
		gbc_lblphotoAlbum.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblphotoAlbum.gridheight = 4;
		gbc_lblphotoAlbum.gridwidth = 3;
		gbc_lblphotoAlbum.insets = new Insets(0, 0, 0, 5);
		gbc_lblphotoAlbum.gridx = 11;
		gbc_lblphotoAlbum.gridy = 4;
		panel_FormHaut.add(lblphotoAlbum, gbc_lblphotoAlbum);


		tabjArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabjArtistes.getColumnModel().getColumn(2).setCellRenderer(new IconMembActif());
		tabjArtistes.getColumnModel().getColumn(1).setCellRenderer(new NumGras());

		JScrollPane scrollPane = new JScrollPane(tabjArtistes);

		panel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setColumnHeaderView(table);
		
		
		
		tabjArtistes.getSelectionModel().addListSelectionListener(new
				ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					
					if(tabjArtistes.getSelectedRow()>= 0) {
						
						int numLigne;
						numLigne = tabjArtistes.getSelectedRow();

						Artistes artiste= modelArtist.getElement(numLigne);
						
						//méthode ajoutée dans le modèle de table

						textNumero.setText(Integer.toString(artiste.getNumero()));
						textNom.setText(artiste.getNom());
						chckbxMembre.isSelected();
						
						
						if(artiste.isMembre()) {
							chckbxMembre.setSelected(true);
						} else {
							chckbxMembre.setSelected(false);
						}
						
						
						
					}

				}
			};

		});
		
				
		
	}

	public ModelArtiste getModelArtiste () {
		return modelArtist;

	}

	/**
	 * méthode pour ajouter un nouveau artiste 
	 * suivant le constructeur complet de la classe artistes
	 * 
	 * @return le package de la liste des artistes
	 */
	private ArrayList<Artistes> premierArtiste(){

		ArrayList<Artistes> listArtistes= new ArrayList<Artistes>();

		listArtistes.add(new  Artistes(1, "Jennifer Lopez", true));
		listArtistes.add(new  Artistes(2, "Michael Jackson", false));
		listArtistes.add(new  Artistes(4, "Selena Gomez",  true ));

		//package liste musiciens
		return listArtistes;

	}
	

	
	

}



