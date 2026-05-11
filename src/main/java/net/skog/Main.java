// Filip Skoglund TE23E
// Denna är main klassen. Den innehåller en meny där användaren kan välja att göra diversee saker.
package net.skog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager("http://10.151.168.5:3135"); // http://localhost:3000
        Scanner sc = new Scanner(System.in);

        while (true) {

            IO.println(
                    """
                                   --------- PROGRAM --------
                                   1. Hämta böcker (hämta böcker från Servern och lagra lokalt i ex ArrayList).
                                   2. Hämta tidningar (hämta tidningar från Servern och lagra lokalt i ex ArrayList).
                                   3. Skriva ut hämtade böcker eller tidningar på skärmen
                                   4. Lägg till bok, skapa ett bokobjekt där användaren får mata in titel, författare, genre, pages (antal sidor) och spara den i en Samling (ex ArrayList).
                                   5. Lägg till tidning, skapa ett tidningsobjekt där användaren får mata in titel, författare, genre, pages (antal sidor) etc och spara den i en Samling (exArrayList).
                                   6. Avsluta
                            """);

            switch (IO.readln()) {
                case "1" -> manager.fetchBooks();
                case "2" -> manager.fetchMagazines();
                case "3" -> manager.PrintAll5050();
                case "4" -> manager.addBook();
                case "5" -> manager.addMagazine();
                case "6" -> {
                    IO.println("Avslutar programmet....");
                    System.exit(0);
                }
                default -> IO.println("Felaktigt val, vg försök igen");
            }

        }

    }
}