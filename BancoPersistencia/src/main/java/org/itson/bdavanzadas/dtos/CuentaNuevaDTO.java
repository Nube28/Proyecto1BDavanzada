/**
 * CuentaNuevaDTO.java
 */

package org.itson.bdavanzadas.dtos;

/**
 * DTO que representa una nueva cuenta.
 */
public class CuentaNuevaDTO {

    private int saldo;
    private int id_cliente;
    private boolean esta_activo;
    /**
     * Constructor por defecto de la clase CuentaNuevaDTO. 
     */
    public CuentaNuevaDTO() {
    }

    /**
     * Obtiene el saldo de la cuenta.
     *
     * @return El saldo de la cuenta.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     *
     * @param saldo El saldo de la cuenta a establecer.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el ID del cliente asociado a la cuenta.
     *
     * @return El ID del cliente asociado a la cuenta.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el ID del cliente asociado a la cuenta.
     *
     * @param id_cliente El ID del cliente asociado a la cuenta a establecer.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Verifica si la cuenta está activa.
     *
     * @return true si la cuenta está activa, false en caso contrario.
     */
    public boolean isEsta_activo() {
        return esta_activo;
    }

    /**
     * Establece el estado de activación de la cuenta.
     *
     * @param esta_activo El estado de activación de la cuenta a establecer.
     */
    public void setEsta_activo(boolean esta_activo) {
        this.esta_activo = esta_activo;
    }

}
