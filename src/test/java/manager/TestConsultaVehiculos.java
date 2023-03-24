package manager;

import dao.Coche;
import dao.Moto;
import dao.Vehiculo;
import dao.tipoArranque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;

public class TestConsultaVehiculos {

    List<Vehiculo> vehiculos;
    @Before
    public void initialize(){
        vehiculos=ConsultaVehiculos.creaVehiculos();
    }
    @Test
    public void compareSize(){
        Assert.assertEquals(vehiculos.size(),20);
    }

    @Test
    public void testGetVehiculos(){
        Assert.assertEquals(ConsultaVehiculos.getVehiculos(),vehiculos);
    }

    @Test
    public void testFiltraMarca(){
        List<Vehiculo> vehiculosFiltrados=ConsultaVehiculos.filtraVehiculosPorMarca("Toyota");
        List<Vehiculo> vehiculosTest=new ArrayList<>();
        vehiculosTest.add(new Coche(1234567890, "QWERTY", 150.0,"Toyota", tipoArranque.manual));

        Assert.assertEquals(vehiculosFiltrados.size(),1);
        Assert.assertEquals(vehiculosFiltrados,vehiculosTest);
    }

    @Test
    public void testFiltraVelocidad(){
        List<Vehiculo> vehiculosFiltrados=ConsultaVehiculos.filtraVehiculosPorVelocidad(230.0);

        List<Vehiculo> vehiculosTest=new ArrayList<>();
        vehiculosTest.add(new Coche(1234567898, "ZXMNC", 230.0,"Lancia", tipoArranque.automatico));
        vehiculosTest.add(new Coche(1234567899, "DJFHT", 240.0,"Ford", tipoArranque.automatico));
        vehiculosTest.add(new Moto(987654320,"FVNLW",230.0,"MarcaMoto10",2190,"Modelo moto 10"));


        Assert.assertEquals(vehiculosFiltrados.size(),3);
        Assert.assertEquals(vehiculosFiltrados,vehiculosTest);
    }

    @Test
    public void testFiltraVelocidadyMarca(){
        List<Vehiculo> vehiculosFiltrados=ConsultaVehiculos.filtraVehiculosPorMarcaYVelocidad("MarcaMoto1",170.5);
        List<Vehiculo> vehiculosTest=new ArrayList<>();
        vehiculosTest.add(new Moto(987654321,"TREWQ",170.5,"MarcaMoto1",2100,"Modelo moto 1"));

        Assert.assertEquals(vehiculosFiltrados.size(),1);
        Assert.assertEquals(vehiculosFiltrados,vehiculosTest);
    }
}
