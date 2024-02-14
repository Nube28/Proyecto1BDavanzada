package org.itson.bdavanzadas.dominio;

import java.util.Date;
import java.util.Objects;

public class Cuenta {
    private int id_cuenta;
    private String fecha_apertura;
    private int numero;
    private float saldo;
    private int id_cliente;

    public Cuenta(int id_cuenta, String fecha_apertura, int numero, float saldo, int id_cliente) {
        this.id_cuenta = id_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.numero = numero;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }

    public Cuenta( int numero, float saldo, int id_transaccion, int id_cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }

    public Cuenta() {
    }
    
    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_cuenta;
        hash = 67 * hash + Objects.hashCode(this.fecha_apertura);
        hash = 67 * hash + this.numero;
        hash = 67 * hash + Float.floatToIntBits(this.saldo);
        hash = 67 * hash + this.id_cliente;
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
        final Cuenta other = (Cuenta) obj;
        if (this.id_cuenta != other.id_cuenta) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        return Objects.equals(this.fecha_apertura, other.fecha_apertura);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id_cuenta=").append(id_cuenta);
        sb.append(", fecha_apertura=").append(fecha_apertura);
        sb.append(", numero=").append(numero);
        sb.append(", saldo=").append(saldo);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append('}');
        return sb.toString();
    }
    
    
}
