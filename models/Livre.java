package mini_projet_modelisation.models;

public class Livre {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Livre(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public String getTitre() { return title; }
    public String getAuteur() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public String getId() {
        return this.isbn;
    }


}