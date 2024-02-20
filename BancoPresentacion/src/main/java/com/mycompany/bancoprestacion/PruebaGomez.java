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
        String candenaConexion = "jdbc:mysql://localhost/banco";
        String usuario = "root";
        String password = "123qweasdzxc";
        IConexion conexion = new Conexion(candenaConexion, usuario, password);
        IClienteDAO clienteDAO = new ClienteDAO(conexion);

        PantallaInicial pi = new PantallaInicial(clienteDAO, conexion);
        pi.setVisible(true);
    }
}
