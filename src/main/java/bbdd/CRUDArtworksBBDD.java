package bbdd;

import dao.ArtElement;
import dao.Artist;
import dao.Artwork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class CRUDArtworksBBDD implements DAOInterface {
    private ConnectionManager connManager;
    private static CRUDArtworksBBDD instance;

    private CRUDArtworksBBDD(){
        connManager.getConnection();
    }

    public void closeConnection(){
        connManager.closeConnection();
    }
    public static CRUDArtworksBBDD getInstance() {
        if(instance==null){
            instance=new CRUDArtworksBBDD();
        }
        return instance;
    }

    public Artwork getArtworkElement(ResultSet rs) throws SQLException {
        Artwork artwork = new Artwork(rs.getInt("id"), rs.getString("imgPath"), rs.getString("name"), rs.getInt("year"),rs.getInt("autor_id"), rs.getInt("museum_id"),rs.getString("description"),rs.getString("wiki"));
        return artwork;
    }

    @Override
    public void create(ArtElement o) {
        Artwork a;

        if(o instanceof Artwork){
            a=(Artwork) o;
        }else{
            throw new RuntimeException();
        }
        String query = "INSERT INTO Artwork (id, imgPath, name, year, autor_id, museum_id, description, wiki) VALUES (?, ?, ?, ?, ?,?,?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getImgPath());
            stmt.setString(3, a.getName());
            stmt.setInt(4, a.getYear());
            stmt.setInt(5, a.getAutor_id());
            stmt.setInt(6, a.getMuseum_id());
            stmt.setString(7, a.getDescription());
            stmt.setString(8, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ArtElement> read(String condition) throws SQLException {
        List<ArtElement> artworks = new ArrayList<>();
        String query = "SELECT * FROM Artwork WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                artworks.add(getArtworkElement(rs));
            }
        }
        return artworks;
    }

    @Override
    public void update(ArtElement o, String condition) {
        Artwork a;

        if(o instanceof Artwork){
            a=(Artwork) o;
        }else{
            throw new RuntimeException();
        }

        String query = "UPDATE Artwork SET id=?, imgPath=?, name=?, year=?, autor_id=?, museum_id=?, description=?, wiki=? WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getImgPath());
            stmt.setString(3, a.getName());
            stmt.setInt(4, a.getYear());
            stmt.setInt(5, a.getAutor_id());
            stmt.setInt(6, a.getMuseum_id());
            stmt.setString(7, a.getDescription());
            stmt.setString(8, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ArtElement o) {
        Artwork a;

        if(o instanceof Artwork){
            a=(Artwork) o;
        }else{
            throw new RuntimeException();
        }

        String query = "DELETE FROM Artwork WHERE id=?, imgPath=?, name=?, year=?, autor_id=?, museum_id=?, description=?, wiki=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getImgPath());
            stmt.setString(3, a.getName());
            stmt.setInt(4, a.getYear());
            stmt.setInt(5, a.getAutor_id());
            stmt.setInt(6, a.getMuseum_id());
            stmt.setString(7, a.getDescription());
            stmt.setString(8, a.getWiki());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
