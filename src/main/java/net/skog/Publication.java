// Filip Skoglund TE23E
// Denna är klassen för publikationer. Den innehåller relevatana variabler samt funktioner för att hantera publikationer, och på så vis samla magasin och böcker i en gemensam klass som de båda ärver ifrån.

package net.skog;

public abstract class Publication {

    private String id;
    private String title;
    private boolean isAvailable;
    
    public Publication(String id, String title, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
