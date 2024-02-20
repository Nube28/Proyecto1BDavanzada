package org.itson.bdavanzadas.utileria;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase que proporciona métodos para encriptar y comprobar contraseñas
 * utilizando el algoritmo BCrypt.
 */
public class EncriptarContrasenia {

    /**
     * Encripta una contraseña utilizando el algoritmo BCrypt.
     *
     * @param contrasenia La contraseña a encriptar.
     * @return La contraseña encriptada.
     */
    static public String encriptar(String contrasenia) {
        return BCrypt.hashpw(contrasenia, BCrypt.gensalt());
    }

    /**
     * Comprueba si una contraseña sin encriptar coincide con una contraseña
     * encriptada.
     *
     * @param contra1 La contraseña sin encriptar.
     * @param contra2 La contraseña encriptada.
     * @return true si las contraseñas coinciden, false en caso contrario.
     */
    static public boolean comprobarContrasenia(String contra1, String contra2) {
        return BCrypt.checkpw(contra1, contra2);
    }
}
