package test;

import java.util.Date;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ClienteDAO;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author af_da
 */
public class TestCrearCliente {

    String candenaConexion = "jdbc:mysql://localhost/club_nautico_10am";
    String usuario = "root";
    String password = "123qweasdzxc";
    IConexion conexion = new Conexion(candenaConexion, usuario, password);
    IClienteDAO clienteDAO = new ClienteDAO(conexion);
    ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO();
    Cliente cliente = new Cliente("123", "123", "Juan", "Perez", "Gomez", "1990-05-15", 32);
    
//        try {
            //
            //            Socio socioAgregado = sociosDAO.agregar(socioNuevo);
            //            logger.log(Level.INFO, socioAgregado.toString());
            //        } catch (PersistenciaException pe) {
            //           Logger.getLogger(ClubNautico.class.getName()).log(Level.SEVERE,null,pe);
            //
            //        }

}
