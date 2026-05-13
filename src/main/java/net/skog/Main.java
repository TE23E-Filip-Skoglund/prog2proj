// Filip Skoglund TE23E
// Denna är main klassen. Den innehåller en meny där användaren kan välja att göra diversee saker.
package net.skog;

public class Main {
    LibraryManager manager = new LibraryManager("http://localhost:3000"); // | http://10.151.168.5:3135

    public void main(String[] args) {

        // Synka automatiskt med servern när programmet startas
        try {
            manager.syncWithServer();
        } catch (Exception e) {
            IO.println("Fel vid synkning (vid start): " + e.getLocalizedMessage());
        }

        huvudMeny();
    }

    public void huvudMeny() {
        while (true) {
            IO.println(
                    """
                                   --------- Huvudmeny --------
                                   1. Hantera publikationer (undermeny)
                                   2. Hanter användare (undermeny)
                                   3. Hitta kund
                                   4. Hitta bok/tidning
                                   5. Visa böcker/tidningar/användare/avstängda användare
                                   6. Synca information från servern. (obs! görs automatiskt när det behövs)
                                   7. Avsluta
                            """);
            switch (IO.readln().trim()) {
                case "1" -> managePublicationsMenu();
                case "2" -> manageUsersMenu();
                case "3" -> IO.println("Placeholder: Hitta kund");
                case "4" -> IO.println("Placeholder: Hitta bok/tidning");
                case "5" -> IO.println("Placeholder: Visa böcker/tidningar/användare/avstängda användare");
                case "6" -> manager.syncWithServer();
                case "7" -> {
                    IO.println("Avslutar programmet....");
                    System.exit(0);
                }
                default -> IO.println("Felaktigt val, vg försök igen");
            }
        }
    }

    public void managePublicationsMenu() {
        while (true) {
            IO.println(
                    """
                                --------- Hantera publikationer --------
                                1. Lägg till bok
                                2. Lägg till tidning
                                3. Ta bort publikation
                                4. Tillbaka
                            """);
            switch (IO.readln().trim()) {
                case "1" -> IO.println("Placeholder: Lägg till bok");
                case "2" -> IO.println("Placeholder: Lägg till tidning");
                case "3" -> IO.println("Placeholder: Ta bort publikation");
                case "4" -> {
                    IO.println("Återgår till huvudmenyn....");
                    return;
                }
                default -> IO.println("Felaktigt val, vg försök igen");
            }
        }
    }

    public void manageUsersMenu() {
        while (true) {
            IO.println(
                    """
                                --------- Hantera användare --------
                                1. Lägg till användare
                                2. Ta bort användare
                                3. Stäng av användare
                                4. Återställ avstängd användare
                                5. Tillbaka
                            """);
            switch (IO.readln().trim()) {
                case "1" -> IO.println("Placeholder: Lägg till användare");
                case "2" -> IO.println("Placeholder: Ta bort användare");
                case "3" -> IO.println("Placeholder: Stäng av användare");
                case "4" -> IO.println("Placeholder: Återställ avstängd användare");
                case "5" -> {
                    IO.println("Återgår till huvudmenyn....");
                    return;
                }
                default -> IO.println("Felaktigt val, vg försök igen");
            }
        }
    }
}