package mini_projet_modelisation.services;

import mini_projet_modelisation.models.Livre;

import java.util.*;

public class ISBNRecherche implements SearchStrategy {
    public List<Livre> search(List<Livre> livres, String query) {
        return livres.stream().filter(l -> String.valueOf(l.getId()).contains(query)).toList();
    }
}
