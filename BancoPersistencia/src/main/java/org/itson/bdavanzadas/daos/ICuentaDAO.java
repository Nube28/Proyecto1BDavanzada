/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Berry
 */
public interface ICuentaDAO {

    Cuenta agregar(CuentaNuevaDTO socioNuevo) throws PersistenciaException;

    List<Cuenta> consultar(int Id_cuenta) throws PersistenciaException;

    Cuenta consultarCuenta(int Id_cuenta) throws PersistenciaException;

    void CancelarCuenta(int ID) throws PersistenciaException;

    Cuenta actualizar(String ID, CuentaNuevaDTO cuentaNueva) throws PersistenciaException;

    Cuenta consultarCuentaId(int id) throws PersistenciaException;

    void actualizarMontroTransaccion(Cuenta emisor, int numeroReceptor, float cantidad) throws PersistenciaException;

    void retirarSinCuenta(Cuenta cuenta, float cantidad) throws PersistenciaException;

}
