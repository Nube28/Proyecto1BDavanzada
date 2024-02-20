package org.itson.bdavanzadas.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define el contrato para establecer una conexión a una base de
 * datos.
 */
public interface IConexion {

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Una instancia de Connection que representa la conexión
     * establecida.
     * @throws SQLException Si ocurre un error al intentar establecer la
     * conexión.
     */
    Connection obtenerConexion() throws SQLException;
}
