package Exception;
/**
 * Excepcion lanzada cuando una klave es invalida.
 *
 */
public class InvalidKeyException extends Exception {
/**
 * Constructor de la excepcion 
 * @param msg mensaje de la excepcion.
 */
	public InvalidKeyException(String msg){
		super(msg);
	} 

}
