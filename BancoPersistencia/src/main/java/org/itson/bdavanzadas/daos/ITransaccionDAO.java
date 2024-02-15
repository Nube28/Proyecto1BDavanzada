/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dtos.TransaccionNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public interface ITransaccionDAO {

    Transaccion agregar(TransaccionNuevaDTO TransaccionNueva) throws PersistenciaException;

    Transaccion consultarFecha(int id) throws PersistenciaException;

    List<Transaccion> consultar() throws PersistenciaException;
    
    
}
