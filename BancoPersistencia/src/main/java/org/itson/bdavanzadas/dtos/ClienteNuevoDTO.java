package org.itson.bdavanzadas.dtos;

import org.itson.bdavanzadas.utileria.EncriptarContrasenia;
import org.mindrot.jbcrypt.BCrypt;

/**
 * DTO que representa un nuevo cliente.
 */
public class ClienteNuevoDTO {

    private String contrasenia;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String nacimiento;

    /**
     * Obtiene la contraseña del cliente.
     *
     * @return La contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param contrasenia La contraseña del cliente a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = EncriptarContrasenia.encriptar(contrasenia);

    }

    /**
     * Obtiene el nombre(s) del cliente.
     *
     * @return El nombre(s) del cliente.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece el nombre(s) del cliente.
     *
     * @param nombres El nombre(s) del cliente a establecer.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return El apellido paterno del cliente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellido_paterno El apellido paterno del cliente a establecer.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return El apellido materno del cliente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellido_materno El apellido materno del cliente a establecer.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return La fecha de nacimiento del cliente.
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param nacimiento La fecha de nacimiento del cliente a establecer.
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

}
