package bbdd;

import dao.Artist;
import dao.Artwork;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.sql.SQLException;

public class CRUDArtworkBBDDTest{

    static Integer artist_id;
    static Integer museum_id;
    static Artwork  artwork;
    static Artwork upArtwork;

    @BeforeClass
    public static void findArtistIdTest() throws SQLException {
        artist_id=ConsultasBBDD.filterArtElementName(ArtElementType.ARTISTS,"Vincent van Gogh").get(0).getId();
    }

    @BeforeClass
    public static void findMuseumIdTest() throws SQLException {
        museum_id=ConsultasBBDD.filterArtElementName(ArtElementType.MUSEUMS,"National gallery").get(0).getId();
    }

    @Before
    public void initialize() throws SQLException {
        artwork=new Artwork(1, "img1","Sunflower",1888,artist_id,museum_id,"unflowers (original title, in French: Tournesols) is the title of two series of still life paintings by the Dutch painter Vincent van Gogh.","https://en.wikipedia.org/wiki/Sunflowers_(Van_Gogh_series)");
      upArtwork=new Artwork(1, "img1","Sunflowers",1888,artist_id,museum_id,"unflowers (original title, in French: Tournesols) is the title of two series of still life paintings by the Dutch painter Vincent van Gogh.","https://en.wikipedia.org/wiki/Sunflowers_(Van_Gogh_series)");
    }


    @Test
    public void createArtworkTest(){
        CRUDArtworksBBDD artworksBBDD=CRUDArtworksBBDD.getInstance();
        artworksBBDD.create(artwork);
        artworksBBDD.closeConnection();
    }

    @Test
    public void readArtworkTest() throws SQLException {
        CRUDArtworksBBDD artworksBBDD=CRUDArtworksBBDD.getInstance();
        Assert.assertEquals(artworksBBDD.read("name='"+artwork.getName()+"'").get(0),artwork);
        artworksBBDD.closeConnection();
    }

    @Test
    public void updateArtworkTest() throws SQLException {
        CRUDArtworksBBDD artworksBBDD=CRUDArtworksBBDD.getInstance();
        artworksBBDD.update(upArtwork,"name='"+artwork.getName()+"'");
        artworksBBDD.closeConnection();
    }

    @Test
    public void readAllArtworkTest() throws SQLException {
        CRUDArtworksBBDD artworksBBDD=CRUDArtworksBBDD.getInstance();
        artworksBBDD.read("1").stream().forEach(a -> System.out.println(a));
        artworksBBDD.closeConnection();
    }

    @Test
    public void deleteArtworkTest() throws SQLException {
        CRUDArtworksBBDD artworksBBDD=CRUDArtworksBBDD.getInstance();
        artworksBBDD.delete(upArtwork);
        artworksBBDD.closeConnection();
    }


}
