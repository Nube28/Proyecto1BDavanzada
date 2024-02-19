/**
 * Domicilio.java
 */
package org.itson.bdavanzadas.dominio;

import java.util.Objects;

/**
 * Clase que representa la entidad Domicilio
 *
 */
public class Domicilio {

    private int id_domicilio;
    private String calle;
    private int numero_exterior;
    private int numero_interioro;
    private String codigo_postal;
    private String colonia;

    /**
     * Constructor por defecto de la clase Domicilio. Crea un nuevo objeto
     * Domicilio con valores predeterminados para todos los campos.
     */
    public Domicilio() {
    }

    /**
     * Constructor de la clase Domicilio que inicializa todos los campos.
     *
     * @param id_domicilio El ID del domicilio.
     * @param calle El nombre de la calle.
     * @param numero_exterior El número exterior.
     * @param numero_interioro El número interior.
     * @param codigo_postal El código postal.
     * @param colonia La colonia.
     */
    public Domicilio(int id_domicilio, String calle, int numero_exterior, int numero_interioro, String codigo_postal, String colonia) {
        this.id_domicilio = id_domicilio;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interioro = numero_interioro;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }

    /**
     * Constructor de la clase Domicilio que inicializa algunos campos. No
     * incluye el ID del domicilio.
     *
     * @param calle El nombre de la calle.
     * @param numero_exterior El número exterior.
     * @param numero_interioro El número interior.
     * @param codigo_postal El código postal.
     * @param colonia La colonia.
     */
    public Domicilio(String calle, int numero_exterior, int numero_interioro, String codigo_postal, String colonia) {
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interioro = numero_interioro;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }

    /**
     * Devuelve el ID del domicilio.
     *
     * @return El ID del domicilio.
     */
    public int getId_domicilio() {
        return id_domicilio;
    }

    /**
     * Establece el ID del domicilio.
     *
     * @param id_domicilio El nuevo ID del domicilio.
     */
    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    /**
     * Devuelve el nombre de la calle.
     *
     * @return El nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle.
     *
     * @param calle El nuevo nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Devuelve el número exterior.
     *
     * @return El número exterior.
     */
    public int getNumero_exterior() {
        return numero_exterior;
    }

    /**
     * Establece el número exterior.
     *
     * @param numero_exterior El nuevo número exterior.
     */
    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    /**
     * Devuelve el número interior.
     *
     * @return El número interior.
     */
    public int getNumero_interioro() {
        return numero_interioro;
    }

    /**
     * Establece el número interior.
     *
     * @param numero_interioro El nuevo número interior.
     */
    public void setNumero_interioro(int numero_interioro) {
        this.numero_interioro = numero_interioro;
    }

    /**
     * Devuelve el código postal.
     *
     * @return El código postal.
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal.
     *
     * @param codigo_postal El nuevo código postal.
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Devuelve la colonia.
     *
     * @return La colonia.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia.
     *
     * @param colonia La nueva colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Devuelve un valor hash para este objeto.
     *
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_domicilio;
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
        final Domicilio other = (Domicilio) obj;
        return this.id_domicilio == other.id_domicilio;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información del domicilio.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domicilio{");
        sb.append("id_domicilio=").append(id_domicilio);
        sb.append(", calle=").append(calle);
        sb.append(", numero_exterior=").append(numero_exterior);
        sb.append(", numero_interioro=").append(numero_interioro);
        sb.append(", codigo_postal=").append(codigo_postal);
        sb.append(", colonia=").append(colonia);
        sb.append('}');
        return sb.toString();
    }

}
