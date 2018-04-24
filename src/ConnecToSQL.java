import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class ConnecToSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1-objet de connection
				Connection circuit = null;

				//2-instances path-user-passWord
				String urlSQL= "jdbc:mysql://localhost:/src/albmziks" ;		
				String user="root";
				String password= "vlad2312";		
				

				try {
					//3-charger le pilote
					Class.forName("com.mysql.jdbc.Driver");			
					
					System.out.print("Le pilote est charg\u00E9,");

					//4- charger le diver pour se connecter à la base de données du dossier local
					circuit = DriverManager.getConnection(urlSQL,user,password);
					System.out.println(" et je suis connect\u00E9.");

				} catch (ClassNotFoundException cnfe) {
					System.out.println(" ERREUR: Vérifier l'installation du pilote");

				} catch (SQLException se) {
					System.out.println(" ERREUR: Vérifier l'existence de la base de donn\u00E9es ");		
				}finally {
					try { 
						//fermer la connexion
						if(circuit !=null) {
							circuit.close();
						}
					} catch(SQLException se){
						System.out.println("ERREUR: Impossible de fermer la connexion");

					}
				}

			}


}
