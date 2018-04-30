package DataModel;

public class Albums {
	
	
	//attributs
		private int id;
		private int anneeSortie;
		private String titre;
		private String genre;
		private String distributeur;
		private double prix;
		private String imgCover;
		private int numArtiste;

		// Constructeur complet
	
		// Constructeur avec une critere pour la recherche 
		//et la suppression d'employé par numéro
		public Albums(int id) {
			this.id = id;
			this.anneeSortie= 0;
		

		}

		public Albums(int id, int anneeSortie, String titre, String genre, String distributeur,
				      double prix,String imgCover, int numArtiste) {
			super();
			this.id = id;
			this.anneeSortie = anneeSortie;
			this.titre = titre;
			this.genre = genre;
			this.distributeur = distributeur;
			this.prix = prix;
			this.imgCover = imgCover;
			this.numArtiste = numArtiste;
		}

		
		//Accesseurs
		public int getId() {
			return this.id;
		}

		public int getAnneeSortie() {
			return this.anneeSortie;
		}


		
		public String getTitre() {
				return this.titre;
		}
		

		public String getDistributeur() {
				return this.distributeur;
		}
		
		public double getPrix() {
			return this.prix;
	}
		
		public String getImgCover() {
			return this.distributeur;
			
	}
		public int getNumArtiste() {
			return this.numArtiste;
		}
		
		public String getGenre() {
			return this.genre;
		}

		public String getImagCover() {
			return this.imgCover;
		}


}
