package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	private String texte;
	
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forceActuelle = force;
//		if ((force - forceCoup) < 0) {
//			force = 0;
//			parler("Aie");
//		} else {
//			force -= forceCoup;
//			parler("J'abandonne...");
//		}
//		assert force < forceActuelle;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		 if (force > 0) {
		 	parler("Aïe");
		 } else {
		 	equipementEjecte = ejecterEquipement();
		 	parler("J'abandonne...");
		 }
				// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
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
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
					
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		int i = 0;
		while (i < nbEquipement) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				i++;
			}
		}
		return equipementEjecte;
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
