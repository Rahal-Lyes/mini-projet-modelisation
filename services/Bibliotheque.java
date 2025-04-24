package mini_projet_modelisation.services;


import mini_projet_modelisation.models.Livre;
import mini_projet_modelisation.models.Utilisateur;

import java.util.*;

public class Bibliotheque {
    private static volatile Bibliotheque instance;
    private static final Object lock = new Object();

    private List<Livre> livre = new ArrayList<>();
    private List<Utilisateur> utilisateur = new ArrayList<>();
    private List<String> emprunts = new ArrayList<>();

    private Bibliotheque() {}

    public static Bibliotheque getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) instance = new Bibliotheque();
            }
        }
        return instance;
    }

    public void ajouterLivre(Livre l) { livre.add(l); }
    public void supprimerLivre(Livre l) { livre.remove(l); }

    public List<Livre> rechercherLivre(String titre, SearchStrategy strategie) {
        return strategie.search(livre, titre);
    }

    public void inscrireUtilisateur(Utilisateur u) { utilisateur.add(u); }
}
