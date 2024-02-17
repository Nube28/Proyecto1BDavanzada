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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.dominio.SinCuenta;
import org.itson.bdavanzadas.dtos.SinCuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public class SinCuentaDAO implements ISinCuentaDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(SinCuentaDAO.class.getName());

    public SinCuentaDAO(IConexion conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public SinCuenta agregar(SinCuentaNuevaDTO sinCuentanNueva) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO SinCuenta(id_transaccion, estado)
                VALUES(?, ?); 
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            int idGenerada = idsGenerados.getInt(1);
            SinCuenta sinCuenta = new SinCuenta(
                    sinCuentanNueva.getId_transaccion(),
                    sinCuentanNueva.getEstado(),
                    this.consultar(idGenerada).getFolio(),
                    this.consultar(idGenerada).getContrasenia()
            );

            return sinCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la transferencia", ex);
            throw new PersistenciaException("No se pudo agregar la transferencia");
        }
    }

    @Override
    public SinCuenta consultar(int id_transaccion) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT folio,contrasenia FROM SinConsulta WHERE id_transaccion=?;
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            comando.setInt(1, id_transaccion);
            ResultSet resultado = comando.executeQuery();

            SinCuenta sinCuenta = null;
            if (resultado.next()) {
                sinCuenta = new SinCuenta();
                sinCuenta.setContrasenia(resultado.getString("contrasenia"));
                sinCuenta.setFolio(resultado.getInt("folio"));
            }
            return sinCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo obtener la cuenta", ex);
            throw new PersistenciaException("No se ha encontrado la cuenta");

        }
    }

    @Override
    public SinCuenta consultarSinCuenta(int folio) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
