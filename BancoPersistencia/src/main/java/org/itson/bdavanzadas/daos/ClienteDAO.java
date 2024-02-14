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
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteActualizadoDTO;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author af_da
 */
public class ClienteDAO implements IClienteDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String setenciaSQL = """
                             INSERT INTO cliente(usuario,contrasenia,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,edad)
                                         VALUES(?,?,?,?,?,?,?);
                             """;
        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getUsuario());
            comando.setString(2, clienteNuevo.getContrasenia());
            comando.setString(3, clienteNuevo.getNombres());
            comando.setString(4, clienteNuevo.getApellido_materno());
            comando.setString(5, clienteNuevo.getApellido_paterno());
            comando.setString(6, clienteNuevo.getNacimiento());
            comando.setInt(7, clienteNuevo.getEdad());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cliente cliente = new Cliente(
                    idsGenerados.getInt(1),
                    clienteNuevo.getContrasenia(),
                    clienteNuevo.getUsuario(),
                    clienteNuevo.getNombres(),
                    clienteNuevo.getApellido_paterno(),
                    clienteNuevo.getApellido_materno(),
                    clienteNuevo.getNacimiento(),
                    clienteNuevo.getEdad()
            );
            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el cliente", ex);
            throw new PersistenciaException("No se pudo agregar el cliente");
        }

    }

    @Override
    public List<ClienteDAO> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarCliente(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarCliente(String usuario, String contrasenia) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT usuario,contrasenia,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,edad FROM Cliente WHERE usuario=? and contrasenia=?/;
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            comando.setString(1, usuario);
            comando.setString(2, contrasenia);
            ResultSet resultado = comando.executeQuery();

            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            Cliente cliente = null;
            if(resultado.next()){
                cliente= new Cliente(
                    resultado.getInt("id"),
                    resultado.getString("contrasenia"),
                    resultado.getString("usuario"),
                    resultado.getString("nombres"),
                    resultado.getString("apellido_paterno"),
                    resultado.getString("apellido_materno"),
                    resultado.getString("fecha_nacimiento"),
                    resultado.getInt("edad")
            );
            }
            
            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo obtener el usuario", ex);
            throw new PersistenciaException("Contraseña o usuario incorrecta");
        }
    }

    @Override
    public Cliente actualizar(ClienteActualizadoDTO socioActualizado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente eliminar(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
