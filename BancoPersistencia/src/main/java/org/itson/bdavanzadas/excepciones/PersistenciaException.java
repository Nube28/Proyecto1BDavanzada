package org.itson.bdavanzadas.excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia
 * de datos.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por omision
     */
    public PersistenciaException() {
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje
     * detallado.
     *
     * @param message el mensaje detallado de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje
     * detallado y la causa subyacente.
     *
     * @param message el mensaje detallado de la excepción.
     * @param cause la causa subyacente de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con la causa
     * subyacente.
     *
     * @param cause la causa subyacente de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje
     * detallado, la causa subyacente, habilitación opcional de supresión y
     * habilitación opcional de rastreo de pila.
     *
     * @param message el mensaje detallado de la excepción.
     * @param cause la causa subyacente de la excepción.
     * @param enableSuppression indica si la supresión de la excepción está
     * habilitada o no.
     * @param writableStackTrace indica si se debe mantener el rastreo de la
     * pila.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
