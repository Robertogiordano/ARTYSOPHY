package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Artwork;
import dao.Artist;
import dao.Museum;
import manager.getAll.GetAllArtistsCommand;
import manager.getAll.GetAllArtworksCommand;
import manager.getAll.GetAllMuseumsCommand;

public class CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();
    private static List<Artist> artists;
    private static List<Museum> museums;
    private static List<Artwork> artworks;

    public CommandInvoker(List<Artist> autors, List<Museum> museums, List<Artwork> artworks) {
        this.artists = autors;
        this.museums = museums;
        this.artworks = artworks;

        commands.put("artists", new GetAllArtistsCommand());
        commands.put("museumGuide", new GetAllMuseumsCommand());
        commands.put("artGalery", new GetAllArtworksCommand());

    }

    public static List<Artist> getArtists() {
        return artists;
    }

    public static List<Museum> getMuseums() {
        return museums;
    }

    public static List<Artwork> getArtworks() {
        return artworks;
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command == null) {
            System.out.println("Unknown command: " + commandName);
        } else {
            command.execute();
        }
    }
}
