/*
 * ITransaccionDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dtos.TransaccionNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz proporciona métodos para acceder y manipular datos de
 * transacciones en una capa de acceso a datos.
 *
 *
 */
public interface ITransaccionDAO {

    /**
     * Agrega una nueva transacción utilizando los datos proporcionados en un
     * objeto TransaccionNuevaDTO.
     *
     * @param transaccionNueva El objeto TransaccionNuevaDTO que contiene los
     * datos de la nueva transacción a agregar.
     * @return La transacción agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la transacción.
     */
    Transaccion agregar(TransaccionNuevaDTO transaccionNueva) throws PersistenciaException;

    /**
     * Consulta una transacción por su ID.
     *
     * @param id El ID de la transacción a consultar.
     * @return La transacción encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción.
     */
    Transaccion consultarTransaccion(int id) throws PersistenciaException;

    /**
     * Consulta todas las transacciones asociadas a un cliente específico por su
     * ID de cliente.
     *
     * @param id El ID del cliente para el que se consultan las transacciones.
     * @return Una lista de transacciones asociadas al cliente especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las transacciones.
     */
    List<Transaccion> consultar(int id) throws PersistenciaException;

    /**
     * Consulta las transacciones asociadas a un cliente específico dentro de un
     * período de tiempo.
     *
     * @param id El ID del cliente para el que se consultan las transacciones.
     * @param desde La fecha de inicio del período de tiempo.
     * @param hasta La fecha de fin del período de tiempo.
     * @return Una lista de transacciones asociadas al cliente especificado y
     * dentro del período de tiempo especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las transacciones.
     */
    List<Transaccion> consultarPeriodo(int id, String desde, String hasta) throws PersistenciaException;

}
