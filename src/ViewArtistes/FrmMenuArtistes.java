package ViewArtistes;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;



public class FrmMenuArtistes extends JFrame{

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar;
	JPanel pnlBkGrnd;
	JLabel lblBkGrnd ;

	public FrmMenuArtistes() {

		setSize(600, 400);
		this.setResizable(false);
		this.setTitle("Gestion des artistes");

		ImageIcon logoFenetre = new ImageIcon(FrmMenuArtistes.class.getResource("../icons/dvd.png"));
		this.setIconImage(logoFenetre.getImage());

		menuBar = new MenuGestionArtistes();
		menuBar.setBorder(BorderFactory.createTitledBorder(""));
		this.setJMenuBar(menuBar);

		pnlBkGrnd = new JPanel();

		lblBkGrnd  = new JLabel(new ImageIcon(FrmMenuArtistes.class.getResource("../icons/bkGr.jpg")));

		pnlBkGrnd.add(lblBkGrnd);
		this.add(pnlBkGrnd);

		setLocationRelativeTo (null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}



