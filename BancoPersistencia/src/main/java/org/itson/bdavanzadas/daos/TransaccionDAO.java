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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import static org.itson.bdavanzadas.daos.ClienteDAO.logger;
import static org.itson.bdavanzadas.daos.TransferenciaDAO.logger;
import org.itson.bdavanzadas.dominio.Cliente;
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
                             INSERT INTO transacciones(monto,tipo,id_cuenta)
                                         VALUES(?,?,?);
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, transaccionNueva.getMonto());
            comando.setString(2, transaccionNueva.getTipo());
            comando.setInt(3, transaccionNueva.getId_cuenta());

            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            int idGenerada = idsGenerados.getInt(1);
            Transaccion transaccion = new Transaccion(
                    idGenerada,
                    transaccionNueva.getMonto(),
                    transaccionNueva.getTipo(),
                    this.consultarFecha(idGenerada).getFecha()
            );
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el socio", ex);
            throw new PersistenciaException("No se pudo agregar el socio");
        }
    }

    @Override
    public Transaccion consultarFecha(int id) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT fecha FROM transacciones WHERE id=?;
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            comando.setLong(1, id);
            ResultSet resultado = comando.executeQuery();

            Transaccion transaccion = null;
            if (resultado.next()) {
                transaccion = new Transaccion();
                Date fechaSQL = resultado.getDate("fecha");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaString = dateFormat.format(fechaSQL);
                transaccion.setFecha(fechaString);
            }
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo obtener el usuario", ex);
            throw new PersistenciaException("Contraseña o usuario incorrecta");
        }
    }

    @Override
    public List<Transaccion> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
