package Exception;

/**
 * Excepcion lanzada cuando una cola esta vacia.
 *
 */
public class EmptyQueueException extends Exception {
	/**
	 * Constructor de la excepcion.
	 * @param msg mensaje de la excepcion.
	 */
	public EmptyQueueException (String msg){
		super(msg);
	}
}
