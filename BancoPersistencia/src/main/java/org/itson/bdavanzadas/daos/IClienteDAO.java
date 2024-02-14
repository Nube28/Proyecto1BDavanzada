/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dtos.ClienteActualizadoDTO;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public interface IClienteDAO {
    ClienteDAO agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    List<ClienteDAO> consultar() throws PersistenciaException;
    ClienteDAO consultarSocio(Long id)throws PersistenciaException;
    ClienteDAO actualizar(ClienteActualizadoDTO socioActualizado) throws PersistenciaException;
    public ClienteDAO eliminar(Long id) throws PersistenciaException;
}
