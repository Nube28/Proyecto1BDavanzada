/*
 * IClienteDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz proporciona métodos para acceder y manipular datos de clientes
 * en una capa de acceso a datos (DAO).
 */
public interface IClienteDAO {

    /**
     * Agrega un nuevo cliente utilizando los datos proporcionados en un objeto
     * ClienteNuevoDTO.
     *
     * @param clienteNuevo El objeto ClienteNuevoDTO que contiene los datos del
     * nuevo cliente a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos del cliente.
     */
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;

    /**
     * Consulta todos los clientes almacenados.
     *
     * @return Una lista de objetos ClienteDAO que representan todos los
     * clientes almacenados.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * los clientes.
     */
    List<ClienteDAO> consultar() throws PersistenciaException;

    /**
     * Consulta un cliente por su ID de usuario.
     *
     * @param usuario El ID del usuario del cliente a consultar.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la consulta del
     * cliente.
     */
    Cliente consultarCliente(int usuario) throws PersistenciaException;

    /**
     * Consulta un cliente por su usuario y contraseña.
     *
     * @param usuario El nombre de usuario del cliente.
     * @param contrasenia La contraseña del cliente.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la consulta del
     * cliente.
     */
    Cliente consultarCliente(String usuario, String contrasenia) throws PersistenciaException;

    /**
     * Actualiza los datos de un cliente utilizando los datos proporcionados en
     * un objeto ClienteNuevoDTO.
     *
     * @param clienteNuevo El objeto ClienteNuevoDTO que contiene los nuevos
     * datos del cliente.
     * @param cliente El cliente existente que se actualizará.
     * @return El cliente actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * de los datos del cliente.
     */
    Cliente actualizar(ClienteNuevoDTO clienteNuevo, Cliente cliente) throws PersistenciaException;

    /**
     * Elimina un cliente por su ID.
     *
     * @param id El ID del cliente a eliminar.
     * @return El cliente eliminado.
     * @throws PersistenciaException Si ocurre un error durante la eliminación
     * del cliente.
     */
    public Cliente eliminar(int id) throws PersistenciaException;

}
