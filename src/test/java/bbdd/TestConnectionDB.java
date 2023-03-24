package bbdd;

import dao.Vehiculo;
import manager.ConsultaVehiculos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestConnectionDB {
    private VehiculoDAO2 vdao;
   /* @Before
    public void setConnectionTest() {
        System.out.println("Set connection...");
        vdao=new VehiculoDAO2(ConnectionManager.getConnection());
    }

    @After
    public void closeConnectionTest(){
        System.out.println("Closing connection...");
        ConnectionManager.closeConnection(vdao.getConn());
    }

    @Test
    public void TestGetConnection() throws SQLException{
        List<Vehiculo> vehiculos=vdao.getAll();
        vehiculos.stream().forEach(v->System.out.println(v.toString()));
    }
    @Test
    public void TestInsertConnection() throws SQLException {
        List<Vehiculo> vehiculos=ConsultaVehiculos.creaVehiculos();

        vehiculos.stream().forEach(v-> {
            try {
                vdao.insertVehiculo(v);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
*/



}
