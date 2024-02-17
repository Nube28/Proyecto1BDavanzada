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
import static org.itson.bdavanzadas.daos.CuentaDAO.logger;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;

import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 *
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(TransferenciaDAO.class.getName());

    public TransferenciaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    @Override
    public Transferencia agregar(TransferenciaNuevaDTO TransferenciaNueva) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO Transferencia(id_transaccion, id_cuenta_destino)
                VALUES(?, ?);
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion();
                PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, TransferenciaNueva.getId_transaccion());
            comando.setInt(2, TransferenciaNueva.getCuenta_destino());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Transferencia transferencia = new Transferencia(
                    TransferenciaNueva.getId_transaccion(),
                    TransferenciaNueva.getCuenta_destino()
            );
            return transferencia;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la transferencia", ex);
            throw new PersistenciaException("No se pudo agregar la transferencia");
        }
    }

    @Override
    public Transferencia consultarTransferencia(int cuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
