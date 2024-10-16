package Lieux;
import personnages.Gaulois;
import Objets.Equipement;
import Objets.Trophee;

public class Musee {
	private Trophee[] trophees= new Trophee[200];
	private int nbTrophees;
	
	
	
	public Musee() {
		this.trophees = new Trophee[200];
		this.nbTrophees=0;
		
		
	}
	
	
	
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipements)
	{
		if (nbTrophees < trophees.length) {
			Trophee nouveauTrophee = new Trophee(gaulois, equipements);
			trophees[nbTrophees]=nouveauTrophee;
			nbTrophees++;
			System.out.println(gaulois.getNom() + " a donné un " + equipements + " au musée. ");
		} else {
			System.out.println("Le musée est plein, pas de place pour de nouveaux trophées.");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
