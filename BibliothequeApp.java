package mini_projet_modelisation;

import mini_projet_modelisation.models.Livre;
import mini_projet_modelisation.models.Utilisateur;
import mini_projet_modelisation.services.Bibliotheque;
import mini_projet_modelisation.services.TitreRecherche;
import mini_projet_modelisation.services.UtilisateurFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BibliothequeApp extends JFrame {

    private JTextField nomUtilisateurField, idUtilisateurField, mdpField, typeField;
    private JTextField codeLivreField, titreLivreField, auteurLivreField;
    private JTextField rechercheTitreField;
    private JTextArea outputArea;

    private final Bibliotheque biblio = Bibliotheque.getInstance();

    public BibliothequeApp() {
        setTitle("Bibliothèque");
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Création de la zone de texte de sortie
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panneau pour les champs utilisateurs et livres
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants

        // Utilisateur
        JLabel typeLabel = new JLabel("Type (admin/lecteur) :");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(typeLabel, gbc);

        typeField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(typeField, gbc);

        JLabel idUtilisateurLabel = new JLabel("ID utilisateur :");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(idUtilisateurLabel, gbc);

        idUtilisateurField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(idUtilisateurField, gbc);

        JLabel nomUtilisateurLabel = new JLabel("Nom utilisateur :");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nomUtilisateurLabel, gbc);

        nomUtilisateurField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nomUtilisateurField, gbc);

        JLabel mdpLabel = new JLabel("Mot de passe :");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(mdpLabel, gbc);

        mdpField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(mdpField, gbc);

        JButton ajouterUtilisateurBtn = new JButton("Ajouter Utilisateur");
        ajouterUtilisateurBtn.addActionListener(e -> ajouterUtilisateur());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(ajouterUtilisateurBtn, gbc);

        // Livre
        JLabel codeLivreLabel = new JLabel("Code Livre :");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(codeLivreLabel, gbc);

        codeLivreField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(codeLivreField, gbc);

        JLabel titreLivreLabel = new JLabel("Titre Livre :");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(titreLivreLabel, gbc);

        titreLivreField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(titreLivreField, gbc);

        JLabel auteurLivreLabel = new JLabel("Auteur Livre :");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(auteurLivreLabel, gbc);

        auteurLivreField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(auteurLivreField, gbc);

        JButton ajouterLivreBtn = new JButton("Ajouter Livre");
        ajouterLivreBtn.addActionListener(e -> ajouterLivre());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(ajouterLivreBtn, gbc);

        // Recherche Livre
        JLabel rechercheTitreLabel = new JLabel("Rechercher Titre Livre :");
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(rechercheTitreLabel, gbc);

        rechercheTitreField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(rechercheTitreField, gbc);

        JButton rechercherLivreBtn = new JButton("Rechercher");
        rechercherLivreBtn.addActionListener(e -> rechercherLivre());
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(rechercherLivreBtn, gbc);

        // Affichage
        JButton afficherBtn = new JButton("Afficher Tout");
        afficherBtn.addActionListener(e -> afficherTout());
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        panel.add(afficherBtn, gbc);

        add(panel, BorderLayout.NORTH);
    }

    private void ajouterUtilisateur() {
        String type = typeField.getText();
        int id = Integer.parseInt(idUtilisateurField.getText());
        String nom = nomUtilisateurField.getText();
        String mdp = mdpField.getText();

        Utilisateur u = UtilisateurFactory.creeUtilisateur(type, id, nom, mdp);
        biblio.inscrireUtilisateur(u);
        outputArea.append("Utilisateur ajouté : " + nom + "\n");
    }

    private void ajouterLivre() {
        String code = codeLivreField.getText();
        String titre = titreLivreField.getText();
        String auteur = auteurLivreField.getText();

        Livre livre = new Livre(code, titre, auteur);
        biblio.ajouterLivre(livre);
        outputArea.append("Livre ajouté : " + titre + "\n");
    }

    private void rechercherLivre() {
        String motCle = rechercheTitreField.getText();
        List<Livre> resultats = biblio.rechercherLivre(motCle, new TitreRecherche());

        if (resultats.isEmpty()) {
            outputArea.append("Aucun livre trouvé pour : " + motCle + "\n");
        } else {
            for (Livre l : resultats) {
                outputArea.append("Livre trouvé : " + l.getTitre() + "\n");
            }
        }
    }

    private void afficherTout() {
        outputArea.append("\n--- Utilisateurs ---\n");
        for (Utilisateur u : biblio.getUtilisateurs()) {
            outputArea.append(u.getType() + " - " + u.getUsername() + "\n");
        }

        outputArea.append("--- Livres ---\n");
        for (Livre l : biblio.getLivres()) {
            outputArea.append(l.getTitre() + " - " + l.getAuteur() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BibliothequeApp app = new BibliothequeApp();
            app.setVisible(true);
        });
    }
}
