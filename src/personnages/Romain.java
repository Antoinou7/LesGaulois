package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;

	public Romain(String nom, int force) {
		assert (force>0);
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert (force>0);
		int forceAvant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (force < forceAvant);
		
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