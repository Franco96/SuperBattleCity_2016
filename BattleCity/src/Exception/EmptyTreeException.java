package Exception;
/**
 * Excepcion lanzada cuando un arbol esta vacio. 
 *
 */
public class EmptyTreeException extends Exception {
	/**
	 *Constructor de la excepcion 
	 * @param msg mensaje de la excepcion 
	 */
	public EmptyTreeException(String msg){
		super(msg);
	}
}
