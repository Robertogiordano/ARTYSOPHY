/*import dao.Autor;
import dao.Museum;
import dao.Artwork;
import dao.User;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class CommandPatternExample{

    static List<User> users=new ArrayList<>();
        static List<Autor> autors=new ArrayList<>();
        static List<Museum> museums=new ArrayList<>();
        static List<Artwork> artworks=new ArrayList<>();
    public CommandPatternExample(){
        User user=new User("admin","adminSur","admin","admin@admin","admin");
        users.add(user);

        Autor picasso=new Autor("Pablo Picasso",18811025,1973048,"Pablo Ruiz y Picasso, simply known as Pablo Picasso, was a Spanish painter, sculptor and lithographer, among the most influential of the 20th century","https://en.wikipedia.org/wiki/Pablo_Picasso");
        Autor dali=new Autor("Salvador Dalí",19040511,19890123,"Salvador Dalí, Marquis of Pùbol, born Salvador Domingo Felipe Jacinto Dalí i Domènech, was a Spanish painter, sculptor, writer, photographer, filmmaker, designer, screenwriter and mystic","https://en.wikipedia.org/wiki/Salvador_Dal%C3%AD");

        autors.add(picasso);
        autors.add(dali);

        museums.add(new Museum("Museum of Modern Art","11 West 53rd Street", 1030,1730,0,0,"","1234567","The Museum of Modern Art (MoMA) is an art museum located in Midtown Manhattan, New York City, on 53rd Street between Fifth and Sixth Avenues.",50.50,"www.moma.org","https://en.wikipedia.org/wiki/Museum_of_Modern_Art","https://www.google.com/maps/place/Museum+of+Modern+Art/@40.7614367,-73.9798156,17z/data=!3m2!4b1!5s0x89c258fbd5ec7547:0x7edf0a3ade84ad50!4m6!3m5!1s0x89c258f97bdb102b:0xea9f8fc0b3ffff55!8m2!3d40.7614327!4d-73.9776216!16zL20vMGhoams"));

        artworks.add(new Artwork("img1","La persistencia de la memoria",1931,autors.get(1),museums.get(0),"The Persistence of Memory (Catalan: La persistència de la memòria) is a 1931 painting by artist Salvador Dalí and one of the most recognizable works of Surrealism. First shown at the Julien Levy Gallery in 1932, since 1934 the painting has been in the collection of the Museum of Modern Art (MoMA) in New York City, which received it from an anonymous donor.","https://en.wikipedia.org/wiki/The_Persistence_of_Memory"));

    }
    public static void main(String[] args) {


        CommandInvoker invoker = new CommandInvoker(autors,museums, artworks);
        invoker.executeCommand("museumGuide");
    }
}*/

