/*
 * Transferencia.java
 */
package org.itson.bdavanzadas.dominio;

/**
 *  Clase que representa la entidad Transferencia
 * 
 */
public class Transferencia {

    private int id_transaccion;
    private int cuenta_destino;

    /**
     * Constructor por defecto de la clase Transferencia. Crea un nuevo objeto
     * Transferencia con valores predeterminados para todos los campos.
     */
    public Transferencia() {
    }

    /**
     * Constructor de la clase Transferencia que inicializa los campos
     * id_transaccion y cuenta_destino.
     *
     * @param id_transaccion El ID de la transacción.
     * @param cuenta_destino El número de la cuenta destino de la transferencia.
     */
    public Transferencia(int id_transaccion, int cuenta_destino) {
        this.id_transaccion = id_transaccion;
        this.cuenta_destino = cuenta_destino;
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
     * Devuelve el número de la cuenta destino de la transferencia.
     *
     * @return El número de la cuenta destino de la transferencia.
     */
    public int getCuenta_destino() {
        return cuenta_destino;
    }

    /**
     * Establece el número de la cuenta destino de la transferencia.
     *
     * @param cuenta_destino El nuevo número de la cuenta destino de la
     * transferencia.
     */
    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    /**
     * Devuelve un valor hash para este objeto.
     *
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_transaccion;
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
        final Transferencia other = (Transferencia) obj;
        return this.id_transaccion == other.id_transaccion;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información de la transferencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", cuenta_destino=").append(cuenta_destino);
        sb.append('}');
        return sb.toString();
    }

}
