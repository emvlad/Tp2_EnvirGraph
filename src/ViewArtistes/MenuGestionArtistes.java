package ViewArtistes;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

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
	JMenuItem itemArtistes, itemAlbums,itemQuit,itemAide;


	public MenuGestionArtistes() {

		super();
		OptListener menuOpt = new OptListener();
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
		
		itemAide = new JMenuItem("Aide en ligne");
		itemAide.setActionCommand("Aide en ligne");
		
		itemArtistes.addActionListener(menuOpt);
		itemAlbums.addActionListener(menuOpt);
		itemQuit.addActionListener(menuOpt);		
		
		itemAide.addActionListener(menuOpt);
		
		lejMenu.add(itemArtistes);
		lejMenu.add(itemAlbums);
		lejMenu.addSeparator();
		lejMenu.add(itemQuit);
		
		Aide.add(itemAide);
	
		this.add(lejMenu);
		this.add(Aide);
	}
	
	private class OptListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand());
			if (e.getSource()== itemArtistes) {
				
				exeFrmArtist.main(null);
			}
			
			else if (e.getSource()== itemAlbums) {
				
				JOptionPane.showMessageDialog(null, "Exo-Groupe");
				
			}
			else if (e.getSource()== itemQuit) {
				System.exit(0);
				
			}			
			else if (e.getActionCommand()=="Aide en ligne") {
			
				File leFichier = new File("src/definitions.chm");
				try {
					Desktop.getDesktop().open(leFichier);
				} catch (IOException eio) {
					
					eio.printStackTrace();
				}
			}
				
		}
	}
}	
