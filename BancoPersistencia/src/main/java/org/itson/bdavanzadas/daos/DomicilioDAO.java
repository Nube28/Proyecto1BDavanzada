/*
 * DomicilioDAO.java
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
import org.itson.bdavanzadas.dominio.Domicilio;
import org.itson.bdavanzadas.dtos.DomicilioNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que define operaciones para agregar y consultar domicilios en el
 * sistema.
 */
public class DomicilioDAO implements IDomicilioDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(DomicilioDAO.class.getName());

    /**
     * Construye un nuevo objeto CuentaDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * interactuar con las cuentas.
     */
    public DomicilioDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    /**
     * Agrega un nuevo domicilio al sistema.
     *
     * @param domicilioNuevo Objeto DomicilioNuevoDTO que contiene los datos del
     * nuevo domicilio.
     * @return El domicilio agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Domicilio agregar(DomicilioNuevoDTO domicilioNuevo) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO domicilios(calle,numero_exterior,numero_interior,codigo_postal,colonia,id_cliente)
                VALUES(?, ?,?,?,?,?);
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, domicilioNuevo.getCalle());
            comando.setInt(2, domicilioNuevo.getNumero_exterior());
            comando.setInt(3, domicilioNuevo.getNumero_interior());
            comando.setInt(4, domicilioNuevo.getCodigo_postal());
            comando.setString(5, domicilioNuevo.getColonia());
            comando.setInt(6, domicilioNuevo.getId_cliente());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Domicilio domicilio = new Domicilio(
                    idsGenerados.getInt(1),
                    domicilioNuevo.getCalle(),
                    domicilioNuevo.getNumero_interior(),
                    domicilioNuevo.getNumero_exterior(),
                    domicilioNuevo.getCodigo_postal(),
                    domicilioNuevo.getColonia(),
                    domicilioNuevo.getId_cliente()
            );
            return domicilio;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
        }
    }

    /**
     * Consulta un domicilio por su ID en el sistema.
     *
     * @param id El ID del domicilio a consultar.
     * @return El domicilio encontrado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * consulta.
     */
    @Override
    public Domicilio consultar(int id) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT * FROM domicilios
                WHERE id_cliente = ?;
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Domicilio domicilio = null;
            if (resultado.next()) {
                domicilio = new Domicilio(
                        resultado.getInt("id"),
                        resultado.getString("calle"),
                        resultado.getInt("numero_exterior"),
                        resultado.getInt("numero_interior"),
                        resultado.getInt("codigo_postal"),
                        resultado.getString("colonia"),
                        resultado.getInt("id_cliente")
                );
            }

            return domicilio;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar el domicilio", ex);
            throw new PersistenciaException("No se ha podido encontrar el domicilio");
        }
    }

    @Override
    public Domicilio actualizar(DomicilioNuevoDTO domicilioNuevo, Domicilio domicilio) throws PersistenciaException {
        String setenciaSQL = """
            UPDATE Domicilios
            SET calle = ?, 
            numero_exterior = ?,
            numero_interior = ?, 
            codigo_postal = ?, 
            colonia = ?
            WHERE id_cliente = ?;
        """;

        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, domicilioNuevo.getCalle());
            comando.setInt(2, domicilioNuevo.getNumero_exterior());
            comando.setInt(3, domicilioNuevo.getNumero_interior());
            comando.setInt(4, domicilioNuevo.getCodigo_postal());
            comando.setString(5, domicilioNuevo.getColonia());
            comando.setInt(6, domicilioNuevo.getId_cliente());

            int numeroRegistrosActualizados = comando.executeUpdate();
            logger.log(Level.INFO, "Se actualizaron {0} registros", numeroRegistrosActualizados);

            Domicilio domicilioAct = new Domicilio(
                    domicilio.getId_domicilio(),
                    domicilioNuevo.getCalle(),
                    domicilioNuevo.getNumero_exterior(),
                    domicilioNuevo.getNumero_interior(),
                    domicilioNuevo.getCodigo_postal(),
                    domicilioNuevo.getColonia(),
                    domicilio.getId_cliente()
            );

            return domicilioAct;

        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo actualizar", ex);
            throw new PersistenciaException("No se pudo actualizar");
        }
    }

}
