package org.itson.bdavanzadas.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import static org.itson.bdavanzadas.daos.ClienteDAO.logger;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

public class CuentaDAO implements ICuentaDAO{
    
    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }
    
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        String setenciaSQL = 
            """
                INSERT INTO cuenta(numero, saldo, id_cliente)
                VALUES(?, ?, ?);
            """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement( setenciaSQL,Statement.RETURN_GENERATED_KEYS);){
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
    public Cuenta consultarCuenta(int Id_cuenta) throws PersistenciaException {
        String setenciaSQL = 
            """
                SELECT * FROM cuentas
                WHERE id = "?";
            """;
        try(Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement( setenciaSQL,Statement.RETURN_GENERATED_KEYS);){
            comando.setInt(1, Id_cuenta);
            ResultSet resultado = comando.executeQuery();
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            
            Cuenta cuenta = null;
            if(resultado.next()){
                cuenta = new Cuenta(
                    resultado.getInt("id"),
                    resultado.getString("fecha_apertura"),
                    resultado.getInt("numero"),
                    resultado.getFloat("saldo"),
                    resultado.getInt("id_cliente")
                );
            }
            
            return cuenta;
        }catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
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

    @Override
    public List<Cuenta> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
