/**
 * CuentaDAO.java
 */
package org.itson.bdavanzadas.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import static org.itson.bdavanzadas.daos.ClienteDAO.logger;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase proporciona métodos para acceder y manipular datos de cuentas en
 * una capa de acceso a datos.
 *
 */
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Construye un nuevo objeto CuentaDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * interactuar con las cuentas.
     */
    public CuentaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    /**
     * Agrega una nueva cuenta utilizando los datos proporcionados en un objeto
     * CuentaNuevaDTO.
     *
     * @param cuentaNueva El objeto CuentaNuevaDTO que contiene los datos de la
     * nueva cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos de la cuenta.
     */
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO cuentas(saldo, id_cliente)
                VALUES(?, ?);
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, cuentaNueva.getSaldo());
            comando.setInt(2, cuentaNueva.getId_cliente());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cuenta cuenta = new Cuenta(
                    idsGenerados.getInt(1),
                    cuentaNueva.getSaldo(),
                    cuentaNueva.getId_cliente(),
                    cuentaNueva.isEsta_activo()
            );
            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
        }
    }

    /**
     * Consulta las cuentas asociadas a un cliente específico mediante su ID de
     * cuenta.
     *
     * @param Id_cuenta El ID de cuenta del cliente cuyas cuentas se desean
     * consultar.
     * @return Una lista de objetos Cuenta que representan las cuentas asociadas
     * al cliente.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las cuentas.
     */
    @Override
    public List<Cuenta> consultar(int Id_cuenta) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT * FROM cuentas
                WHERE id_cliente = ?;
            """;
        List<Cuenta> listaCuenta = new LinkedList<>();

        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, Id_cuenta);
            ResultSet resultados = comando.executeQuery();

            while (resultados.next()) {
                Cuenta cuenta = new Cuenta(
                        resultados.getInt("id"),
                        resultados.getString("fecha_apertura"),
                        resultados.getInt("numero"),
                        resultados.getFloat("saldo"),
                        resultados.getInt("id_cliente"),
                        resultados.getBoolean("activo")
                );
                listaCuenta.add(cuenta);
            }
            logger.log(Level.INFO, "Se consulataros {0} cuentas", listaCuenta.size());
            return listaCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar las cuentas la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar las cuentas la cuenta");
        }
    }

    /**
     * Consulta una cuenta por su ID.
     *
     * @param Id_cuenta El ID de la cuenta a consultar.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la cuenta.
     */
    @Override
    public Cuenta consultarCuenta(int Id_cuenta) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT id,fecha_apertura,numero,saldo,id_cliente,activo FROM cuentas
                WHERE numero = ?;
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, Id_cuenta);
            ResultSet resultado = comando.executeQuery();

            Cuenta cuenta = null;
            if (resultado.next()) {
                cuenta = new Cuenta(
                        resultado.getInt("id"),
                        resultado.getString("fecha_apertura"),
                        resultado.getInt("numero"),
                        resultado.getFloat("saldo"),
                        resultado.getInt("id_cliente"),
                        resultado.getBoolean("activo")
                );
            }

            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar la cuenta");
        }
    }

    /**
     * Actualiza el monto de una transacción para una cuenta emisora y receptora
     * específica.
     *
     * @param emisor La cuenta emisora de la transacción.
     * @param numeroReceptor El número de cuenta receptora de la transacción.
     * @param cantidad La cantidad de dinero involucrada en la transacción.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * del monto de la transacción.
     */
    @Override
    public void actualizarMontroTransaccion(Cuenta emisor, int numeroReceptor, float cantidad) throws PersistenciaException {
        try (Connection conexion = conexionDB.obtenerConexion()) {
            conexion.setAutoCommit(false); // Deshabilitar el autocommit
            if (emisor.getSaldo() > cantidad) {
                conexion.rollback();
            }
            // Debitar el monto de la cuenta origen
            String consultaDisminuir = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
            try (PreparedStatement resultadoEmisor = conexion.prepareStatement(consultaDisminuir)) {
                resultadoEmisor.setFloat(1, cantidad);
                resultadoEmisor.setInt(2, emisor.getId_cuenta());
                resultadoEmisor.executeUpdate();
            }

            // Acreditar el monto en la cuenta destino
            String consultaAumentar = "UPDATE cuentas SET saldo = saldo + ? WHERE numero = ?";
            try (PreparedStatement resultadoReceptor = conexion.prepareStatement(consultaAumentar)) {
                resultadoReceptor.setFloat(1, cantidad);
                resultadoReceptor.setInt(2, numeroReceptor);
                resultadoReceptor.executeUpdate();
            }

            // Confirmar la transacción
            conexion.commit();

            System.out.println("Transferencia completada con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error en la transacción: " + ex.getMessage());
        }

    }

    /**
     * Consulta una cuenta por su ID.
     *
     * @param id El ID de la cuenta a consultar.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * la cuenta.
     */
    @Override
    public Cuenta consultarCuentaId(int id) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT id,fecha_apertura,numero,saldo,id_cliente,activo FROM cuentas
                WHERE id = ?;
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Cuenta cuenta = null;
            if (resultado.next()) {
                cuenta = new Cuenta(
                        resultado.getInt("id"),
                        resultado.getString("fecha_apertura"),
                        resultado.getInt("numero"),
                        resultado.getFloat("saldo"),
                        resultado.getInt("id_cliente"),
                        resultado.getBoolean("activo")
                );
            }

            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar la cuenta");
        }
    }

    /**
     * Cancela una cuenta por su ID.
     *
     * @param ID El ID de la cuenta a cancelar.
     * @throws PersistenciaException Si ocurre un error durante la cancelación
     * de la cuenta.
     */
    @Override
    public void CancelarCuenta(int ID) throws PersistenciaException {
        String setenciaSQL = """
                UPDATE cuentas 
                SET activo = false 
                WHERE id = ?;
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, ID);
            comando.execute();
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo cancelar la cuenta", ex);
            throw new PersistenciaException("No se pudo cancelar la cuenta");
        }
    }

    /**
     * Actualiza los datos de una cuenta utilizando los datos proporcionados en
     * un objeto CuentaNuevaDTO.
     *
     * @param ID El ID de la cuenta a actualizar.
     * @param cuentaNueva El objeto CuentaNuevaDTO que contiene los nuevos datos
     * de la cuenta.
     * @return La cuenta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * de los datos de la cuenta.
     */
    @Override
    public Cuenta actualizar(String ID, CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Retira una cantidad de dinero de una cuenta sin asociar a un cliente.
     *
     * @param cuenta La cuenta de la que se retirará el dinero.
     * @param cantidad La cantidad de dinero a retirar.
     * @throws PersistenciaException Si ocurre un error durante el retiro de
     * dinero de la cuenta.
     */
    @Override
    public void retirarSinCuenta(Cuenta cuenta, float cantidad) throws PersistenciaException {
        try (Connection conexion = conexionDB.obtenerConexion()) {
            conexion.setAutoCommit(false); // Deshabilitar el autocommit
            if (cuenta.getSaldo() > cantidad) {
                conexion.rollback();
            }
            String sqlDebitar = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
            try (PreparedStatement resultadoEmisor = conexion.prepareStatement(sqlDebitar)) {
                resultadoEmisor.setFloat(1, cantidad);
                resultadoEmisor.setInt(2, cuenta.getId_cuenta());
                resultadoEmisor.executeUpdate();
            }
            // Confirmar la transacción
            conexion.commit();

        } catch (SQLException ex) {
            System.err.println("Error en la transacción: " + ex.getMessage());
        }
    }

}
