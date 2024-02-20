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
                    this.consultarTransaccion(idGenerada).getFecha(),
                    transaccionNueva.getId_cuenta()
            );
            return transaccion;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el socio", ex);
            throw new PersistenciaException("No se pudo agregar el socio");
        }
    }
    
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

    @Override
    public List<Transaccion> consultarPeriodo(int id, String desde, String hasta) throws PersistenciaException {
        String setenciaSQL = """
                SELECT * 
                FROM transacciones
                WHERE id_cuenta = ? 
                and fecha <= ?
                and fecha >= ?
            """;
        List<Transaccion> listaTransaccion = new LinkedList<>();

        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, id);
            comando.setString(2, desde);
            comando.setString(3, hasta);
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
