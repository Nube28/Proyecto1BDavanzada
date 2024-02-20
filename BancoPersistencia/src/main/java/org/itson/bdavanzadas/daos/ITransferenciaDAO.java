/*
 * ITransferenciaDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz proporciona métodos para acceder y manipular datos de
 * transferencias en una capa de acceso a datos.
 *
 */
public interface ITransferenciaDAO {

    /**
     * Agrega una nueva transferencia utilizando los datos proporcionados en un
     * objeto TransferenciaNuevaDTO.
     *
     * @param transferenciaNueva El objeto TransferenciaNuevaDTO que contiene
     * los datos de la nueva transferencia a agregar.
     * @return La transferencia agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la transferencia.
     */
    Transferencia agregar(TransferenciaNuevaDTO transferenciaNueva) throws PersistenciaException;

    /**
     * Consulta una transferencia por el número de cuenta.
     *
     * @param cuenta El número de cuenta asociado a la transferencia a
     * consultar.
     * @return La transferencia encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transferencia.
     */
    Transferencia consultarTransferencia(int cuenta) throws PersistenciaException;
}
