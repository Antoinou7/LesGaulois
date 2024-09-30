package personnages;
import java.util.*;


public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obélix")) {
			parler("Non Obélix ! Tu es tombé dans la marmite quand tu étais petit");
		} else {
		int forcePotion = preparerPotion();
		gaulois.boirePotion(forcePotion);
		}
		
	}
	public int preparerPotion() {
		Random random = new Random();
		int forcePotion = random.nextInt(effetPotionMax-effetPotionMin + 1 )+ effetPotionMin;
		if (forcePotion>7) {
			parler("J'ai préparer une super potion de force " + forcePotion + ".");
		}else {
			parler("Ma potion est seulement de force "+ forcePotion + ".");
		}
		return forcePotion;
		
	}
	
	
	public static void main(String[] args) {

		Druide panoramix;
		panoramix = new Druide("Panoramix", 5,10);
		System.out.println(panoramix);
		panoramix.parler("Je vais préparer des potions");
		panoramix.preparerPotion();

	}

}