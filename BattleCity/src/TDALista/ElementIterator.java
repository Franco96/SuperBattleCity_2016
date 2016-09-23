package TDALista;

import Exception.*;
import java.lang.*;
import java.util.*;

public class ElementIterator<E> implements Iterator<E> {

	protected PositionList<E>list;
	protected Position<E>cursor;
	
	public ElementIterator(PositionList<E>l){
		list=l;
		if (list.isEmpty()) cursor=null;
		else {
			try{cursor=list.first();
			}catch(EmptyListException e){System.out.println("Lista vacia.");}
			}
	}
	
	public boolean hasNext(){return cursor!=null;}
	
	public E next()throws NoSuchElementException{
		if(cursor==null) throw new NoSuchElementException("No tiene siguiente.");
		E res= cursor.element();
		try{
		cursor=(cursor==list.last())? null : list.next(cursor);
		}catch(InvalidPositionException e){System.out.println("Posicion Invalida.");}
		 catch(BoundaryViolationException e){System.out.println("No hay siguiente.");}
		 catch(EmptyListException e){System.out.println("Lista vacia.");}
		return res;
	}
}
