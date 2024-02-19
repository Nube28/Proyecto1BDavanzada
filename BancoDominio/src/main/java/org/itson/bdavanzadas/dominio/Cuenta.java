/**
 *  Cuenta.java
 */
package org.itson.bdavanzadas.dominio;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa la entidad Cuenta
 *
 */
public class Cuenta {

    private int id_cuenta;
    private String fecha_apertura;
    private int numero;
    private float saldo;
    private int id_cliente;
    private boolean esta_activo;

    /**
     * Constructor de la clase Cuenta que inicializa todos los campos.
     *
     * @param id_cuenta El ID de la cuenta.
     * @param fecha_apertura La fecha de apertura de la cuenta.
     * @param numero El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param id_cliente El ID del cliente asociado a la cuenta.
     * @param esta_activo Indica si la cuenta está activa o no.
     */
    public Cuenta(int id_cuenta, String fecha_apertura, int numero, float saldo, int id_cliente, boolean esta_activo) {
        this.id_cuenta = id_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.numero = numero;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.esta_activo = esta_activo;
    }

    /**
     * Constructor de la clase Cuenta que inicializa todos los campos excepto la
     * fecha de apertura. Útil para casos donde la fecha de apertura no es
     * necesaria al crear una nueva cuenta.
     *
     * @param id_cuenta El ID de la cuenta.
     * @param numero El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param id_cliente El ID del cliente asociado a la cuenta.
     * @param esta_activo Indica si la cuenta está activa o no.
     */
    public Cuenta(int id_cuenta, int numero, float saldo, int id_cliente, boolean esta_activo) {
        this.id_cuenta = id_cuenta;
        this.numero = numero;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.esta_activo = esta_activo;
    }

    /**
     * Constructor de la clase Cuenta que inicializa todos los campos excepto el
     * ID de la cuenta y la fecha de apertura. Útil para casos donde la fecha de
     * apertura y el ID de la cuenta no son necesarios al crear una nueva
     * cuenta.
     *
     * @param numero El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param id_cliente El ID del cliente asociado a la cuenta.
     * @param esta_activo Indica si la cuenta está activa o no.
     */
    public Cuenta(int numero, float saldo, int id_cliente, boolean esta_activo) {
        this.numero = numero;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.esta_activo = esta_activo;
    }

    /**
     * Constructor por defecto de la clase Cuenta. Crea un nuevo objeto Cuenta
     * con valores predeterminados para todos los campos.
     */
    public Cuenta() {
    }

    /**
     * Devuelve el ID de la cuenta.
     *
     * @return El ID de la cuenta.
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * Establece el ID de la cuenta.
     *
     * @param id_cuenta El nuevo ID de la cuenta.
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    /**
     * Devuelve la fecha de apertura de la cuenta.
     *
     * @return La fecha de apertura de la cuenta.
     */
    public String getFecha_apertura() {
        return fecha_apertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     *
     * @param fecha_apertura La nueva fecha de apertura de la cuenta.
     */
    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    /**
     * Devuelve el número de la cuenta.
     *
     * @return El número de la cuenta.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la cuenta.
     *
     * @param numero El nuevo número de la cuenta.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el saldo de la cuenta.
     *
     * @return El saldo de la cuenta.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     *
     * @param saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve el ID del cliente asociado a la cuenta.
     *
     * @return El ID del cliente asociado a la cuenta.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el ID del cliente asociado a la cuenta.
     *
     * @param id_cliente El nuevo ID del cliente asociado a la cuenta.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Devuelve true si la cuenta está activa, false de lo contrario.
     *
     * @return true si la cuenta está activa, false de lo contrario.
     */
    public boolean isEsta_activo() {
        return esta_activo;
    }

    /**
     * Establece el estado de activación de la cuenta.
     *
     * @param esta_activo true si la cuenta está activa, false de lo contrario.
     */
    public void setEsta_activo(boolean esta_activo) {
        this.esta_activo = esta_activo;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto.
     *
     * @return Una cadena que contiene la información de la cuenta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id_cuenta=").append(id_cuenta);
        sb.append(", fecha_apertura=").append(fecha_apertura);
        sb.append(", numero=").append(numero);
        sb.append(", saldo=").append(saldo);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append(", esta_activo=").append(esta_activo);
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
        int hash = 3;
        hash = 97 * hash + this.id_cuenta;
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
        final Cuenta other = (Cuenta) obj;
        return this.id_cuenta == other.id_cuenta;
    }

}
