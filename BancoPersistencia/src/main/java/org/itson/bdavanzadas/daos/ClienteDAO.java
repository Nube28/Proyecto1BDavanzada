/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteActualizadoDTO;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public class ClienteDAO implements IClienteDAO{
    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String setenciaSQL = """
                             INSERT INTO cliente(usuario,nombres,apellido_paterno,apellido_materno,correo,fecha)
                                         VALUES(?,?,?);
                             """;
        
        
    }

    @Override
    public List<ClienteDAO> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarSocio(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente actualizar(ClienteActualizadoDTO socioActualizado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente eliminar(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
