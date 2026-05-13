// Filip Skoglund TE23E
// Denna är klassen för suspendedUsers. Den innehåller relevanta variabler samt funktioner för att hantera suspendedUsers i biblioteket.

package net.skog;

public class SuspendedUser {
    private String id;
    private String userId;
    private String reason;

    public SuspendedUser(String id, String userId, String reason) {
        this.id = id; // is this really needed? (if the server generates it)
        this.userId = userId;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return String.format("Avstängd kund: %s | Anledning: %s (ID, för avstägningen: %s)", userId, reason, id);
    }
}