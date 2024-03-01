package personnages;


public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois ;
	private Gaulois[] villageois;
	
	

	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		villageois	 = new Gaulois[nbVillageoisMaximum];
		
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}


	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires gaulois ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+trouverHabitant(i).getNom());
		}
	}
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des Iréductibles", 30 );
		//Gaulois gaulois = village.trouverHabitant(30);
		//érreur est du a un index or de porter car le tableau des survivant on des valeur entre O et 29
		village.setChef(new Chef("Abraracourcix", 6, village));
		village.ajouterHabitant(new Gaulois("Asterix", 8));
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//Asterix est le gaulois 0 il n'y a donc pas de vilageois 1
		village.ajouterHabitant(new Gaulois("Obélix", 25));
		village.afficherVillageois();
		
		
	}
	
	
	
	
}
	
