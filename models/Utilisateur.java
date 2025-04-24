package mini_projet_modelisation.models;

public abstract class Utilisateur {
    protected String username;
    protected String password;
    protected String type;

    public Utilisateur(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getType() { return type; }

    public void emprunterLivre() {
        // Logic for borrowing a book
        System.out.println(username + " is borrowing a book.");
    }
}