/**
 * DireccionNuevaDTO.java
 */
package org.itson.bdavanzadas.dtos;

/**
 * DTO que representa una nueva dirección.
 */
public class DireccionNuevaDTO {

    private String calle;
    private int numero_exterior;
    private int numero_interior;
    private String codigo_postal;
    private String colonia;

    /**
     * Constructor vacío de la clase DireccionNuevaDTO.
     */
    public DireccionNuevaDTO() {
    }

    /**
     * Constructor de la clase DireccionNuevaDTO.
     *
     * @param calle La calle de la dirección.
     * @param numero_exterior El número exterior de la dirección.
     * @param numero_interior El número interior de la dirección.
     * @param codigo_postal El código postal de la dirección.
     * @param colonia La colonia de la dirección.
     */
    public DireccionNuevaDTO(String calle, int numero_exterior, int numero_interior, String codigo_postal, String colonia) {
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interior = numero_interior;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle La calle de la dirección a establecer.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número exterior de la dirección.
     *
     * @return El número exterior de la dirección.
     */
    public int getNumero_exterior() {
        return numero_exterior;
    }

    /**
     * Establece el número exterior de la dirección.
     *
     * @param numero_exterior El número exterior de la dirección a establecer.
     */
    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    /**
     * Obtiene el número interior de la dirección.
     *
     * @return El número interior de la dirección.
     */
    public int getNumero_interior() {
        return numero_interior;
    }

    /**
     * Establece el número interior de la dirección.
     *
     * @param numero_interior El número interior de la dirección a establecer.
     */
    public void setNumero_interior(int numero_interior) {
        this.numero_interior = numero_interior;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return El código postal de la dirección.
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param codigo_postal El código postal de la dirección a establecer.
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtiene la colonia de la dirección.
     *
     * @return La colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección.
     *
     * @param colonia La colonia de la dirección a establecer.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

}
