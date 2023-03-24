package bbdd;


import dao.ArtElement;
import dao.Artist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CRUDArtistsBBDD implements DAOInterface {
    private ConnectionManager connManager;
    private static CRUDArtistsBBDD instance;

    private CRUDArtistsBBDD(){
        connManager.getConnection();
    }

    public void closeConnection(){
        connManager.closeConnection();
    }
    public static CRUDArtistsBBDD getInstance() {
        if(instance==null){
            instance=new CRUDArtistsBBDD();
        }
        return instance;
    }

    public Artist getMotoElement(ResultSet rs) throws SQLException {
        Artist artist = new Artist(rs.getInt("id"), rs.getString("name"), rs.getInt("birthYear"), rs.getInt("deathYear"), rs.getString("description"),rs.getString("wiki"));
        return artist;
    }

    @Override
    public void create(ArtElement o) {
        Artist a;

        if(o instanceof Artist){
            a=(Artist) o;
        }else{
            throw new RuntimeException();
        }

        String query = "INSERT INTO Artist (id, name, birth_year, death_year, description, wiki) VALUES (?, ?, ?, ?,?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getName());
            stmt.setInt(3, a.getBirthYear());
            stmt.setInt(4, a.getDeathYear());
            stmt.setString(5, a.getDescription());
            stmt.setString(6, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ArtElement> read(String condition) throws SQLException {
        List<ArtElement> artists = new ArrayList<>();
        String query = "SELECT * FROM Artist WHERE"+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                artists.add(getMotoElement(rs));
            }
        }
        return artists;
    }

    @Override
    public void update(ArtElement o, String condition) {
        Artist a;

        if(o instanceof Artist){
            a=(Artist) o;
        }else{
            throw new RuntimeException();
        }

        String query = "UPDATE Moto SET id=?, name=?, birth_year=?, death_year=?, description=?, wiki=? WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getName());
            stmt.setInt(3, a.getBirthYear());
            stmt.setInt(4, a.getDeathYear());
            stmt.setString(5, a.getDescription());
            stmt.setString(6, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ArtElement o) {
        Artist a;

        if(o instanceof Artist){
            a=(Artist) o;
        }else{
            throw new RuntimeException();
        }

        String query = "DELETE FROM Moto WHERE id=?, name=?, birth_year=?, death_year=?, description=?, wiki=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getName());
            stmt.setInt(3, a.getBirthYear());
            stmt.setInt(4, a.getDeathYear());
            stmt.setString(5, a.getDescription());
            stmt.setString(6, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
