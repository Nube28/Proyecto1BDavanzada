/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.utileria;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author af_da
 */
public class EncriptarContrasenia {

    static public String encriptar(String contrasenia) {
        return BCrypt.hashpw(contrasenia, BCrypt.gensalt());
    }
}
