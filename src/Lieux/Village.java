package Lieux;

import personnages.Chef;
import personnages.Gaulois;
import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageois=0;
		this.villageois= new Gaulois[nbVillageoisMax];
		
	}
	
	public void setChef (Chef chef) {
		this.chef =chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois< villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Impossible de placer un villageois, le village est déjà plein !");
		}
	}
	
	public Gaulois trouverHabitant(int numero) {
		if (numero>=0 && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Aucun villageois ne correspond à ce numéro");
			return null;
		}
	}
	
	public static void main(String[] args) {
		Village villageI = new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		Chef abraracourcix = new Chef("Abraracourcix",6,villageI);
		villageI.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		villageI.ajouterHabitant(asterix);
		Gaulois gaulois = villageI.trouverHabitant(0);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix",25);
		villageI.ajouterHabitant(obelix);
		villageI.afficherVillageois();
	}
	
	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Le chef du village est "+ chef.getNom());
		}else {
			System.out.println("Le village n'a pas encore de chef");
		}
		System.out.println("Dans le village "+ nom + " du chef " + chef.getNom()+" il y a " + nbVillageois + " villageois");
		System.out.println("Ces villageois sont :");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("-"+villageois[i].getNom());
		}
		
		
	}
	
}
