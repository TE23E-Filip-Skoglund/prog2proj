package net.skog;

public class book extends Publication {

    private String author;
    private String  genre;
    private Integer pages;
    
    public book(String id, String title, boolean isAvailable, String author, String genre, Integer pages) {
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

}
