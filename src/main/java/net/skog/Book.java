// Filip Skoglund TE23E
// Denna är klassen för böcker. Den innehåller relevatana variabler samt funktioner för att hantera böcker i biblioteket.

package net.skog;

public class Book extends Publication {

    private String author;
    private String genre;
    private Integer pages;

    public Book(String id, String title, boolean isAvailable, String author, String genre, Integer pages) {
        super(id, title, isAvailable);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", title=" + getTitle() + ", genre=" + genre + ", pages=" + pages + ", Id="
                + getId() + ", availability=" + isAvailable() + "]";
    }
}
