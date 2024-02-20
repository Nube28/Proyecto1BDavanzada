/*
 * SinCuentaDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.sql.CallableStatement;
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
 * Esta clase proporciona métodos para acceder y manipular datos de SinCuentaDAO
 * de retiro sin cuenta en una capa de acceso a datos (DAO)
 *
 */
public class SinCuentaDAO implements ISinCuentaDAO {
    
    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(SinCuentaDAO.class.getName());

    /**
     * Construye un nuevo objeto SinCuentaDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * interactuar con las cuentas.
     */
    public SinCuentaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    /**
     * Agrega una nueva transacción de retiro sin cuenta utilizando los datos
     * proporcionados en un objeto SinCuentaNuevaDTO.
     *
     * @param sinCuentanNueva El objeto SinCuentaNuevaDTO que contiene los datos
     * de la nueva transacción de retiro sin cuenta a agregar.
     * @return La transacción de retiro sin cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la transacción de retiro sin cuenta.
     */
    @Override
    public SinCuenta agregar(SinCuentaNuevaDTO sinCuentanNueva) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO SinCuenta(id_transaccion, estado)
                VALUES(?, ?); 
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            //Inicio stored procedure
            comando.setInt(1, sinCuentanNueva.getId_transaccion());
            comando.setString(2, sinCuentanNueva.getEstado());
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            SinCuenta sinCuenta = new SinCuenta(
                    sinCuentanNueva.getId_transaccion(),
                    sinCuentanNueva.getEstado(),
                    this.consultar(sinCuentanNueva.getId_transaccion()).getFolio(),
                    this.consultar(sinCuentanNueva.getId_transaccion()).getContrasenia()
            );
            
            return sinCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la transferencia", ex);
            throw new PersistenciaException("No se pudo agregar la transferencia");
        }
    }

    /**
     * Consulta una transacción de retiro sin cuenta por su ID de transacción.
     *
     * @param id_transaccion El ID de transacción de la transacción de retiro
     * sin cuenta a consultar.
     * @return La transacción de retiro sin cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción de retiro sin cuenta.
     */
    @Override
    public SinCuenta consultar(int id_transaccion) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT folio,contrasenia FROM SinCuenta WHERE id_transaccion=?;
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

    /**
     * Consulta una transacción de retiro sin cuenta por su folio y contraseña.
     *
     * @param folio El folio de la transacción de retiro sin cuenta a consultar.
     * @param contrasenia La contraseña de la transacción de retiro sin cuenta a
     * consultar.
     * @return La transacción de retiro sin cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción de retiro sin cuenta.
     */
    @Override
    public SinCuenta consultarSinCuenta(int folio, String contrasenia) throws PersistenciaException {
        
        String setenciaSQL = """
                             SELECT * FROM SinCuenta WHERE folio=? and contrasenia =?;
                             """;


        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            
            comando.setInt(1, folio);
            comando.setString(2, contrasenia);
            
            ResultSet resultado = comando.executeQuery();
            SinCuenta sinCuenta = null;
            if (resultado.next()) {
                sinCuenta = new SinCuenta();
                sinCuenta.setEstado(resultado.getString("estado"));
                sinCuenta.setId_transaccion(resultado.getInt("id_transaccion"));
                sinCuenta.setContrasenia(resultado.getString("contrasenia"));
                sinCuenta.setFolio(resultado.getInt("folio"));

                //Inicio stored procedure
                try (CallableStatement callableStatement = conexion.prepareCall("{call ActualizarEstadoTransaccion(?,?)}")) {
                    callableStatement.setInt(1, folio);
                    callableStatement.setString(2, contrasenia);
                    callableStatement.execute();
                }

                //Fin storedProcedure
            }
            
            return sinCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo obtener la cuenta", ex);
            throw new PersistenciaException("No se ha encontrado la cuenta");
            
        }
    }


}
