/*
 * Transaccion.java
 */
package org.itson.bdavanzadas.dominio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * Clase que representa la entidad Transaccion
 */
public class Transaccion {

    private int id;
    private float monto;
    private String tipo;
    private String fecha;
    private int id_cuenta;

    /**
     * Constructor de la clase Transaccion que inicializa todos los campos.
     *
     * @param id El ID de la transacción.
     * @param monto El monto de la transacción.
     * @param tipo El tipo de transacción (por ejemplo, "depósito", "retiro",
     * etc.).
     * @param fecha La fecha de la transacción.
     * @param id_cuenta El ID de la cuenta asociada a la transacción.
     */
    public Transaccion(int id, float monto, String tipo, String fecha, int id_cuenta) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.id_cuenta = id_cuenta;
    }

    /**
     * Constructor por defecto de la clase Transaccion. Crea un nuevo objeto
     * Transaccion con valores predeterminados para todos los campos.
     */
    public Transaccion() {
    }

    /**
     * Constructor de la clase Transaccion que inicializa algunos campos. No
     * incluye el ID de la transacción ni el ID de la cuenta.
     *
     * @param monto El monto de la transacción.
     * @param tipo El tipo de transacción (por ejemplo, "depósito", "retiro",
     * etc.).
     * @param fecha La fecha de la transacción.
     */
    public Transaccion(float monto, String tipo, String fecha) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    /**
     * Devuelve el ID de la transacción.
     *
     * @return El ID de la transacción.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la transacción.
     *
     * @param id El nuevo ID de la transacción.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto El nuevo monto de la transacción.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Devuelve el tipo de la transacción.
     *
     * @return El tipo de la transacción.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la transacción.
     *
     * @param tipo El nuevo tipo de la transacción.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la fecha de la transacción.
     *
     * @return La fecha de la transacción.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la transacción.
     *
     * @param fecha La nueva fecha de la transacción.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el ID de la cuenta asociada a la transacción.
     *
     * @return El ID de la cuenta asociada a la transacción.
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * Establece el ID de la cuenta asociada a la transacción.
     *
     * @param id_cuenta El nuevo ID de la cuenta asociada a la transacción.
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información de la transacción.
     */
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

    /**
     * Devuelve un valor hash para este objeto.
     *
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Transaccion other = (Transaccion) obj;
        return this.id == other.id;
    }

}
