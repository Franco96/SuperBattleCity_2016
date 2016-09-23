package Exception;
/**
 * Excepcion lanzada cuando una lista esta vacia.
 *
 */
public class EmptyListException extends Exception {
	
	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion
	 */
	public EmptyListException(String msg){
		super(msg);
	}

}
