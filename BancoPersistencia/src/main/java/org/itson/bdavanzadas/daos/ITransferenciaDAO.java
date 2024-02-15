/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public interface ITransferenciaDAO {

    Transferencia agregar(TransferenciaNuevaDTO TransferenciaNueva) throws PersistenciaException;

    Transferencia consultarTransferencia(int cuenta) throws PersistenciaException;
    
}
