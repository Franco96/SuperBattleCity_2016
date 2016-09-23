package Exception;
/**
 * Excepcion lanzada cuando una cola con prioridad esta vacia.
 *
 */
public class EmptyPriorityQueueException extends Exception {
	
/**
 * Constructor de la excepcion 
 * @param msg mensaje de la excepcion
 */
	public EmptyPriorityQueueException(String msg){
		super(msg);
	}

}
