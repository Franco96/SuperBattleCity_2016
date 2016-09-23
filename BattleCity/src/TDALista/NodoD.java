package TDALista;

public class NodoD<E> implements Position<E> {
	
	protected E elemento;
	protected NodoD<E>ant;
	protected NodoD<E>sig;
	
	public NodoD(E elemento,NodoD<E>ant,NodoD<E>sig){
		this.elemento=elemento;
		this.ant=ant;
		this.sig=sig;
	}
	
	public NodoD(E elemento){
		this(elemento,null,null);
	}
	
	public NodoD(){
		this(null,null,null);
	}
	
	public E element(){return elemento;}
	
	public NodoD<E> getNext(){return sig;}
	
	public NodoD<E> getPrev(){return ant;}
	
	public void setNext(NodoD<E> next){
		sig = next;
	}
	
	public void setPrev(NodoD<E> prev){
		ant = prev;
	}
	
	public void setElement(E element){elemento=element;}
	

}
