package mini_projet_modelisation.services;

import mini_projet_modelisation.models.Livre;

import java.util.*;

public class TitreRecherche implements SearchStrategy {
    public List<Livre> search(List<Livre> livres, String query) {
        return livres.stream().filter(l -> l.getTitre().toLowerCase().contains(query.toLowerCase())).toList();
    }
}