package org.itson.bdavanzadas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que proporciona métodos para establecer una conexión a una base de
 * datos.
 */
public class Conexion implements IConexion {

    final String cadenaConexion;
    final String usuario;
    final String contraseña;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    /**
     * Constructor de la clase Conexion.
     *
     * @param cadenaConexion La cadena de conexión a la base de datos.
     * @param usuario El nombre de usuario para acceder a la base de datos.
     * @param contraseña La contraseña del usuario para acceder a la base de
     * datos.
     */
    public Conexion(String cadenaConexion, String usuario, String contraseña) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene una conexión a la base de datos utilizando los parámetros de
     * conexión proporcionados.
     *
     * @return Una instancia de Connection que representa la conexión
     * establecida.
     * @throws SQLException Si ocurre un error al intentar establecer la
     * conexión.
     */
    @Override
    public Connection obtenerConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(
                cadenaConexion,
                usuario,
                contraseña
        );
        logger.log(Level.INFO, "Conexion establecida {0}", cadenaConexion);
        return conexion;
    }
}
