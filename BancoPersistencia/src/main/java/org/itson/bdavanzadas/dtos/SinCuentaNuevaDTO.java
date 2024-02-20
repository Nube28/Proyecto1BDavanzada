/**
 * SinCuentaNuevaDTO.java
 */
package org.itson.bdavanzadas.dtos;

/**
 * DTO que representa una nueva transacción sin cuenta asociada.
 */
public class SinCuentaNuevaDTO {

    private int id_transaccion;
    private String estado;
    private int folio;
    private int contrasenia;

    /**
     * Obtiene el estado de la transacción sin cuenta asociada.
     *
     * @return El estado de la transacción sin cuenta asociada.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la transacción sin cuenta asociada.
     *
     * @param estado El estado de la transacción sin cuenta asociada a
     * establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el folio de la transacción sin cuenta asociada.
     *
     * @return El folio de la transacción sin cuenta asociada.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la transacción sin cuenta asociada.
     *
     * @param folio El folio de la transacción sin cuenta asociada a establecer.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la contraseña de la transacción sin cuenta asociada.
     *
     * @return La contraseña de la transacción sin cuenta asociada.
     */
    public int getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña de la transacción sin cuenta asociada.
     *
     * @param contrasenia La contraseña de la transacción sin cuenta asociada a
     * establecer.
     */
    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID de la transacción sin cuenta asociada.
     *
     * @return El ID de la transacción sin cuenta asociada.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Establece el ID de la transacción sin cuenta asociada.
     *
     * @param id_transaccion El ID de la transacción sin cuenta asociada a
     * establecer.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

}
