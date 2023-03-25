package manager;

import java.util.HashMap;
import java.util.Map;

import dao.User;

public class CommandInvoker {

    private static CommandInvoker instance;
    private final Map<String, Command> commands = new HashMap<>();

    private static Integer artist_ActiveId=-1;
    private static Integer artwork_ActiveId=-1;
    private static Integer museum_ActiveId=-1;
    private static User user=null;

    public CommandInvoker(User user) {
        commands.put("artists", new GetAllArtistsCommand());
        commands.put("museumGuide", new GetAllMuseumsCommand());
        commands.put("artGalery", new GetAllArtworksCommand());
        commands.put("seeArtist", new SeeArtistCommand(artist_ActiveId));
        commands.put("seeMuseum", new SeeMuseumCommand(museum_ActiveId));
        commands.put("seeArtwork", new SeeArtworkCommand(artwork_ActiveId));
        commands.put("login",new UserLoginCommand(user));
        commands.put("register",new UserRegisterCommand(user));
        commands.put("modifyUser",new UserModifyClass(user));
    }

    public static CommandInvoker getInstance(){
        if(instance==null){
            instance=new CommandInvoker(user);
        }
        return instance;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        CommandInvoker.user = user;
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
