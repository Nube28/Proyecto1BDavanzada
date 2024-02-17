/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.dominio.SinCuenta;
import org.itson.bdavanzadas.dtos.SinCuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public class SinCuentaDAO implements ISinCuentaDAO{

    @Override
    public SinCuenta agregar(SinCuentaNuevaDTO sinCuentanNueva) throws PersistenciaException {
        
    }

    @Override
    public SinCuenta consultarSinCuenta(int folio) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
