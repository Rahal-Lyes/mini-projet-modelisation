package omini_projet_modelisation.models;

public class Emprunt extends Utilisateur {
    public Emprunt(String username, String password) {
        super(username, password);
        this.type = "Emprunt";
    }
}