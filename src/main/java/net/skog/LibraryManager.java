// Filip Skoglund TE23E
// Denna är klassen innehåller mestadels av all hantering kring biblioteket och dess funktioner.

package net.skog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

public class LibraryManager {

    private List<Publication> publications = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<SuspendedUser> suspendedUsers = new ArrayList<>();
    Gson gson = new Gson();

    private String serverUrl;

    public LibraryManager(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void syncWithServer() {
        fetchPublications();
        fetchUsers();
    }

    // Hämta publikationer från servern
    public void fetchPublications() {
        try {
            HttpResponse<String> response = Unirest.get(serverUrl + "/books").asString();
            String responseBody = response.getBody();
            List<Book> fetched = gson.fromJson(responseBody, new TypeToken<List<Book>>() {
            }.getType());
            publications.addAll(fetched);
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }

        try {
            HttpResponse<String> response = Unirest.get(serverUrl + "/magazines").asString();
            String responseBody = response.getBody();
            List<Magazine> fetched = gson.fromJson(responseBody, new TypeToken<List<Magazine>>() {
            }.getType());
            publications.addAll(fetched);
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }
    }

    // Hämta users & suspendedUsers från servern
    public void fetchUsers() {
        // Users
        HttpResponse<String> response;
        try {
            response = Unirest.get(serverUrl + "/users").asString();
            String responseBody = response.getBody();
            List<User> fetched = gson.fromJson(responseBody, new TypeToken<List<User>>() {
            }.getType());
            users.addAll(fetched);
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }

        // Suspendedusers
        try {
            response = Unirest.get(serverUrl + "/suspended").asString();
            String responseBody = response.getBody();
            List<SuspendedUser> fetched = gson.fromJson(responseBody, new TypeToken<List<SuspendedUser>>() {
            }.getType());
            suspendedUsers.addAll(fetched);
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }
    }

    // Printa ut böcker ELLER tidningar
    public void PrintAll5050() {
        Random rand = new Random();
        int random = rand.nextInt(2);

        if (random == 1) {
            IO.println("-- Böcker --");
            publications.stream()
                    .filter(p -> p instanceof Book)
                    .forEach(IO::println);
        } else {
            IO.println("-- Tidningar --");
            publications.stream()
                    .filter(p -> p instanceof Magazine)
                    .forEach(IO::println);
        }

    }

    // printa ut användare (för test)
    public void PrintUsers() {
        IO.println("-- Användare --");
        users.forEach(IO::println);
    }

    // Lägg till bok
    public void addBook() {

        IO.println("---- Lägg till ny bok ----");
        while (true) {
            // Hantera inmatningar + förhindra att programmet crashar då användaren matar in
            // ex: bokstav när de är siffra
            IO.print("Ange författare: ");
            String author = IO.readln();
            IO.print("Ange titel: ");
            String title = IO.readln();
            IO.print("Ange genre: ");
            String genre = IO.readln();
            IO.print("Ange antal sidor: ");
            Integer pages;
            try {
                pages = Integer.parseInt(IO.readln());
            } catch (NumberFormatException e) {
                IO.println("Felaktigt format på sidantal. Vänligen ange ett giltigt heltal. \nFörsök igen:");
                continue;
            }

            // Kolla så alla variabler är giltiga och ifylda
            if (author.isBlank() || title.isBlank() || genre.isBlank() || pages <= 0) {
                IO.println("Felaktigt format. Vänligen se till att alla fält är ifyllda. \nFörsök igen:");
                continue;
            }
            // Skapa nästa id baserat på storleken av listan
            String id = String.valueOf(publications.size() + 1);
            // Skapa en ny book baserad på användarens inmatningar + lägg till den i listan
            Book book = new Book(id, title, true, author, genre, pages);
            publications.add(book);
            IO.println("---------------\nBok tillagd framgångsrikt: " + book);
            break;
        }

    }

    // Lägg till tidningar
    public void addMagazine() {
        IO.println("---- Lägg till ny tidning ----");
        while (true) {
            // Hantera inmatningar + förhindra att programmet crashar då användaren matar in
            // ex: bokstav när de är siffra
            IO.print("Ange nummer: ");
            Integer issueNum;
            try {
                issueNum = Integer.parseInt(IO.readln());
            } catch (NumberFormatException e) {
                IO.println("Felaktigt format på nummer. Vänligen ange ett giltigt heltal. \nFörsök igen:");
                continue;
            }
            IO.print("Ange titel: ");
            String title = IO.readln();
            IO.print("Ange kategori: ");
            String category = IO.readln();
            IO.print("Ange publiceringsår: ");
            Integer publishedYear;
            try {
                publishedYear = Integer.parseInt(IO.readln());
            } catch (NumberFormatException e) {
                IO.println("Felaktigt format på publiseringsår. Vänligen ange ett giltigt årtal. \nFörsök igen:");
                continue;
            }

            // Kolla så alla variabler är giltiga och ifylda
            if (issueNum <= 0 || title.isBlank() || category.isBlank() || publishedYear <= 0) {
                IO.println("Felaktigt format. Vänligen se till att alla fält är ifyllda. \nFörsök igen:");
                continue;
            }

            // Skapa ett nytt magasin, id baseras på antalet befinliga +1, magasinet är
            // baserat på användarens inmatningar
            String id = String.valueOf(publications.size() + 1);
            Magazine magazine = new Magazine(id, title, true, issueNum, category, publishedYear);
            publications.add(magazine);

            IO.println("---------------\nTidning tillagd framgångsrikt: " + magazine);
            break;
        }
    }

}