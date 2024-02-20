/**
 * TransferenciaNuevaDTO.java
 */
package org.itson.bdavanzadas.dtos;

/**
 * DTO que representa una nueva transferencia.
 */
public class TransferenciaNuevaDTO {

    private int id_transaccion;
    private int cuenta_destino;

    /**
     * Obtiene el ID de la transacción.
     *
     * @return El ID de la transacción.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Establece el ID de la transacción.
     *
     * @param id_transaccion El ID de la transacción a establecer.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Obtiene el número de cuenta de destino.
     *
     * @return El número de cuenta de destino.
     */
    public int getCuenta_destino() {
        return cuenta_destino;
    }

    /**
     * Establece el número de cuenta de destino.
     *
     * @param cuenta_destino El número de cuenta de destino a establecer.
     */
    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

}
