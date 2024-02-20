/**
 * TransaccionNuevaDTO.java
 */
package org.itson.bdavanzadas.dtos;

import java.util.Date;

/**
 * DTO que representa una nueva transacción.
 */
public class TransaccionNuevaDTO {

    private float monto;
    private String tipo;
    private String fecha;
    private int id_cuenta;

    /**
     * Obtiene el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto El monto de la transacción a establecer.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el tipo de la transacción.
     *
     * @return El tipo de la transacción.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la transacción.
     *
     * @param tipo El tipo de la transacción a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha de la transacción.
     *
     * @return La fecha de la transacción.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la transacción.
     *
     * @param fecha La fecha de la transacción a establecer.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el ID de la cuenta asociada a la transacción.
     *
     * @return El ID de la cuenta asociada a la transacción.
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * Establece el ID de la cuenta asociada a la transacción.
     *
     * @param id_cuenta El ID de la cuenta asociada a la transacción a
     * establecer.
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

}
