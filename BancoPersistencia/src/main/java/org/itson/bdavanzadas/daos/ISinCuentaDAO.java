/*
 * ISinCuenta.java
 */
package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.dominio.SinCuenta;
import org.itson.bdavanzadas.dtos.SinCuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz proporciona métodos para acceder y manipular datos de
 * transacciones de retiro sin cuenta en una capa de acceso a datos (DAO)
 *
 */
public interface ISinCuentaDAO {

    /**
     * Agrega una nueva transacción de retiro sin cuenta utilizando los datos
     * proporcionados en un objeto SinCuentaNuevaDTO.
     *
     * @param sinCuentanNueva El objeto SinCuentaNuevaDTO que contiene los datos
     * de la nueva transacción de retiro sin cuenta a agregar.
     * @return La transacción de retiro sin cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la transacción de retiro sin cuenta.
     */
    SinCuenta agregar(SinCuentaNuevaDTO sinCuentanNueva) throws PersistenciaException;

    /**
     * Consulta una transacción de retiro sin cuenta por su ID de transacción.
     *
     * @param id_transaccion El ID de transacción de la transacción de retiro
     * sin cuenta a consultar.
     * @return La transacción de retiro sin cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción de retiro sin cuenta.
     */
    SinCuenta consultar(int id_transaccion) throws PersistenciaException;

    /**
     * Consulta una transacción de retiro sin cuenta por su folio y contraseña.
     *
     * @param folio El folio de la transacción de retiro sin cuenta a consultar.
     * @param contrasenia La contraseña de la transacción de retiro sin cuenta a
     * consultar.
     * @return La transacción de retiro sin cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción de retiro sin cuenta.
     */
    SinCuenta consultarSinCuenta(int folio, String contrasenia) throws PersistenciaException;
}
