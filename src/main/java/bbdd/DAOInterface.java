package bbdd;

import dao.Vehiculo;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {
    public void create(Vehiculo o);
    public List<Vehiculo> read(String condition) throws SQLException;
    public void update(Vehiculo o1, String condition);
    public void delete(Vehiculo o);
}
