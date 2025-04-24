package mini_projet_modelisation.models;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Utilisateur {
    public Admin( String nom, String motDePass) {
        super(nom, motDePass);
    }

    public void ajouterLivre() {
        System.out.println("Admin ajoute un livre.");
    }

    public void supprimerLivre() {
        System.out.println("Admin supprime un livre.");
    }

    @Override
    public void emprunterLivre() {
        System.out.println("Admin emprunte un livre.");
    }
}