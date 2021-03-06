package TDALista;

import java.util.Iterator;

import Exception.*;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	
	protected NodoD<E> header;
	protected NodoD<E> trailer;
	protected int size;
	
	public ListaDoblementeEnlazada(){
		header = new NodoD<E>(null,null,null);
		trailer = new NodoD<E>(null,null,null);
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public int size(){return size;}
	
	public boolean isEmpty(){return size==0;}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("La Lista esta vacia.");
		return header.getNext();
	}
	
	public Position<E>  last() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("La Lista esta vacia.");
		return trailer.getPrev();
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		NodoD<E>n = checkPosition(p);
		if(n==header ||n== trailer ) throw new InvalidPositionException("Posicion Invalida.");
		if(n.getNext() == trailer) throw new BoundaryViolationException("No hay siguiente.");
		return n.getNext();
	}
	
	public Position<E>prev(Position<E>p) throws InvalidPositionException, BoundaryViolationException{
		NodoD<E>n=checkPosition(p);
		if(n==header ||n== trailer ) throw new InvalidPositionException("Posicion Invalida.");
		if(n.getPrev() == header) throw new BoundaryViolationException("No hay anterior.");
		return n.getPrev();
	}
	
	public void addFirst(E element){
		NodoD<E>nuevo= new NodoD<E>(element,header,header.getNext());
		header.getNext().setPrev(nuevo);
		header.setNext(nuevo);
		size++;
	}
	
	public void addLast(E element){
		NodoD<E>nuevo= new NodoD<E>(element,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		size++;
	}
	
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		NodoD<E> n = checkPosition(p);
		NodoD<E> q = n.getNext();
		NodoD<E> r = new NodoD<E>( element,n, q);
		n.setNext(r);
		q.setPrev(r);
		size++;
	}
	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException{
		NodoD<E>n=checkPosition(p);
		NodoD<E>q=n.getPrev();
		NodoD<E>nuevo=new NodoD<E>(element,q,n);
		q.setNext(nuevo);
		n.setPrev(nuevo);
		size++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		if(isEmpty())throw new InvalidPositionException("Lista vacia");
		NodoD<E> n = checkPosition(p);
		E item = n.element();
		NodoD<E> q = n.getPrev();
		NodoD<E> h = n.getNext();
		n.setPrev(null);
		n.setNext(null);
		n.setElement(null);
		q.setNext(h);
		h.setPrev(q);
		size--;
		return item;
	}
	
	public E set(Position<E> p, E element) throws InvalidPositionException{
		if(isEmpty())throw new InvalidPositionException("La lista esta vacia.");
		NodoD<E>n=checkPosition(p);
		E res=p.element();
		n.setElement(element);
		return res;
	}
	
	public Iterator<E> iterator(){
		Iterator<E>it= new ElementIterator<E>(this);
		return it;
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> lista=new ListaEnlazada<Position<E>>();
		try{
		if(!isEmpty()){
			Position<E>p= first();
			Position<E>ult= last();
			while(p!=ult){
				lista.addLast(p);
				p=next(p);
			}
			lista.addLast(p);
		}
		}catch( EmptyListException | BoundaryViolationException | InvalidPositionException e){System.out.println(e.getStackTrace());}
		return lista;

	}
	
	private NodoD<E> checkPosition(Position<E> p)
			throws InvalidPositionException {
		try {
			if (p == null)
				throw new InvalidPositionException("Posicion Nula.");
			NodoD<E> n = (NodoD<E>) p;
			if (n == header || n == trailer)
				throw new InvalidPositionException("Posicion Invalida.");
			return n;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Posicion No valida.");
		}
	}
}
