package bbdd;

import dao.Coche;
import dao.Vehiculo;
import dao.tipoArranque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Coche getCocheElement(ResultSet rs) throws SQLException {
        Coche coche = new Coche(rs.getInt("bastidor"), rs.getString("matricula"), rs.getDouble("velocidad_max"), rs.getString("marca"), tipoArranque.valueOf(rs.getString("tipoArranque")));
        return coche;
    }

    @Override
    public void create(Vehiculo o) {
        String query = "INSERT INTO Coche (bastidor, matricula, velocidad_max, marca, tipoArranque) VALUES (?, ?, ?, ?,?)";
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
    public List<Vehiculo> read(String condition) throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
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
