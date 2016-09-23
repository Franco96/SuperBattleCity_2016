package TDALista;

public class Nodo<E> implements Position<E> {
	 
	protected Nodo<E> sig;
	protected E elemento;
	
	public Nodo(Nodo<E>siguiente, E elemento){
		sig=siguiente;
		this.elemento=elemento;
	}
	
	public Nodo(E elemento){
		this(null,elemento);
	}
	
	public Nodo(){
		this(null,null);
	}
	
	public Nodo<E> getNext(){return sig;}
	
	public E element(){return elemento;}
	
	public void setElement(E elem){elemento=elem;}
	
	public void setNext(Nodo<E>sig){this.sig=sig;}

}
