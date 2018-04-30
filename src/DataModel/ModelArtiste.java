package DataModel;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModelArtiste  extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	//attributs
	private ArrayList<Artistes> lesDonnees;

	private final String[] lesTitres = {"Numéro", "Nom", "Membre"};

	//constructor
	public ModelArtiste(ArrayList<Artistes> lesDonnees) {
			this.lesDonnees = lesDonnees;
	}


	@Override
	public int getColumnCount() {

		return lesTitres.length;
	}

	@Override
	public int getRowCount() {

		return lesDonnees.size();
	}

	@Override
	public Object getValueAt(int ligndex, int coldex) {

		switch(coldex){
		case 0:
			return lesDonnees.get(ligndex).getNumero();

		case 1:
			return lesDonnees.get(ligndex).getNom();

		case 2:
			return lesDonnees.get(ligndex).isMembre();

		

		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {

		return lesTitres[columnIndex];		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return Double.class;
		case 3: return String.class;
		case 4: return Boolean.class;
		default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
		}
	} 
	
	public Artistes getElement(int row){
		return lesDonnees.get(row);
	}
	
	
	public void addArtist(Artistes artist) {
		lesDonnees.add(artist);
		fireTableRowsInserted(lesDonnees.size() -1, lesDonnees.size() -1);
		
		//notifie qu’une insertion en fin de liste a eu lieu.
		String notifie="Une insertion en fin de liste a eu lieu"; 
     	JOptionPane.showMessageDialog(null, notifie, "Insertion", JOptionPane.WARNING_MESSAGE);
		
	}
	public void effaceArtist(int rowIndex) {
		lesDonnees.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
		
		//notifie qu’une suppression a eu lieu de la ligne rowIndex à la ligne rowIndex.
		String notifie="Une suppression a eu lieu de la ligne " + rowIndex + " à la ligne " + rowIndex; 
		JOptionPane.showMessageDialog(null, notifie, "Suppression", JOptionPane.WARNING_MESSAGE);
	
	}
	public void upDateArtist(int firstRow, Artistes artist) {
		lesDonnees.set(firstRow, artist);
		fireTableRowsUpdated(firstRow, firstRow);
	}
	public void setDonnees(ArrayList<Artistes> nouvellesDonnees){
		lesDonnees = nouvellesDonnees;
		fireTableDataChanged();
		
		//notifie que le modèle de table a changé
		String notifie="La liste de la table modèle a changé " ; 
		JOptionPane.showMessageDialog(null, notifie, "Modification", JOptionPane.WARNING_MESSAGE);
		
		
	}

}
