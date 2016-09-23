package Exception;
/**
 * Excepcion lanzada cuando una variable no existe.
 *
 */
public class NoSuchVariableException extends Exception{
	/**
	 * Constructor de la excepcion.
	 * @param msg mensaje de la excepcion.
	 */
	public NoSuchVariableException(String msg){
		super(msg);
	}

}
