package net.skog;

import java.util.Scanner;

import kong.unirest.core.Unirest;

public class Main {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager("http://localhost:3000");
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
                case "6" -> {
                    IO.println("Avslutar programmet....");
                    System.exit(0);
                    }
                default -> IO.println("Felaktigt val, vg försök igen");
            }

        }

    }
}