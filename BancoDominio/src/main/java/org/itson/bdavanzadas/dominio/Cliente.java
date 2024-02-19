/*
 * Cliente.java
 */
package org.itson.bdavanzadas.dominio;

import java.util.Objects;

/**
 *
 * Clase que representa la entidad Cliente
 */
public class Cliente {

    private int id;
    private String contrasenia;
    private String usuario;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String nacimiento;
    private int edad;

    /**
     * Constructor por defecto de la clase Cliente. Crea un nuevo objeto Cliente
     * con valores predeterminados para todos los campos.
     */
    public Cliente() {
    }

    /**
     * Constructor de la clase Cliente que inicializa todos los campos.
     *
     * @param id El ID del cliente.
     * @param contrasenia La contraseña del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param nombres Los nombres del cliente.
     * @param apellido_paterno El apellido paterno del cliente.
     * @param apellido_materno El apellido materno del cliente.
     * @param nacimiento La fecha de nacimiento del cliente.
     * @param edad La edad del cliente.
     */
    public Cliente(int id, String contrasenia, String usuario, String nombres, String apellido_paterno, String apellido_materno, String nacimiento, int edad) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nacimiento = nacimiento;
        this.edad = edad;
    }

    /**
     * Constructor de la clase Cliente que inicializa los campos básicos del
     * cliente. No incluye ID ni edad.
     *
     * @param id El ID del cliente.
     * @param contrasenia La contraseña del cliente.
     * @param nombres Los nombres del cliente.
     * @param apellido_paterno El apellido paterno del cliente.
     * @param apellido_materno El apellido materno del cliente.
     * @param nacimiento La fecha de nacimiento del cliente.
     */
    public Cliente(int id, String contrasenia, String nombres, String apellido_paterno, String apellido_materno, String nacimiento) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nacimiento = nacimiento;
    }

    /**
     * Constructor de la clase Cliente que inicializa todos los campos excepto
     * el ID. No incluye ID.
     *
     * @param contrasenia La contraseña del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param nombres Los nombres del cliente.
     * @param apellido_paterno El apellido paterno del cliente.
     * @param apellido_materno El apellido materno del cliente.
     * @param nacimiento La fecha de nacimiento del cliente.
     * @param edad La edad del cliente.
     */
    public Cliente(String contrasenia, String usuario, String nombres, String apellido_paterno, String apellido_materno, String nacimiento, int edad) {
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nacimiento = nacimiento;
        this.edad = edad;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El nuevo ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene los nombres del usuario.
     *
     * @return Los nombres del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     *
     * @param nombres Los nuevos nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellido_paterno El nuevo apellido paterno del usuario.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellido_materno El nuevo apellido materno del usuario.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param nacimiento La nueva fecha de nacimiento del usuario.
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Obtiene la edad del usuario.
     *
     * @return La edad del usuario.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del usuario.
     *
     * @param edad La nueva edad del usuario.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve un valor hash para este objeto.
     *
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este objeto con otro objeto para determinar la igualdad.
     *
     * @param obj El objeto a comparar con este objeto.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información del objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", usuario=").append(usuario);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellido_paterno=").append(apellido_paterno);
        sb.append(", apellido_materno=").append(apellido_materno);
        sb.append(", nacimiento=").append(nacimiento);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }

}
