package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.User;

public class CommandInvoker {

    private static CommandInvoker instance;
    private final Map<CommandsType, Command> commands = new HashMap<>();

    private static Integer artist_ActiveId=-1;
    private static Integer artwork_ActiveId=-1;
    private static Integer museum_ActiveId=-1;
    private static User user=null;

    private CommandInvoker(User user) {
        commands.put(CommandsType.ARTISTS, new GetAllArtistsCommand());
        commands.put(CommandsType.MUSEUM_GUIDE, new GetAllMuseumsCommand());
        commands.put(CommandsType.ART_GALERY, new GetAllArtworksCommand());
        commands.put(CommandsType.SEE_ARTIST, new SeeArtistCommand(artist_ActiveId));
        commands.put(CommandsType.SEE_MUSEUM, new SeeMuseumCommand(museum_ActiveId));
        commands.put(CommandsType.SEE_ARTWORK, new SeeArtworkCommand(artwork_ActiveId));
        commands.put(CommandsType.LOGIN,new UserLoginCommand(user));
        commands.put(CommandsType.REGISTER,new UserRegisterCommand(user));
        commands.put(CommandsType.MODIFY_USER,new UserModifyClass(user));
        commands.put(CommandsType.LOGOUT,new UserLogoutCommand());
    }

    public static CommandInvoker getInstance(User user){
        if(instance==null){
            instance=new CommandInvoker(user);
        }
        return instance;
    }

    public static void releaseInstance() {
        CommandInvoker.instance = null;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        CommandInvoker.user = user;
    }

    public static Integer getArtist_ActiveId() {
        return artist_ActiveId;
    }

    public static void setArtist_ActiveId(Integer artist_ActiveId) {
        CommandInvoker.artist_ActiveId = artist_ActiveId;
    }

    public static Integer getArtwork_ActiveId() {
        return artwork_ActiveId;
    }

    public static void setArtwork_ActiveId(Integer artwork_ActiveId) {
        CommandInvoker.artwork_ActiveId = artwork_ActiveId;
    }

    public static Integer getMuseum_ActiveId() {
        return museum_ActiveId;
    }

    public static void setMuseum_ActiveId(Integer museum_ActiveId) {
        CommandInvoker.museum_ActiveId = museum_ActiveId;
    }

    public List<Object> executeCommand(CommandsType commandName) {
        Command command = commands.get(commandName);
        if (command == null) {
            System.out.println("Unknown command: " + commandName);
            return null;
        } else {
            return command.execute();
        }
    }
}
