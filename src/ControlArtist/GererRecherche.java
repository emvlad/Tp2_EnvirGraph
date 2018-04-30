package ControlArtist;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataModel.Artistes;
import DataModel.GestionRecherche;
import ViewArtistes.FrmAffichArtisteBldr;


public class GererRecherche implements ActionListener{
	
	
	private FrmAffichArtisteBldr frmAffichSearch ;
	private JButton btnGo ;
	
	private JTextField txtNum;
	private JTextField txtNom;
	private JCheckBox membre;
	private JTextField photo;
	
	private JLabel lblPhotoArtiste;
	private JPanel panel;

	public GererRecherche() {
		super();
		
		btnGo = new JButton("Trouver");
		
	}

	int unused;
	

	private ArrayList<Artistes> lstTrouve;

	@Override
	public void actionPerformed(ActionEvent ar) {

		GestionRecherche f = new GestionRecherche();
		ResultSet paketResultat = null;
		
		lstTrouve = new ArrayList<Artistes>();
				
		if(txtNom !=null) {
			
			paketResultat =f.find(txtNom.getText());
			try{
				
				if(paketResultat.next()){
					int numero = paketResultat.getInt("idArtiste");
					String nom = paketResultat.getString("nom");
					boolean membre = paketResultat.getBoolean("membre");			
					int photo = paketResultat.getInt("photo");
					
					lstTrouve.add(new Artistes (numero,nom,membre,photo));
			
					this.txtNum.setText(String.valueOf(numero));
					this.txtNom.setText(nom);
					this.membre.setSelected(membre);
					this.photo.setText(String.valueOf(photo));
					
					this.panel.add(btnGo);
					this.frmAffichSearch.add(panel);			
					
								
				try {
					this.lblPhotoArtiste.setIcon(new ImageIcon(FrmAffichArtisteBldr.class.getResource("/icons/artistPicts/photo.jpg")));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Photo recherchée introuvable");
				}			
									
					
				} else{
						JOptionPane.showMessageDialog(null,"Infos non trouvé");
				}
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		
	
		

		
	}


}
