/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;

import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * 
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(TransferenciaDAO.class.getName());

    public TransferenciaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }
    
    


}
