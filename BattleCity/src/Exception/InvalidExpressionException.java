package Exception;
/**
 * Excepcion lanzada cuando una expresion es invalida.
 *
 */
public class InvalidExpressionException extends Exception {
	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion
	 */
	public InvalidExpressionException(String msg){
		super(msg);
	}

}
