package mini_projet_modelisation.services;

import mini_projet_modelisation.models.Livre;

import java.util.List;

public interface SearchStrategy {
    List<Livre> search(List<Livre> livres, String query);
}