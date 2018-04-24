package ViewArtistes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;



public class MenuGestionArtistes extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu lejMenu,  Aide;
	JMenuItem itemArtistes, itemAlbums,itemQuit;


	public MenuGestionArtistes() {

		super();
		lejMenu = new JMenu("Menu");
		lejMenu.setMnemonic(KeyEvent.VK_M);
	
		itemArtistes = new JMenuItem("Artistes");
		itemArtistes.setMnemonic(KeyEvent.VK_A);
		itemArtistes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		
		itemAlbums = new JMenuItem("Albums");
		itemAlbums.setMnemonic(KeyEvent.VK_B);
		itemAlbums.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		
		
		itemQuit = new JMenuItem("Quitter");
		itemQuit.setMnemonic(KeyEvent.VK_Q);
		itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

		Aide = new JMenu("?");
		Aide.setMnemonic(KeyEvent.VK_H);
		
		OptListener menuOpt = new OptListener();
		itemArtistes.addActionListener(menuOpt);
		itemAlbums.addActionListener(menuOpt);
		itemQuit.addActionListener(menuOpt);
		
		
		lejMenu.add(itemArtistes);
		lejMenu.add(itemAlbums);
		lejMenu.addSeparator();
		lejMenu.add(itemQuit);
		

		this.add(lejMenu);
		this.add(Aide);
	}
	
	private class OptListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()== itemArtistes) {
				
				exeFrmArtist.main(null);
			}
			
			else if (e.getSource()== itemAlbums) {
				
				JOptionPane.showMessageDialog(null, "Exo-Groupe");
				FrmAlbums.main(null);
			}
			
			else if (e.getSource()== itemQuit)
				
				System.exit(0);
			
			else if (e.getSource()== Aide)
				
				JOptionPane.showMessageDialog(null, "Coming soon");
				FrmAid.main(null);
			
		}
	}
}	
