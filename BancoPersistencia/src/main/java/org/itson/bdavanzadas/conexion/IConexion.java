package org.itson.bdavanzadas.conexion;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexion {
    Connection obtenerConexion() throws SQLException;
}
