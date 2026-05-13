// Filip Skoglund TE23E
// Denna är klassen för users. Den innehåller relevanta variabler samt funktioner för att hantera users i biblioteket.

package net.skog;

public class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return String.format("Kund: %s | E-post: %s (ID: %s)", name, email, id);
    }
}
