package bbdd;

import dao.Moto;
import dao.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public Moto getMotoElement(ResultSet rs) throws SQLException {
        Moto moto = new Moto(rs.getInt("bastidor"), rs.getString("matricula"), rs.getDouble("velocidad_max"), rs.getString("marca"), rs.getInt("cilindrada"), rs.getString("modelo"));
        return moto;
    }

    @Override
    public void create(Vehiculo o) {
        String query = "INSERT INTO Moto (bastidor, matricula, velocidad_max, marca, cilindrada, modelo) VALUES (?, ?, ?, ?,?,?)";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setInt(5, ((Moto) o).getCilindrada());
            stmt.setString(6, ((Moto) o).getModelo());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehiculo> read(String condition) throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT * FROM Moto WHERE"+condition;
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                vehiculos.add(getMotoElement(rs));
            }
        }
        return vehiculos;
    }

    @Override
    public void update(Vehiculo o, String condition) {
        String query = "UPDATE Moto SET bastidor=?, matricula=?, velocidad_max=?, marca=?, cilindrada=?, modelo=? WHERE ?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setInt(5, ((Moto)o).getCilindrada());
            stmt.setString(6, ((Moto)o).getModelo());
            stmt.setString(7,condition);

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Vehiculo o) {
        String query = "DELETE FROM Moto WHERE bastidor=?, matricula=?, velocidad_max=?, marca=?, cilindrada=?, modelo=?";
        try (PreparedStatement stmt = connManager.conn.prepareStatement(query)) {
            stmt.setLong(1, o.getBastidor());
            stmt.setString(2, o.getMatricula());
            stmt.setDouble(3, o.getVelocidadMaxima());
            stmt.setString(4, o.getMarca());
            stmt.setInt(5, ((Moto)o).getCilindrada());
            stmt.setString(6, ((Moto)o).getModelo());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
