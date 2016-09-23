package TDALista;

import java.util.Iterator;

import Exception.*;

public class ListaEnlazada<E> implements PositionList<E>  {
	
	protected Nodo<E>head;
	protected int cant;
	
	public ListaEnlazada(){
		head=null;
		cant=0;
	}
	
	public E set(Position<E> p, E element) throws InvalidPositionException{
		if(isEmpty())throw new InvalidPositionException("La lista esta vacia.");
		Nodo<E>n=checkPosition(p);
		E res=p.element();
		n.setElement(element);
		return res;
	}
	
	public int size(){return cant;}
	
	public boolean isEmpty(){return head==null;}
	
	public Position<E> first()throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("Lista vacia.");
		else{
			return head;
		}
	}

	public Position<E> last()throws EmptyListException{
		if(isEmpty())throw new EmptyListException("Lista vacia");
		else{
			Nodo<E>p=head;
			while(p.getNext()!=null)
				p=p.getNext();
			return p;
		}
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> n= checkPosition(p);
		if(n.getNext()==null)throw new BoundaryViolationException("No hay elemento siguiente.");
		return n.getNext();
	}
	
	public Position<E> prev(Position<E>p)  throws InvalidPositionException, BoundaryViolationException{
		try{
		if(p==first()) throw new BoundaryViolationException("La lista no tiene anterior.");
		}catch(EmptyListException e){System.out.println(e.getStackTrace());}
		Nodo<E>n=checkPosition(p);
		Nodo<E>marca=head;
		while(marca.getNext()!=n && marca.getNext()!=null)
			marca=marca.getNext();
		if(marca.getNext()==null)throw new InvalidPositionException("La posicion es invalida.");
		return marca;
	}
	
	public void addFirst(E element){
		Nodo<E>nuevo= new Nodo<E>(element);
		nuevo.setNext(head);
		head=nuevo;
		cant++;
	}
	
	public void addLast(E element){
		if(isEmpty()) addFirst(element);
		else{
			Nodo<E>marca= head;
			while(marca.getNext()!=null)
				marca=marca.getNext();
			marca.setNext(new Nodo<E>(element));
			cant++;
		}
	}
	
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E>n=checkPosition(p);
		Nodo<E>nuevo=new Nodo<E>(element);
		nuevo.setNext(n.getNext());
		n.setNext(nuevo);
		cant++;
	}
	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E>n=checkPosition(p);
		Nodo<E>nuevo=new Nodo<E>(element);
		if(p==head)addFirst(element);
		else{
			try{
			Nodo<E>anterior= (Nodo<E>)prev(p);
			nuevo.setNext(n);
			anterior.setNext(nuevo);
			cant++;}catch(BoundaryViolationException e){System.out.println(e.getStackTrace());}
		}
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		if(isEmpty())throw new InvalidPositionException("Posicion Invalida.");
		Nodo<E>n=checkPosition(p);
		E res=p.element();
		if(p==head) head=head.getNext();
		else{
			try{
			Nodo<E>anterior=(Nodo<E>) prev(p);
			anterior.setNext(n.getNext());
			}catch(BoundaryViolationException e){System.out.println(e.getStackTrace());}
		}
		cant--;
		return res;
	}
	
	public Iterator<E> iterator(){ 
		return new ElementIterator<E>(this);
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
	
	private Nodo<E> checkPosition(Position<E>p )throws InvalidPositionException{
		try{
			if(p==null) throw new InvalidPositionException("Posicion Invalidad");
			return (Nodo<E>)p;
		}catch(ClassCastException e){throw new InvalidPositionException("CheckPosition Casting Imposible.");}
	}
}
