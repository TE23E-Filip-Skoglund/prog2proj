package net.skog;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kong.unirest.core.Unirest;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.UnirestException;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();

    // private List<Publication> publications; FÖR SENARE NIVÅREERERE
    // private List<User> users; FÖR SENARE NIVÅREERERE
    // private List<SuependedUser> suspendedUser; FÖR SENARE NIVÅPER
    Gson gson = new Gson();

    private String serverUrl;

    public LibraryManager(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    // Hämta och lagra böcker från servern
    public void fetchBooks() {
        HttpResponse<String> response;
        try {
            response = Unirest.get(serverUrl + "/books").asString();
            String responseBody = response.getBody();
            List<Book> fetched = gson.fromJson(responseBody, new TypeToken<List<Book>>(){}.getType());
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }
    }

    // Hämta och lagra böcker från servern
    public void fetchMagazines() {
        HttpResponse<String> response;
        try {
            response = Unirest.get(serverUrl + "/magazines").asString();
            String responseBody = response.getBody();
            List<Magazine> fetched = gson.fromJson(responseBody, new TypeToken<List<Magazine>>(){}.getType());
        } catch (UnirestException e) {
            IO.println("Fel vid uppkoppliung: " + e.getLocalizedMessage());
        }
    }

    public void addPublication(Publication pub) {
    }

}