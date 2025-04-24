package mini_projet_modelisation;


import mini_projet_modelisation.models.Livre;
import mini_projet_modelisation.models.Utilisateur;
import mini_projet_modelisation.services.Bibliotheque;
import mini_projet_modelisation.services.TitreRecherche;
import mini_projet_modelisation.services.UtilisateurFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bibliotheque biblio = Bibliotheque.getInstance();

         Utilisateur admin = UtilisateurFactory.creeUtilisateur("admin", 1, "Amine", "admin123");
         Utilisateur lecteur = UtilisateurFactory.creeUtilisateur("lecteur", 2, "Zohra", "pass123");

         biblio.inscrireUtilisateur(admin);
         biblio.inscrireUtilisateur(lecteur);

         Livre livre1 = new Livre("A02", "Le Petit Prince", "Saint-Exupéry");
         Livre livre2 = new Livre("A01", "L'Étranger", "Camus");

         biblio.ajouterLivre(livre1);
         biblio.ajouterLivre(livre2);

         List<Livre> resultats = biblio.rechercherLivre("Prince", new TitreRecherche());
         resultats.forEach(l -> System.out.println("Livre trouvé: " + l.getTitre()));

//        System.out.println("Hello Word");
    }
}

