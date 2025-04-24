package mini_projet_modelisation.models;

public class Lecteur extends Utilisateur {
    public Lecteur(String nom, String motDePass) {
        super(nom, motDePass);
    }

    @Override
    public void emprunterLivre() {
        System.out.println("Lecteur emprunte un livre.");
    }
}
