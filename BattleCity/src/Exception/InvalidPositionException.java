package Exception;
/**
 * Excepcion lanzada cuando una posicion es invalida.
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion.
	 */
	public InvalidPositionException(String msg){
		super(msg);
	}

}
