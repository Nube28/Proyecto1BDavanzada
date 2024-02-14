/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dominio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author af_da
 */
public class Transaccion {
    private int id;
    private float monto;
    private String tipo;
    private Date fecha;
    private int id_cuenta;

    public Transaccion(int id, float monto, String tipo, Date fecha, int id_cuenta) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.id_cuenta = id_cuenta;
    }

    public Transaccion() {
    }

    

    public Transaccion(float monto, String tipo, Date fecha, int id_cuenta) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.id_cuenta = id_cuenta;
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
    
    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Float.floatToIntBits(this.monto);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + this.id_cuenta;
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
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.monto) != Float.floatToIntBits(other.monto)) {
            return false;
        }
        if (this.id_cuenta != other.id_cuenta) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("id=").append(id);
        sb.append(", monto=").append(monto);
        sb.append(", tipo=").append(tipo);
        sb.append(", fecha=").append(fecha);
        sb.append(", id_cuenta=").append(id_cuenta);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
