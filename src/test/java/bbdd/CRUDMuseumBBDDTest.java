/*package bbdd;

import dao.Artist;
import dao.Museum;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class CRUDMuseumBBDDTest {

    Museum museum=new Museum(null,"National gallery","Trafalgar Square","10am","6pm","","The National Gallery is an art museum in Trafalgar Square in the City of Westminster, in Central London, England.",0.0,"https://www.nationalgallery.org.uk","https://en.wikipedia.org/wiki/National_Gallery","https://www.google.com/maps/place/51°30'32.1%22N+0°07'41.9%22W/@51.508929,-0.128299,15z/data=!4m4!3m3!8m2!3d51.508929!4d-0.128299?hl=en");
    Museum upMuseum=new Museum(1,"National gallery","Trafalgar Square, London","10am","6pm","","The National Gallery is an art museum in Trafalgar Square in the City of Westminster, in Central London, England.",0.0,"https://www.nationalgallery.org.uk","https://en.wikipedia.org/wiki/National_Gallery","https://www.google.com/maps/place/51°30'32.1%22N+0°07'41.9%22W/@51.508929,-0.128299,15z/data=!4m4!3m3!8m2!3d51.508929!4d-0.128299?hl=en");


    @Test
    public void createMuseumTest(){
        CRUDMuseumsBBDD museumsBBDD=CRUDMuseumsBBDD.getInstance();
        museumsBBDD.create(museum);
        museumsBBDD.closeConnection();
    }

    @Test
    public void readArtistTest() throws SQLException {
        CRUDMuseumsBBDD museumsBBDD=CRUDMuseumsBBDD.getInstance();
        Assert.assertEquals(museumsBBDD.read("name='"+museum.getName()+"'").get(0),museum);
        museumsBBDD.closeConnection();
    }

    @Test
    public void updateArtistTest() throws SQLException {

        CRUDMuseumsBBDD museumsBBDD=CRUDMuseumsBBDD.getInstance();
        museumsBBDD.update(upMuseum,"name='"+museum.getName()+"'");
        museumsBBDD.closeConnection();
    }

    @Test
    public void readAllArtistsTest() throws SQLException {
        CRUDMuseumsBBDD museumsBBDD=CRUDMuseumsBBDD.getInstance();
        museumsBBDD.read("1").stream().forEach(a -> System.out.println(a));
        museumsBBDD.closeConnection();
    }

    @Test
    public void deleteArtistTest() throws SQLException {
        CRUDMuseumsBBDD museumsBBDD=CRUDMuseumsBBDD.getInstance();
        museumsBBDD.delete(upMuseum);
        museumsBBDD.closeConnection();
    }


}*/
