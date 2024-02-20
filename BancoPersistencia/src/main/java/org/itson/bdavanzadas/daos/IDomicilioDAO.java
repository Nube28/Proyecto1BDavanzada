/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.dominio.Domicilio;
import org.itson.bdavanzadas.dtos.DomicilioNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public interface IDomicilioDAO {

    Domicilio agregar(DomicilioNuevoDTO domicilioNuevo) throws PersistenciaException;

    Domicilio consultar(int id) throws PersistenciaException;
}
