package bbdd;

import dao.Artwork;
import dao.Coche;
import dao.Vehiculo;
import dao.tipoArranque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDArtworksBBDD implements DAOInterface {
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

    public Artwork getCocheElement(ResultSet rs) throws SQLException {
        Artwork artwork = new Artwork(rs.getInt("bastidor"), rs.getString("matricula"), rs.getDouble("velocidad_max"), rs.getString("marca"), tipoArranque.valueOf(rs.getString("tipoArranque")));
        return artwork;
    }

    @Override
    public void create(Artwork o) {
        String query = "INSERT INTO Artwork (bastidor, matricula, velocidad_max, marca, tipoArranque) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setString(5, ((Coche)o).getArranque().toString());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Artwork> read(String condition) throws SQLException {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM Coche WHERE "+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                vehiculos.add(getCocheElement(rs));
            }
        }
        return vehiculos;
    }

    @Override
    public void update(Vehiculo o, String condition) {
        String query = "UPDATE Coche SET bastidor=?, matricula=?, velocidad_max=?, marca=?, tipoArranque=? WHERE ?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setString(5, ((Coche)o).getArranque().toString());
            stmt.setString(6,condition);

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Vehiculo o) {
        String query = "DELETE FROM Moto WHERE bastidor=?, matricula=?, velocidad_max=?, marca=?, tipoArranque=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setString(5, ((Coche)o).getArranque().toString());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
