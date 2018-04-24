package LonginTp2Chris;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Toolkit;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import ViewArtistes.MainExeGestionArtist;

import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class LoginToDB {

	private JFrame frmLogArtMzks;
	private JTextField txtUserName;
	private JPasswordField txtPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginToDB window = new LoginToDB();
					window.frmLogArtMzks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginToDB() {
		initialize();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogArtMzks = new JFrame();
		frmLogArtMzks.setType(Type.POPUP);
		frmLogArtMzks.setFont(null);
		frmLogArtMzks.setForeground(SystemColor.inactiveCaptionText);
		frmLogArtMzks.setResizable(false);
		frmLogArtMzks.setTitle("Artistes Musiciens Albums Login");
		frmLogArtMzks.setBackground(UIManager.getColor("Table.selectionBackground"));
		frmLogArtMzks.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginToDB.class.getResource("/icons/antenna.png")));
		frmLogArtMzks.getContentPane().setBackground(SystemColor.activeCaption);
		frmLogArtMzks.getContentPane().setForeground(SystemColor.info);
		frmLogArtMzks.setBounds(60,60, 452, 294);
		
		frmLogArtMzks.setLocationRelativeTo(null);;
		
		frmLogArtMzks.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmLogArtMzks.getContentPane().setLayout(null);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setEchoChar('*');
		txtPasswordField.setBackground(SystemColor.text);
		txtPasswordField.setBounds(203, 123, 178, 20);
		frmLogArtMzks.getContentPane().add(txtPasswordField);

		JLabel lblconnectProg = new JLabel("Connection au programme");
		lblconnectProg.setForeground(SystemColor.textHighlight);
		lblconnectProg.setIcon(new ImageIcon(LoginToDB.class.getResource("/icons/connect.png")));
		lblconnectProg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblconnectProg.setBounds(42, 9, 305, 48);
		frmLogArtMzks.getContentPane().add(lblconnectProg);

		JLabel lbluserName = new JLabel("Nom Utilisateur");
		lbluserName.setBackground(SystemColor.info);
		lbluserName.setForeground(SystemColor.info);
		lbluserName.setIcon(new ImageIcon(LoginToDB.class.getResource("/icons/testimonials.png")));
		lbluserName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbluserName.setBounds(71, 79, 141, 32);
		frmLogArtMzks.getContentPane().add(lbluserName);

		txtUserName = new JTextField();
		txtUserName.setToolTipText("Entrer un identifiant");
		txtUserName.setBounds(203, 83, 178, 20);
		frmLogArtMzks.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblpassWord = new JLabel("Mot de passe");
		lblpassWord.setIcon(new ImageIcon(LoginToDB.class.getResource("/icons/key1.png")));
		lblpassWord.setForeground(SystemColor.info);
		lblpassWord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblpassWord.setBounds(81, 122, 115, 28);
		frmLogArtMzks.getContentPane().add(lblpassWord);

		JButton btnValidLogin = new JButton("Valider");
		btnValidLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("deprecation")
				String passWrd = txtPasswordField.getText();
				String userName = txtUserName.getText();
				
				if(passWrd.equals("ADMIN") && userName.equals("ADMIN") ) {
					txtPasswordField.setText(null);
					txtUserName.setText(null);						
									
					MainExeGestionArtist.main(null);
							
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Vos identifiants sont invalides.\nPassword ou Nom utilisateur !"
							,"Login Erreurs",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnValidLogin.setSelectedIcon(new ImageIcon(LoginToDB.class.getResource("/icons/check.png")));
		btnValidLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnValidLogin.setForeground(SystemColor.textHighlight);
		btnValidLogin.setIcon(new ImageIcon(LoginToDB.class.getResource("/icons/check.png")));
		btnValidLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnValidLogin.setBounds(70, 180, 113, 30);
		frmLogArtMzks.getContentPane().add(btnValidLogin);

		JPanel pnlUserPass = new JPanel();
		pnlUserPass.setBackground(SystemColor.activeCaption);
		pnlUserPass.setBounds(60, 69, 333, 91);
		frmLogArtMzks.getContentPane().add(pnlUserPass);

		JButton btnAnnulerLogin = new JButton("Quitter");
		
		btnAnnulerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			frmLogArtMzks = new JFrame("Exit");
			if(JOptionPane.showConfirmDialog(frmLogArtMzks, "Voulez vous quitter?", "Login Mode - Confirmation"
					,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}

			}
		});
		btnAnnulerLogin.setSelectedIcon(new ImageIcon(LoginToDB.class.getResource("/icons/annuler.png")));
		btnAnnulerLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnnulerLogin.setIcon(new ImageIcon(LoginToDB.class.getResource("/icons/annuler.png")));
		btnAnnulerLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnnulerLogin.setForeground(SystemColor.textHighlight);
		btnAnnulerLogin.setBounds(265, 180, 113, 30);
		frmLogArtMzks.getContentPane().add(btnAnnulerLogin);

		btnAnnulerLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnValidLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel pnlValidQ = new JPanel();
		pnlValidQ.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlValidQ.setBackground(SystemColor.activeCaption);
		pnlValidQ.setBounds(60, 170, 333, 50);
		frmLogArtMzks.getContentPane().add(pnlValidQ);
		
		JPanel pnlConnectProg = new JPanel();
		pnlConnectProg.setBackground(SystemColor.info);
		pnlConnectProg.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlConnectProg.setBounds(30, 37, 388, 200);
		frmLogArtMzks.getContentPane().add(pnlConnectProg);


		btnAnnulerLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10)
					System.exit(0);
			}
		});




	}
}
