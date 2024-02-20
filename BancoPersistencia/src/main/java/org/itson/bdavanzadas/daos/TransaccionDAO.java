/*
 * TransaccionDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import static org.itson.bdavanzadas.daos.ClienteDAO.logger;
import static org.itson.bdavanzadas.daos.CuentaDAO.logger;
import static org.itson.bdavanzadas.daos.TransferenciaDAO.logger;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dominio.Transferencia;
import org.itson.bdavanzadas.dtos.TransaccionNuevaDTO;
import org.itson.bdavanzadas.dtos.TransferenciaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase proporciona métodos para acceder y manipular datos de
 * transacciones en una capa de acceso a datos.
 *
 *
 */
public class TransaccionDAO implements ITransaccionDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(TransaccionDAO.class.getName());

    /**
     * Construye un nuevo objeto TransaccionDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * interactuar con las cuentas.
     */
    public TransaccionDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    /**
     * Agrega una nueva transacción utilizando los datos proporcionados en un
     * objeto TransaccionNuevaDTO.
     *
     * @param transaccionNueva El objeto TransaccionNuevaDTO que contiene los
     * datos de la nueva transacción a agregar.
     * @return La transacción agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la transacción.
     */
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
                    this.consultarTransaccion(idGenerada).getFecha(),
                    transaccionNueva.getId_cuenta()
            );
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el socio", ex);
            throw new PersistenciaException("No se pudo agregar el socio");
        }
    }

    /**
     * Consulta una transacción por su ID.
     *
     * @param id El ID de la transacción a consultar.
     * @return La transacción encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la transacción.
     */
    @Override
    public Transaccion consultarTransaccion(int id) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT * FROM transacciones WHERE id=?;
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
                transaccion.setId(resultado.getInt("id"));
                transaccion.setMonto(resultado.getFloat("monto"));
                transaccion.setTipo(resultado.getString("tipo"));
                transaccion.setId_cuenta(resultado.getInt("id_cuenta"));
            }
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo obtener el usuario", ex);
            throw new PersistenciaException("Contraseña o usuario incorrecta");
        }
    }

    /**
     * Consulta todas las transacciones asociadas a un cliente específico por su
     * ID de cliente.
     *
     * @param id El ID del cliente para el que se consultan las transacciones.
     * @return Una lista de transacciones asociadas al cliente especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las transacciones.
     */
    @Override
    public List<Transaccion> consultar(int id) throws PersistenciaException {
        String setenciaSQL = """
                SELECT * 
                FROM transacciones
                WHERE id_cuenta = ?;
            """;
        List<Transaccion> listaTransaccion = new LinkedList<>();

        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, id);
            ResultSet resultados = comando.executeQuery();

            while (resultados.next()) {
                Transaccion transaccion = new Transaccion(
                        resultados.getInt("id"),
                        resultados.getFloat("monto"),
                        resultados.getString("tipo"),
                        resultados.getString("fecha"),
                        resultados.getInt("id_cuenta")
                );
                listaTransaccion.add(transaccion);
            }
            logger.log(Level.INFO, "Se consulataros {0} Transacciones", listaTransaccion.size());
            return listaTransaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar las cuentas la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar las cuentas la cuenta");
        }
    }

    /**
     * Consulta las transacciones asociadas a un cliente específico dentro de un
     * período de tiempo.
     *
     * @param id El ID del cliente para el que se consultan las transacciones.
     * @param desde La fecha de inicio del período de tiempo.
     * @param hasta La fecha de fin del período de tiempo.
     * @return Una lista de transacciones asociadas al cliente especificado y
     * dentro del período de tiempo especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las transacciones.
     */
    @Override
    public List<Transaccion> consultarPeriodo(int id, String desde, String hasta) throws PersistenciaException {
        String setenciaSQL = """
            SELECT * 
            FROM transacciones
            WHERE id_cuenta = ? 
            AND fecha >= ? 
            AND fecha <= ?;
        """;
        List<Transaccion> listaTransaccion = new LinkedList<>();

        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, id);
            comando.setString(2, desde + " 00:00:00");
            comando.setString(3, hasta + " 23:59:59");
            ResultSet resultados = comando.executeQuery();

            while (resultados.next()) {
                Transaccion transaccion = new Transaccion(
                        resultados.getInt("id"),
                        resultados.getFloat("monto"),
                        resultados.getString("tipo"),
                        resultados.getString("fecha"),
                        resultados.getInt("id_cuenta")
                );
                listaTransaccion.add(transaccion);
            }
            logger.log(Level.INFO, "Se consulataros {0} Transacciones", listaTransaccion.size());
            return listaTransaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No Hay transacciones en el periodo", ex);
            throw new PersistenciaException("No Hay transacciones en el periodo");
        }
    }

}
