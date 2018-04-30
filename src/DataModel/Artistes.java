package DataModel;

public class Artistes {

	//attributs
	private int numero;
	private String nom;
	boolean membre;
	private int photo;

	// Constructeur complet
	public Artistes(int numero, String nom, boolean syndique,int photo) {
		this.numero = numero;
		this.nom = nom;
		this.membre = syndique;
		this.photo = photo;
	}

	// Constructeur avec une critere pour la recherche 
	//et la suppression d'employé par numéro
	public Artistes(int numero) {
		this.numero = numero;
		this.nom = "";

	}

	//Accesseurs
	public int getNumero() {
		return this.numero;
	}

	public String getNom() {
		return this.nom;
	}


	public boolean isMembre() {
		return this.membre;
	}

	public int getPhoto() {
			return this.photo;
	}
	
	

}
