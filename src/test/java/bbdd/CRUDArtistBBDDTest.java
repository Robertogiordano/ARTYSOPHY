/*package bbdd;

import dao.Artist;
import dao.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CRUDArtistBBDDTest {

    Artist artist=new Artist(null, "Vincent van Gogh",1853,1890,"Vincent Willem van Gogh (Dutch: [ˈvɪnsɛnt ˈʋɪləm vɑŋ ˈɣɔx] (listen);[note 1] 30 March 1853 – 29 July 1890) was a Dutch Post-Impressionist painter who posthumously became one of the most famous and influential figures in Western art history.","https://en.wikipedia.org/wiki/Vincent_van_Gogh");
    Artist upArtist=new Artist(4, "Vincent Willem van Gogh",1853,1890,"Vincent Willem van Gogh (Dutch: [ˈvɪnsɛnt ˈʋɪləm vɑŋ ˈɣɔx] (listen);[note 1] 30 March 1853 – 29 July 1890) was a Dutch Post-Impressionist painter who posthumously became one of the most famous and influential figures in Western art history.","https://en.wikipedia.org/wiki/Vincent_van_Gogh");


    @Test
            public void createArtistTest(){
        CRUDArtistsBBDD artistsBBDD=CRUDArtistsBBDD.getInstance();
        artistsBBDD.create(artist);
        artistsBBDD.closeConnection();
    }

    @Test
    public void readArtistTest() throws SQLException {
        CRUDArtistsBBDD artistsBBDD=CRUDArtistsBBDD.getInstance();
        Assert.assertEquals(artistsBBDD.read("name='"+artist.getName()+"'").get(0),artist);
        artistsBBDD.closeConnection();
    }

    @Test
    public void updateArtistTest() throws SQLException {

        CRUDArtistsBBDD artistsBBDD=CRUDArtistsBBDD.getInstance();
        artistsBBDD.update(upArtist,"name='"+artist.getName()+"'");
        artistsBBDD.closeConnection();
    }

    @Test
    public void readAllArtistsTest() throws SQLException {
        CRUDArtistsBBDD artistsBBDD=CRUDArtistsBBDD.getInstance();
        artistsBBDD.read("1").stream().forEach(a -> System.out.println(a));
        artistsBBDD.closeConnection();
    }

    @Test
    public void deleteArtistTest() throws SQLException {
        CRUDArtistsBBDD artistsBBDD=CRUDArtistsBBDD.getInstance();
        artistsBBDD.delete(upArtist);
        artistsBBDD.closeConnection();
    }

}
*/
