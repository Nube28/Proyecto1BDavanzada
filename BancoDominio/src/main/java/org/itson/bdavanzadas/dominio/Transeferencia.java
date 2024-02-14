/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dominio;

/**
 *
 * @author Berry
 */
public class Transeferencia {
    private int id_transaccion;
    private int cuenta_destino;

    public Transeferencia() {
    }

    public Transeferencia(int id_transaccion, int cuenta_destino) {
        this.id_transaccion = id_transaccion;
        this.cuenta_destino = cuenta_destino;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_transaccion;
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
        final Transeferencia other = (Transeferencia) obj;
        return this.id_transaccion == other.id_transaccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transeferencia{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", cuenta_destino=").append(cuenta_destino);
        sb.append('}');
        return sb.toString();
    }
    
}
