package Exception;
/**
 * Excepcion lanzada cuando una extructura se cae del limite.
 * 
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	
	/**
	 * Constructor de la excepcion
	 * @param msg mensaje de la excepcion
	 */
	public BoundaryViolationException(String msg){
		super(msg);
	}

}
