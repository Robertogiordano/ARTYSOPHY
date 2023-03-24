package bbdd;

import dao.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUserBBDD {
    private ConnectionManager connManager;
    private static CRUDUserBBDD instance;

    private CRUDUserBBDD(){
        connManager.getConnection();
    }

    public void closeConnection(){
        connManager.closeConnection();
    }
    public static CRUDUserBBDD getInstance() {
        if(instance==null){
            instance=new CRUDUserBBDD();
        }
        return instance;
    }

    public User getUserElement(ResultSet rs) throws SQLException {
        User user = new User(rs.getString("name"), rs.getString("surnames"), rs.getString("username"), rs.getString("email"),rs.getString("password"));
        return user;
    }


    public void create(User u) {
        String query = "INSERT INTO User (name,surnames,username,email,password) VALUES (?, ?, ?, ?,?,?, ?, ?, ?,?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurnames());
            stmt.setString(3, u.getUsername());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPassword());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public User read(String username, String password) throws SQLException {
        String query = "SELECT * FROM Museum WHERE username"+username+"and password="+password;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return getUserElement(rs);
            }else{
                throw new RuntimeException();
            }
        }
    }


    public void update(User u, String condition) {
        String query = "UPDATE Museum SET name=?, surnames=?, username=?, email=?, password=? WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurnames());
            stmt.setString(3, u.getUsername());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPassword());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(User u) {

        String query = "DELETE FROM Museum WHERE name=?, surnames=?, username=?, email=?, password=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurnames());
            stmt.setString(3, u.getUsername());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPassword());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
