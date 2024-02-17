/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dominio;

/**
 *
 * @author af_da
 */
public class SinCuenta {

    private int id_transaccion;
    private String estado;
    private int folio;
    private String contrasenia;

    public SinCuenta() {
    }

    public SinCuenta(int id_transaccion, String estado, int folio, String contrasenia) {
        this.id_transaccion = id_transaccion;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public SinCuenta(String estado, int folio, String contrasenia) {
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id_transaccion;
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
        final SinCuenta other = (SinCuenta) obj;
        return this.id_transaccion == other.id_transaccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinCuenta{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", estado=").append(estado);
        sb.append(", folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append('}');
        return sb.toString();
    }

}
