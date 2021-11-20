package Exceptions;

/**
 * Clase que maneja las excepciones de las clases DAO
 *
 * @author 
 */
public class DAOException extends Exception {

    /**
     * Constructor por omision
     */
    public DAOException() {
    }

    /**
     * Constructor que maneja una excepcion DAO
     *
     * @param string Recibe una cadena de la excepcion
     */
    public DAOException(String string) {
        super(string);
    }

    /**
     * Constructor que maneja una excepcion DAO
     *
     * @param string Recibe una cadena de la excepcion
     * @param thrwbl Recibe un throwable de la excepcion
     */
    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Constructor que maneja una excepcion DAO
     *
     * @param thrwbl Recibe un throwable de la excepcion
     */
    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }

}
