// Filip Skoglund TE23E
// Denna är main klassen. Den innehåller en meny där användaren kan välja att göra diversee saker.
package net.skog;

public class Main {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager("http://localhost:3000"); //  | http://10.151.168.5:3135

        try {
            // Synka automatiskt med servern när programmet startas
            manager.syncWithServer();
        } catch (Exception e) {
            IO.println("Fel vid uppkoppliung NEG: " + e.getLocalizedMessage());
        }


        while (true) {

            IO.println(
                    """
                                   --------- PROGRAM --------
                                   1. Synca information från servern. (obs! görs automatiskt när det behövs)
                                   2. DEPRICATED Hämta tidningar (hämta tidningar från Servern och lagra lokalt i ex ArrayList).
                                   3. Skriva ut hämtade böcker eller tidningar på skärmen
                                   4. Lägg till bok, skapa ett bokobjekt där användaren får mata in titel, författare, genre, pages (antal sidor) och spara den i en Samling (ex ArrayList).
                                   5. Lägg till tidning, skapa ett tidningsobjekt där användaren får mata in titel, författare, genre, pages (antal sidor) etc och spara den i en Samling (exArrayList).
                                   6. Avsluta
                            """);

            switch (IO.readln()) {
                case "1" -> manager.syncWithServer();
                case "2" -> IO.println("DEPRICATED");
                case "3" -> manager.PrintAll5050();
                case "4" -> manager.addBook();
                case "5" -> manager.PrintUsers();
                case "6" -> {
                    IO.println("Avslutar programmet....");
                    System.exit(0);
                }
                default -> IO.println("Felaktigt val, vg försök igen");
            }

        }

    }
}