package bbdd;

import dao.Artist;
import dao.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestConnectionDB {
   @Test
    public void connectionTest(){
       CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
   }

   @Test
    public void getAllUsersTest() throws SQLException {
       List<User> users=ConsultasBBDD.getUsers();
       System.out.println(users);
   }

   @Test
   public void readUserTest() throws SQLException {
       User user=new User("Roberto","Giordano", "rgiordano","rgiordano@al.uloyola.es","qwertyuiop");

       CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
       System.out.println(userBBDD.read(user.getUsername(), user.getPassword()));
       userBBDD.closeConnection();
   }

   @Test
    public void checkLoginTest(){
       User user=new User("Roberto","Giordano", "rgiordano","rgiordano@al.uloyola.es","qwertyuiop");
       System.out.println(ConsultasBBDD.checkLogin(user));
   }

   @Test
    public void insertArtistTest(){
       Artist picasso=new Artist(0,"Pablo Picasso",18811025,1973048,"Pablo Ruiz y Picasso, simply known as Pablo Picasso, was a Spanish painter, sculptor and lithographer, among the most influential of the 20th century","https://en.wikipedia.org/wiki/Pablo_Picasso");
       Artist dali=new Artist(0,"Salvador Dalí",19040511,19890123,"Salvador Dalí, Marquis of Pùbol, born Salvador Domingo Felipe Jacinto Dalí i Domènech, was a Spanish painter, sculptor, writer, photographer, filmmaker, designer, screenwriter and mystic","https://en.wikipedia.org/wiki/Salvador_Dal%C3%AD");

       CRUDArtistsBBDD artistBBDD=CRUDArtistsBBDD.getInstance();
       artistBBDD.create(picasso);
       artistBBDD.create(dali);
       artistBBDD.closeConnection();
   }

   @Test
    public void updateArtistTest(){
        Artist picasso=new Artist(0,"Pablo Picasso",18811025,1973048,"Pablo Ruiz y Picasso, simply known as Pablo Picasso, was a Spanish painter, sculptor and lithographer, among the most influential of the 20th century","https://en.wikipedia.org/wiki/Pablo_Picasso");
        Artist dali=new Artist(1,"Salvador Dalí",19040511,19890123,"Salvador Dalí, Marquis of Pùbol, born Salvador Domingo Felipe Jacinto Dalí i Domènech, was a Spanish painter, sculptor, writer, photographer, filmmaker, designer, screenwriter and mystic","https://en.wikipedia.org/wiki/Salvador_Dal%C3%AD");

        CRUDArtistsBBDD artistBBDD=CRUDArtistsBBDD.getInstance();
        artistBBDD.update(picasso,"name='"+picasso.getName()+"'");
        artistBBDD.update(dali,"name='"+dali.getName()+"'");
        artistBBDD.closeConnection();
    }
}
