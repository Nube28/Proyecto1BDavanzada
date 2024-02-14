/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bancoprestacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ClienteDAO;
import org.itson.bdavanzadas.daos.CuentaDAO;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Laboratorios
 */
public class PruebaGomez {

    static final Logger logger = Logger.getLogger(PruebaGomez.class.getName());

    public static void main(String[] args) {
        //PantallaInicial main = new PantallaInicial();
        //main.setVisible(true);

        String candenaConexion = "jdbc:mysql://localhost/banco";
        String usuario = "root";
        String password = "123qweasdzxc";
        IConexion conexion = new Conexion(candenaConexion, usuario, password);
        IClienteDAO clienteDAO = new ClienteDAO(conexion);
        ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO();

        // Establecer cada atributo para la instancia clienteNuevo
        clienteNuevo.setUsuario("123");
        clienteNuevo.setContrasenia("123");
        clienteNuevo.setNombres("Juan");
        clienteNuevo.setApellido_paterno("Perez");
        clienteNuevo.setApellido_materno("Gomez");
        clienteNuevo.setNacimiento("1990-05-15");
        clienteNuevo.setEdad(32);

        ICuentaDAO cuentaDAO = new CuentaDAO(conexion);
        CuentaNuevaDTO cuentaNueva = new CuentaNuevaDTO();
        cuentaNueva.setNumero(123456789);
        cuentaNueva.setSaldo(0);
        try {
            Cliente consultado = clienteDAO.consultarCliente(clienteNuevo.getUsuario(), clienteNuevo.getContrasenia());
            cuentaNueva.setId_cliente(consultado.getId());
            Cuenta cuentaCreada = cuentaDAO.agregar(cuentaNueva);
            System.out.println(cuentaCreada);
            //Cliente clienteAgregado = clienteDAO.agregar(clienteNuevo);
            //logger.log(Level.INFO, clienteAgregado.toString());
        } catch (PersistenciaException pe) {
            Logger.getLogger(PruebaGomez.class.getName()).log(Level.SEVERE, null, pe);

        }

    }
}
