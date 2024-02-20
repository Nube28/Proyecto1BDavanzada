/*
 * ICuentaDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz proporciona métodos para acceder y manipular datos de cuentas
 * en una capa de acceso a datos .
 *
 */
public interface ICuentaDAO {

    /**
     * Agrega una nueva cuenta utilizando los datos proporcionados en un objeto
     * CuentaNuevaDTO.
     *
     * @param cuentaNueva El objeto CuentaNuevaDTO que contiene los datos de la
     * nueva cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la cuenta.
     */
    Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException;

    /**
     * Consulta las cuentas asociadas a un cliente específico mediante su ID de
     * cuenta.
     *
     * @param Id_cuenta El ID de cuenta del cliente cuyas cuentas se desean
     * consultar.
     * @return Una lista de objetos Cuenta que representan las cuentas asociadas
     * al cliente.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las cuentas.
     */
    List<Cuenta> consultar(int Id_cuenta) throws PersistenciaException;

    /**
     * Consulta una cuenta por su ID.
     *
     * @param Id_cuenta El ID de la cuenta a consultar.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la cuenta.
     */
    Cuenta consultarCuenta(int Id_cuenta) throws PersistenciaException;

    /**
     * Cancela una cuenta por su ID.
     *
     * @param ID El ID de la cuenta a cancelar.
     * @throws PersistenciaException Si ocurre un error durante la cancelación
     * de la cuenta.
     */
    void CancelarCuenta(int ID) throws PersistenciaException;

    /**
     * Actualiza los datos de una cuenta utilizando los datos proporcionados en
     * un objeto CuentaNuevaDTO.
     *
     * @param ID El ID de la cuenta a actualizar.
     * @param cuentaNueva El objeto CuentaNuevaDTO que contiene los nuevos datos
     * de la cuenta.
     * @return La cuenta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * de los datos de la cuenta.
     */
    Cuenta actualizar(String ID, CuentaNuevaDTO cuentaNueva) throws PersistenciaException;

    /**
     * Consulta una cuenta por su ID.
     *
     * @param id El ID de la cuenta a consultar.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la cuenta.
     */
    Cuenta consultarCuentaId(int id) throws PersistenciaException;

    /**
     * Actualiza el monto de una transacción para una cuenta emisora y receptora
     * específica.
     *
     * @param emisor La cuenta emisora de la transacción.
     * @param numeroReceptor El número de cuenta receptora de la transacción.
     * @param cantidad La cantidad de dinero involucrada en la transacción.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * del monto de la transacción.
     */
    void actualizarMontroTransaccion(Cuenta emisor, int numeroReceptor, float cantidad) throws PersistenciaException;

    /**
     * Retira una cantidad de dinero de una cuenta sin asociar a un cliente.
     *
     * @param cuenta La cuenta de la que se retirará el dinero.
     * @param cantidad La cantidad de dinero a retirar.
     * @throws PersistenciaException Si ocurre un error durante el retiro de
     * dinero de la cuenta.
     */
    void retirarSinCuenta(Cuenta cuenta, float cantidad) throws PersistenciaException;

}
