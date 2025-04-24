package mini_projet_modelisation.services;

import mini_projet_modelisation.models.Livre;
import mini_projet_modelisation.models.Utilisateur;
import java.util.*;

public class Bibliotheque {
    private static volatile Bibliotheque instance;
    private final List<Livre> livres = new ArrayList<>();  // Liste des livres
    private final List<Utilisateur> utilisateurs = new ArrayList<>();  // Liste des utilisateurs
    private static final Object lock = new Object();

    private Bibliotheque() {}

    public static Bibliotheque getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) instance = new Bibliotheque();
            }
        }
        return instance;
    }

    public void ajouterLivre(Livre l) {
        livres.add(l);  // Ajouter un livre à la liste
    }

    public void supprimerLivre(Livre l) {
        livres.remove(l);  // Supprimer un livre de la liste
    }

    public List<Livre> rechercherLivre(String titre, SearchStrategy strategie) {
        return strategie.search(livres, titre);  // Rechercher dans la liste des livres
    }

    public void inscrireUtilisateur(Utilisateur u) {
        utilisateurs.add(u);  // Ajouter un utilisateur
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;  // Retourner la liste des utilisateurs
    }

    public List<Livre> getLivres() {
        return livres;  // Retourner la liste des livres
    }
}
