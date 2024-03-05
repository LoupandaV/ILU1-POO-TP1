package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
		equipements= new Equipement[2];
		nbEquipement=0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< "+ texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceActuelle = force;
		if ((force - forceCoup) < 0) {
			force = 0;
			parler("Aie");
		} else {
			force -= forceCoup;
			parler("J'abandonne...");
		}
		assert force < forceActuelle;
	}
	
	public void sEquiper(Equipement equipement) {
		if (nbEquipement>=2) {
			parlerSoldat("est déja bien protégé !");
		} 
		else if (nbEquipement > 0 && equipements[nbEquipement-1]== equipement) {
			parlerSoldat("possède déja un "+equipement+".");
			
		}
		else {
			equipements[nbEquipement]=equipement;
			nbEquipement+=1;
			parlerSoldat("s'équipe avec un "+ equipement+".");
			}
		}

	
	

	private void parlerSoldat(String message) {
		System.out.println( "Le soldat " + nom + " "+message);
	}
	
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement casque= Equipement.CASQUE;
		Equipement bouclier= Equipement.BOUCLIER;
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);
		
				
		
	}

}
