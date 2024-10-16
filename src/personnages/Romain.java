package personnages;

import Objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	

	public Romain(String nom, int force) {
		assert (force > 0);
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert (force>0);
//		int forceAvant = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (force < forceAvant);
//		
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;

	    // Précondition : la force doit être positive
	    assert force > 0;

	    int oldForce = force;
	    forceCoup = calculResistanceEquipement(forceCoup);

	    // Si la force du coup après résistance est suffisante, on diminue la force
	    if (forceCoup > 0) {
	        force -= forceCoup;
	    }

	    if (force > 0) {
	        parler("Aïe");
	    } else {
	        equipementEjecte = ejecterEquipement();
	        parler("J'abandonne...");
	    }

	    // Postcondition : la force a diminué seulement si le coup était suffisamment fort
	    assert force < oldForce || forceCoup == 0 : "La force n'a pas diminué car la résistance de l'équipement était suffisante";

	    return equipementEjecte;
	}


	private int calculResistanceEquipement(int forceCoup) {
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;

	    // Vérifier s'il y a des équipements
	    if (nbEquipement > 0) {
	        texte += "\nMais heureusement, grâce à mon équipement, sa force est diminuée de ";

	        for (int i = 0; i < nbEquipement; i++) {
	            if (equipements[i] != null) {
	                if (equipements[i].equals(Equipement.BOUCLIER)) {
	                    resistanceEquipement += 8;
	                } else if (equipements[i].equals(Equipement.CASQUE)) {
	                    resistanceEquipement += 5;
	                }
	            }
	        }

	        texte += resistanceEquipement + "!";
	    }

	    // Afficher les informations de résistance
	    parler(texte);

	    // Appliquer la résistance à la force du coup
	    forceCoup -= resistanceEquipement;

	    // S'assurer que la force du coup ne soit pas négative
	    if (forceCoup < 0) {
	        forceCoup = 0;
	    }

	    return forceCoup;
	}


	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
			}
		}
		return equipementEjecte;
		}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: // Le Romain a déjà deux équipements
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;

		case 1: // Le Romain a un équipement, on vérifie s'il a déjà celui-là
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;

		case 0: // Le Romain n'a aucun équipement
			ajouterEquipement(equipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		System.out.println(minus);
		System.out.println(Equipement.CASQUE);

	}

}