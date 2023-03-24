package bbdd;

import dao.ArtElement;
import dao.Artist;
import dao.Museum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CRUDMuseumsBBDD implements DAOInterface {
    private ConnectionManager connManager;
    private static CRUDMuseumsBBDD instance;

    private CRUDMuseumsBBDD(){
        connManager.getConnection();
    }

    public void closeConnection(){
        connManager.closeConnection();
    }
    public static CRUDMuseumsBBDD getInstance() {
        if(instance==null){
            instance=new CRUDMuseumsBBDD();
        }
        return instance;
    }

    public Museum getMuseumElement(ResultSet rs) throws SQLException {
        Museum museum = new Museum(rs.getInt("id"), rs.getString("name"), rs.getString("street"), rs.getInt("openingHour"), rs.getInt("closingHour"),rs.getString("phone"),rs.getString("description"),rs.getDouble("price"),rs.getString("webpageUrl"),rs.getString("wiki"),rs.getString("googleMaps"));
        return museum;
    }

    @Override
    public void create(ArtElement o) {
        Museum m;

        if(o instanceof Museum){
            m=(Museum)o;
        }else{
            throw new RuntimeException();
        }

        String query = "INSERT INTO Museum (id, name, street, openingHour, closingHour, phone, description, price, webpageUrl,wiki,googleMaps) VALUES (?, ?, ?, ?,?,?, ?, ?, ?,?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, m.getId());
            stmt.setString(2, m.getName());
            stmt.setString(3, m.getStreet());
            stmt.setInt(4, m.getOpeningHour());
            stmt.setInt(5, m.getClosingHour());
            stmt.setString(6, m.getPhone());
            stmt.setString(7, m.getDescription());
            stmt.setDouble(8, m.getPrice());
            stmt.setString(9, m.getWebpageUrl());
            stmt.setString(10, m.getWiki());
            stmt.setString(11, m.getGoogleMaps());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ArtElement> read(String condition) throws SQLException {
        List<ArtElement> museums = new ArrayList<>();
        String query = "SELECT * FROM Museum WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                museums.add(getMuseumElement(rs));
            }
        }
        return museums;
    }

    @Override
    public void update(ArtElement o, String condition) {
        Museum m;

        if(o instanceof Museum){
            m=(Museum)o;
        }else{
            throw new RuntimeException();
        }

        String query = "UPDATE Museum SET id=?, name=?, street=?, openingHour=?, closingHour=?, phone=?, description=?, price=?, webpageUrl=?,wiki=?,googleMaps=? WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, m.getId());
            stmt.setString(2, m.getName());
            stmt.setString(3, m.getStreet());
            stmt.setInt(4, m.getOpeningHour());
            stmt.setInt(5, m.getClosingHour());
            stmt.setString(6, m.getPhone());
            stmt.setString(7, m.getDescription());
            stmt.setDouble(8, m.getPrice());
            stmt.setString(9, m.getWebpageUrl());
            stmt.setString(10, m.getWiki());
            stmt.setString(11, m.getGoogleMaps());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ArtElement o) {
        Museum m;

        if(o instanceof Museum){
            m=(Museum)o;
        }else{
            throw new RuntimeException();
        }

        String query = "DELETE FROM Museum WHERE id=?, name=?, street=?, openingHour=?, closingHour=?, phone=?, description=?, price=?, webpageUrl=?,wiki=?,googleMaps=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setInt(1, m.getId());
            stmt.setString(2, m.getName());
            stmt.setString(3, m.getStreet());
            stmt.setInt(4, m.getOpeningHour());
            stmt.setInt(5, m.getClosingHour());
            stmt.setString(6, m.getPhone());
            stmt.setString(7, m.getDescription());
            stmt.setDouble(8, m.getPrice());
            stmt.setString(9, m.getWebpageUrl());
            stmt.setString(10, m.getWiki());
            stmt.setString(11, m.getGoogleMaps());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
