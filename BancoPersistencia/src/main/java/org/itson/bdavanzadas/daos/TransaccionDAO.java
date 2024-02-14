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
import static org.itson.bdavanzadas.daos.TransferenciaDAO.logger;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransaccionNuevaDTO;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public class TransaccionDAO implements ITransaccionDAO {

        final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(TransaccionDAO.class.getName());

    public TransaccionDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }
    
    @Override
    public Transaccion agregar(TransaccionNuevaDTO transaccionNueva) throws PersistenciaException {
        String setenciaSQL = """
                             INSERT INTO transacciones(monto,tipo)
                                         VALUES(?,?);
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, transaccionNueva.getMonto());
            comando.setString(2, transaccionNueva.getTipo());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            comando.
            idsGenerados.next();
            Transaccion transaccion = new Transaccion(
                    idsGenerados.getLong(1),
                    transaccionNueva.g,
                    socioNuevo.getTelefono());
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el socio", ex);
            throw new PersistenciaException("No se pudo agregar el socio");
        }
    }

    @Override
    public List<Transaccion> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
