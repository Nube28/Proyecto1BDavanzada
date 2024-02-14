package org.itson.bdavanzadas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion implements IConexion{
    final String cadenaConexion;
    final String usuario;
    final String contraseña;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public Conexion(String cadenaConexion, String usuario, String contraseña) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
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
