/**
 * ClienteDAO.java
 */
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
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase proporciona métodos para acceder y manipular datos de clientes en
 * una capa de acceso a datos.
 */
public class ClienteDAO implements IClienteDAO {

    final IConexion conexionDB;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Construye un nuevo objeto ClienteDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * interactuar con las cuentas.
     */
    public ClienteDAO(IConexion conexion) {
        this.conexionDB = conexion;
    }

    /**
     * Agrega un nuevo cliente utilizando los datos proporcionados en un objeto
     * ClienteNuevoDTO.
     *
     * @param clienteNuevo El objeto ClienteNuevoDTO que contiene los datos del
     * nuevo cliente a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de los datos del cliente.
     */
    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String setenciaSQL = """
                             INSERT INTO Clientes(contrasenia,nombres,apellido_paterno,apellido_materno,fecha_nacimiento)
                                         VALUES(?,?,?,?,?);
                             """;
        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getContrasenia());
            comando.setString(2, clienteNuevo.getNombres());
            comando.setString(3, clienteNuevo.getApellido_materno());
            comando.setString(4, clienteNuevo.getApellido_paterno());
            comando.setString(5, clienteNuevo.getNacimiento());
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cliente cliente = new Cliente(
                    idsGenerados.getInt(1),
                    clienteNuevo.getContrasenia(),
                    clienteNuevo.getNombres(),
                    clienteNuevo.getApellido_paterno(),
                    clienteNuevo.getApellido_materno(),
                    clienteNuevo.getNacimiento()
            );
            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar el cliente", ex);
            throw new PersistenciaException("No se pudo agregar el cliente");
        }

    }

    /**
     * Consulta todos los clientes almacenados.
     *
     * @return Una lista de objetos ClienteDAO que representan todos los
     * clientes almacenados.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * los clientes.
     */
    @Override
    public List<ClienteDAO> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consulta un cliente por su ID de usuario.
     *
     * @param usuario El ID del usuario del cliente a consultar.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la consulta del
     * cliente.
     */
    @Override
    public Cliente consultarCliente(int usuario) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT id,usuario,contrasenia,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,edad FROM Clientes WHERE usuario=?;
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            comando.setInt(1, usuario);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            if (resultado.next()) {
                cliente = new Cliente(
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

    /**
     * Consulta un cliente por su usuario y contraseña.
     *
     * @param usuario El nombre de usuario del cliente.
     * @param contrasenia La contraseña del cliente.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la consulta del
     * cliente.
     */
    @Override
    public Cliente consultarCliente(String usuario, String contrasenia) throws PersistenciaException {
        String setenciaSQL = """
                             SELECT id,usuario,contrasenia,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,edad FROM Clientes WHERE usuario=? and contrasenia=?;
                             """;

        try (
                Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(
                setenciaSQL);) {
            comando.setString(1, usuario);
            comando.setString(2, contrasenia);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            if (resultado.next()) {
                cliente = new Cliente(
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

    /**
     * Actualiza los datos de un cliente utilizando los datos proporcionados en
     * un objeto ClienteNuevoDTO.
     *
     * @param clienteNuevo El objeto ClienteNuevoDTO que contiene los nuevos
     * datos del cliente.
     * @param cliente El cliente existente que se actualizará.
     * @return El cliente actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * de los datos del cliente.
     */
    @Override
    public Cliente actualizar(ClienteNuevoDTO clienteNuevo, Cliente cliente) throws PersistenciaException {
        String setenciaSQL = """
                            UPDATE Clientes
                            SET nombres = ?,
                                apellido_paterno = ?,
                                apellido_materno = ?,
                                fecha_nacimiento = ?
                            WHERE id = ?
                             """;
        try (Connection conexion = this.conexionDB.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(setenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getNombres());
            comando.setString(2, clienteNuevo.getApellido_materno());
            comando.setString(3, clienteNuevo.getApellido_paterno());
            comando.setString(4, clienteNuevo.getNacimiento());
            comando.setInt(5, cliente.getId());

            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se actualizaron {0}", numeroRegistrosInsertados);

            Cliente clienteAct = new Cliente(
                    cliente.getId(),
                    cliente.getContrasenia(),
                    clienteNuevo.getNombres(),
                    clienteNuevo.getApellido_paterno(),
                    clienteNuevo.getApellido_materno(),
                    clienteNuevo.getNacimiento()
            );
            return clienteAct;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se pudo actualizar", ex);
            throw new PersistenciaException("No se pudo actualizar");
        }
    }

    /**
     * Elimina un cliente por su ID.
     *
     * @param id El ID del cliente a eliminar.
     * @return El cliente eliminado.
     * @throws PersistenciaException Si ocurre un error durante la eliminación
     * del cliente.
     */
    @Override
    public Cliente eliminar(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
