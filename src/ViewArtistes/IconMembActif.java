package ViewArtistes;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class IconMembActif extends DefaultTableCellRenderer{

	private static final long serialVersionUID = 1L;
	private ImageIcon iconMemb, iconAutre;
	public IconMembActif() {
		super();

		//icon Membres
		iconMemb = new ImageIcon(IconMembActif.class.getResource("../icons/check.png"));
		iconAutre =new ImageIcon(IconMembActif.class.getResource("../icons/annuler.png"));

	}

	@Override
	public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean hasFocus, 
			int row, int column) {

		super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row,
				column);
		//récupérer la valeur de la cellule en boolean
		Boolean membre = (Boolean)value;

		//1- si la profession est directeur applique l'image 
		if(membre) {
			setIcon(iconMemb);			
			
		}
		else {

			setIcon(iconAutre);
			
		}


		//2- centrez la cellule 		
		setHorizontalAlignment(CENTER);

		return this;
	}

}
