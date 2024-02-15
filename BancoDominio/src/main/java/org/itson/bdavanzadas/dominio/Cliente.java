/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dominio;

import java.util.Objects;

/**
 *
 * @author Berry
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

    public Cliente() {
    }

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

    public Cliente(int id, String contrasenia, String nombres, String apellido_paterno, String apellido_materno, String nacimiento) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nacimiento = nacimiento;
    }

    public Cliente(String contrasenia, String usuario, String nombres, String apellido_paterno, String apellido_materno, String nacimiento, int edad) {
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nacimiento = nacimiento;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
