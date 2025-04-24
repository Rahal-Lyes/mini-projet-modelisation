package mini_projet_modelisation.services;

import mini_projet_modelisation.models.Admin;
import mini_projet_modelisation.models.Lecteur;
import mini_projet_modelisation.models.Utilisateur;

public class UtilisateurFactory {
    public static Utilisateur creeUtilisateur(String type, int id, String nom, String motDePass) {
        return switch (type.toLowerCase()) {
            case "lecteur" -> new Lecteur( nom, motDePass);
            case "admin" -> new Admin( nom, motDePass);
            default -> null;
        };
    }
}
