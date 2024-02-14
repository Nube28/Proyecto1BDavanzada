/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteActualizadoDTO;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public interface IClienteDAO {
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    List<ClienteDAO> consultar() throws PersistenciaException;
    Cliente consultarCliente(int id)throws PersistenciaException;
    Cliente consultarCliente(String usuario,String contrasenia) throws PersistenciaException;
    Cliente actualizar(ClienteActualizadoDTO socioActualizado) throws PersistenciaException;
    public Cliente eliminar(int id) throws PersistenciaException;
}
