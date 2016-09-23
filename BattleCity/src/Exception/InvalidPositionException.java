package Exception;
/**
 * Excepcion lanzada cuando una posicion es invalida.
 *
 */
public class InvalidPositionException extends Exception {
	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion.
	 */
	public InvalidPositionException(String msg){
		super(msg);
	}

}
