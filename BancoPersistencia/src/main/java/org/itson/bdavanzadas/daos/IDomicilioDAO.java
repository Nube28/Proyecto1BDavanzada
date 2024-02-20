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
     * Agrega un nuevo domicilio al sistema.
     *
     * @param domicilioNuevo Objeto DomicilioNuevoDTO que contiene los datos del
     * nuevo domicilio.
     * @return El domicilio agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    Domicilio agregar(DomicilioNuevoDTO domicilioNuevo) throws PersistenciaException;

    /**
     * Consulta un domicilio por su ID en el sistema.
     *
     * @param id El ID del domicilio a consultar.
     * @return El domicilio encontrado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * consulta.
     */
    Domicilio consultar(int id) throws PersistenciaException;
}
