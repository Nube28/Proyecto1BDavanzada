/*
 * IDomicilioDAO.java
 */
package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.dominio.Domicilio;
import org.itson.bdavanzadas.dtos.DomicilioNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Interfaz que define operaciones para agregar y consultar domicilios en el
 * sistema.
 */
public interface IDomicilioDAO {

    /**
     * Agrega un nuevo domicilio a la base de datos utilizando la información
     * proporcionada en un objeto DomicilioNuevoDTO.
     *
     * @param domicilioNuevo El objeto DomicilioNuevoDTO que contiene la
     * información del nuevo domicilio a agregar.
     * @return El objeto Domicilio agregado a la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * del domicilio.
     */
    Domicilio agregar(DomicilioNuevoDTO domicilioNuevo) throws PersistenciaException;

    /**
     * Consulta un domicilio en la base de datos utilizando su ID.
     *
     * @param id El ID del domicilio que se desea consultar.
     * @return El objeto Domicilio correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la consulta del
     * domicilio.
     */
    Domicilio consultar(int id) throws PersistenciaException;

    /**
     * Actualiza un domicilio existente con los nuevos datos proporcionados en
     * un objeto DomicilioNuevoDTO.
     *
     * @param domicilioNuevo DomicilioNuevoDTO que contiene los nuevos
     * datos del domicilio.
     * @param domicilio domicilio existente que se actualizará con los nuevos
     * datos.
     * @return domicilio actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * del domicilio.
     */
    Domicilio actualizar(DomicilioNuevoDTO domicilioNuevo, Domicilio domicilio) throws PersistenciaException;
}
