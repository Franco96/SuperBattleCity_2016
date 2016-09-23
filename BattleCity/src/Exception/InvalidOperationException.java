package Exception;
/**
 * Excepcion lanzada cuando una operacion es invalida.
 *
 */
public class InvalidOperationException extends Exception {

	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion
	 */
	public InvalidOperationException(String msg){
		super(msg);
	}

}
