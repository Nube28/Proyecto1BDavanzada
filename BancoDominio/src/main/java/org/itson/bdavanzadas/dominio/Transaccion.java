/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dominio;

import java.util.Date;

/**
 *
 * @author af_da
 */
public class Transaccion {
    private int id;
    private float monto;
    private String tipo;
    private Date fecha;

    public Transaccion() {
    }

    public Transaccion(int id, float monto, String tipo, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Transaccion(float monto, String tipo, Date fecha) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Transaccion other = (Transaccion) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("id=").append(id);
        sb.append(", monto=").append(monto);
        sb.append(", tipo=").append(tipo);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
    
    
}
