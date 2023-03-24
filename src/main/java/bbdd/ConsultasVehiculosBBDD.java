package bbdd;

import dao.Vehiculo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasVehiculosBBDD {
    public List<Vehiculo> getVehiculos() throws SQLException {
        List<Vehiculo> vehiculos=new ArrayList<>();

        CRUDMuseumsBBDD coches= CRUDMuseumsBBDD.getInstance();
        vehiculos.addAll(coches.read("*"));
        coches.closeConnection();

        CRUDArtistsBBDD motos= CRUDArtistsBBDD.getInstance();
        vehiculos.addAll(motos.read("*"));
        motos.closeConnection();

        return vehiculos;
    }

    public List<Vehiculo> filtraVehiculosPorMarca(String marca) throws SQLException{
        List<Vehiculo> vehiculos=new ArrayList<>();

        CRUDMuseumsBBDD coches= CRUDMuseumsBBDD.getInstance();
        vehiculos.addAll(coches.read("marca="+marca));
        coches.closeConnection();

        CRUDArtistsBBDD motos= CRUDArtistsBBDD.getInstance();
        vehiculos.addAll(motos.read("marca="+marca));
        motos.closeConnection();

        return vehiculos;
    }

    public List<Vehiculo> filtraVehiculosPorVelocidad(Double velocidad) throws SQLException{
        List<Vehiculo> vehiculos=new ArrayList<>();

        CRUDMuseumsBBDD coches= CRUDMuseumsBBDD.getInstance();
        vehiculos.addAll(coches.read("velocidad_max>="+velocidad.toString()));
        coches.closeConnection();

        CRUDArtistsBBDD motos= CRUDArtistsBBDD.getInstance();
        vehiculos.addAll(motos.read("velocidad_max>="+velocidad.toString()));
        motos.closeConnection();

        return vehiculos;
    }

    public List<Vehiculo> filtraVehiculosPorMarcaVelocidad(String marca, Double velocidad) throws SQLException{
        List<Vehiculo> vehiculos=new ArrayList<>();

        CRUDMuseumsBBDD coches= CRUDMuseumsBBDD.getInstance();
        vehiculos.addAll(coches.read("velocidad_max>="+velocidad.toString()+"and marca="+marca));
        coches.closeConnection();

        CRUDArtistsBBDD motos= CRUDArtistsBBDD.getInstance();
        vehiculos.addAll(motos.read("velocidad_max>="+velocidad.toString()+"and marca="+marca));
        motos.closeConnection();

        return vehiculos;
    }
}
