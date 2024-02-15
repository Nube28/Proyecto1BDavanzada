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

public class CuentaDAO implements ICuentaDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        String setenciaSQL
                = """
                INSERT INTO cuentas(numero, saldo, id_cliente)
                VALUES(?, ?, ?);
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, cuentaNueva.getNumero());
            comando.setInt(2, cuentaNueva.getSaldo());
            comando.setInt(3, cuentaNueva.getId_cliente());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cuenta cuenta = new Cuenta(
                    idsGenerados.getInt(1),
                    cuentaNueva.getNumero(),
                    cuentaNueva.getSaldo(),
                    cuentaNueva.getId_cliente()
            );
            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
        }
    }

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
                        resultados.getInt("id_cliente")
                );
                listaCuenta.add(cuenta);
            }
            logger.log(Level.INFO, "Se consulataros {0} socios", listaCuenta.size());
            return listaCuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar las cuentas la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar las cuentas la cuenta");
        }
    }

    @Override
    public Cuenta consultarCuenta(int Id_cuenta) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT id,fecha_apertura,numero,saldo,id_cliente FROM cuentas
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
                        resultado.getInt("id_cliente")
                );
            }

            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar la cuenta");
        }
    }

    @Override
    public void actualizarMontroTransaccion(Cuenta emisor, int numeroReceptor, float cantidad) throws PersistenciaException {
        try (Connection conn = conexionDB.obtenerConexion()) {
            conn.setAutoCommit(false); // Deshabilitar el autocommit

            // Debitar el monto de la cuenta origen
            String sqlDebitar = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
            try (PreparedStatement resultadoEmisor = conn.prepareStatement(sqlDebitar)) {
                resultadoEmisor.setFloat(1, cantidad);
                resultadoEmisor.setInt(2, emisor.getId_cuenta());
                resultadoEmisor.executeUpdate();
            }

            // Acreditar el monto en la cuenta destino
            String sqlAcreditar = "UPDATE cuentas SET saldo = saldo + ? WHERE numero = ?";
            try (PreparedStatement resultadoReceptor = conn.prepareStatement(sqlAcreditar)) {
                resultadoReceptor.setFloat(1, cantidad);
                resultadoReceptor.setInt(2, numeroReceptor);
                resultadoReceptor.executeUpdate();
            }

            // Confirmar la transacción
            conn.commit();

            System.out.println("Transferencia completada con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error en la transacción: " + ex.getMessage());
        }

    }

    @Override
    public Cuenta consultarCuentaId(int id) throws PersistenciaException {
        String setenciaSQL
                = """
                SELECT id,fecha_apertura,numero,saldo,id_cliente FROM cuentas
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
                        resultado.getInt("id_cliente")
                );
            }

            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido encontrar la cuenta", ex);
            throw new PersistenciaException("No se ha podido encontrar la cuenta");
        }
    }

    @Override
    public void eliminar(String ID) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta actualizar(String ID, CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
