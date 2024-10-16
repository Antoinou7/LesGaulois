package Objets;

public enum Equipement {
    CASQUE("Casque"),
    BOUCLIER("Bouclier");

    private String nom;
    // Constructeur pour initialiser l'attribut nom
    private Equipement(String nom) {
        this.nom = nom;
    }

    // Méthode pour récupérer le nom de l'équipement
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
