/*
 * SinCuenta.java
 */
package org.itson.bdavanzadas.dominio;

/**
 *
 * Clase que representa la entidad SinCuenta
 */
public class SinCuenta {

    private int id_transaccion;
    private String estado;
    private int folio;
    private String contrasenia;

    /**
     * Constructor por defecto de la clase SinCuenta. Crea un nuevo objeto
     * SinCuenta con valores predeterminados para todos los campos.
     */
    public SinCuenta() {
    }

    /**
     * Constructor de la clase SinCuenta que inicializa todos los campos.
     *
     * @param id_transaccion El ID de la transacción.
     * @param estado El estado de la transacción.
     * @param folio El folio de la transacción.
     * @param contrasenia La contraseña asociada a la transacción.
     */
    public SinCuenta(int id_transaccion, String estado, int folio, String contrasenia) {
        this.id_transaccion = id_transaccion;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor de la clase SinCuenta que inicializa algunos campos. No
     * incluye el ID de la transacción.
     *
     * @param estado El estado de la transacción.
     * @param folio El folio de la transacción.
     * @param contrasenia La contraseña asociada a la transacción.
     */
    public SinCuenta(String estado, int folio, String contrasenia) {
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    /**
     * Devuelve el ID de la transacción.
     *
     * @return El ID de la transacción.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Establece el ID de la transacción.
     *
     * @param id_transaccion El nuevo ID de la transacción.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Devuelve el estado de la transacción.
     *
     * @return El estado de la transacción.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la transacción.
     *
     * @param estado El nuevo estado de la transacción.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el folio de la transacción.
     *
     * @return El folio de la transacción.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la transacción.
     *
     * @param folio El nuevo folio de la transacción.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Devuelve la contraseña asociada a la transacción.
     *
     * @return La contraseña asociada a la transacción.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña asociada a la transacción.
     *
     * @param contrasenia La nueva contraseña asociada a la transacción.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Devuelve un valor hash para este objeto.
     *
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id_transaccion;
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
        final SinCuenta other = (SinCuenta) obj;
        return this.id_transaccion == other.id_transaccion;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información de la transacción sin
     * cuenta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinCuenta{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", estado=").append(estado);
        sb.append(", folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append('}');
        return sb.toString();
    }

}
