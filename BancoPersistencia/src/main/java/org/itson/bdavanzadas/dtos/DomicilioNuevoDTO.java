/*
 * DomicilioNuevoDTO.java
 */
package org.itson.bdavanzadas.dtos;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para
 * almacenar los datos de un nuevo domicilio.
 *
 */
public class DomicilioNuevoDTO {

    private String calle;
    private int numero_exterior;
    private int numero_interior;
    private int codigo_postal;
    private String colonia;
    private int id_cliente;

    /**
     * Obtiene el nombre de la calle del domicilio.
     *
     * @return El nombre de la calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle del domicilio.
     *
     * @param calle El nuevo nombre de la calle del domicilio.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número exterior del domicilio.
     *
     * @return El número exterior del domicilio.
     */
    public int getNumero_exterior() {
        return numero_exterior;
    }

    /**
     * Establece el número exterior del domicilio.
     *
     * @param numero_exterior El nuevo número exterior del domicilio.
     */
    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    /**
     * Obtiene el número interior del domicilio.
     *
     * @return El número interior del domicilio.
     */
    public int getNumero_interior() {
        return numero_interior;
    }

    /**
     * Establece el número interior del domicilio.
     *
     * @param numero_interior El nuevo número interior del domicilio.
     */
    public void setNumero_interior(int numero_interior) {
        this.numero_interior = numero_interior;
    }

    /**
     * Obtiene el código postal del domicilio.
     *
     * @return El código postal del domicilio.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal del domicilio.
     *
     * @param codigo_postal El nuevo código postal del domicilio.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtiene el nombre de la colonia del domicilio.
     *
     * @return El nombre de la colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece el nombre de la colonia del domicilio.
     *
     * @param colonia El nuevo nombre de la colonia del domicilio.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el ID del cliente asociado con el domicilio.
     *
     * @return El ID del cliente asociado con el domicilio.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el ID del cliente asociado con el domicilio.
     *
     * @param id_cliente El nuevo ID del cliente asociado con el domicilio.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}
