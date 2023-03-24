package bbdd;



import dao.ArtElement;
import dao.Artist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConsultasVehiculosBBDD {
    public List<ArtElement> getArtElements(String category) throws SQLException {
        List<ArtElement> artElements=new ArrayList<>();

        switch (category){
            case "artists":
                CRUDArtistsBBDD artistsBBDD= CRUDArtistsBBDD.getInstance();
                artElements.addAll(artistsBBDD.read("*"));
                artistsBBDD.closeConnection();
                break;
            case "museums":
                CRUDMuseumsBBDD museumsBBDD= CRUDMuseumsBBDD.getInstance();
                artElements.addAll(museumsBBDD.read("*"));
                museumsBBDD.closeConnection();
                break;
            case "artworks":
                CRUDArtworksBBDD artworksBBDD= CRUDArtworksBBDD.getInstance();
                artElements.addAll(artworksBBDD.read("*"));
                artworksBBDD.closeConnection();
                break;
        }

        return artElements;
    }

    public List<ArtElement> filterArtElementName(String category, String condition) throws SQLException{
        List<ArtElement> artElements=new ArrayList<>();

        switch (category){
            case "artists":
                CRUDArtistsBBDD artistsBBDD= CRUDArtistsBBDD.getInstance();
                artElements.addAll(artistsBBDD.read("name="+condition));
                artistsBBDD.closeConnection();
                break;
            case "museums":
                CRUDMuseumsBBDD museumsBBDD= CRUDMuseumsBBDD.getInstance();
                artElements.addAll(museumsBBDD.read("name="+condition));
                museumsBBDD.closeConnection();
                break;
            case "artworks":
                CRUDArtworksBBDD artworksBBDD= CRUDArtworksBBDD.getInstance();
                artElements.addAll(artworksBBDD.read("name="+condition));
                artworksBBDD.closeConnection();
                break;
        }

        return artElements;
    }

    public List<ArtElement> filterArtElementId(String category, String condition) throws SQLException{
        List<ArtElement> artElements=new ArrayList<>();

        switch (category){
            case "artists":
                CRUDArtistsBBDD artistsBBDD= CRUDArtistsBBDD.getInstance();
                artElements.addAll(artistsBBDD.read("id="+condition));
                artistsBBDD.closeConnection();
                break;
            case "museums":
                CRUDMuseumsBBDD museumsBBDD= CRUDMuseumsBBDD.getInstance();
                artElements.addAll(museumsBBDD.read("id="+condition));
                museumsBBDD.closeConnection();
                break;
            case "artworks":
                CRUDArtworksBBDD artworksBBDD= CRUDArtworksBBDD.getInstance();
                artElements.addAll(artworksBBDD.read("id="+condition));
                artworksBBDD.closeConnection();
                break;
        }

        return artElements;
    }
}
