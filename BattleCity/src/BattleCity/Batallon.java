package BattleCity;

<<<<<<< HEAD
import java.awt.Rectangle;

import Celdas.Celda;
=======
import java.util.Random;

>>>>>>> origin/master
import Exception.BoundaryViolationException;
import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
<<<<<<< HEAD
import TDALista.*;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;

public class Batallon {
	
	private  PositionList<Enemigo> oponentes;
	private int puntaje;

	
  public Batallon()
  {
	  puntaje = 0;
	oponentes = new ListaDoblementeEnlazada<Enemigo>();
  }
  
  
  
  public void agregarOponente(Gui gui){
		try{
			oponentes.addLast(new EnemigoBasico(0, 0));
			gui.add(oponentes.last().element().getGrafico());
			gui.revalidate();
			gui.repaint();
		   }
=======
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;

public class Batallon {
	protected PositionList<Enemigo> oponentes;
	protected int puntos_por_muertes_de_enemigos;
	
	public Batallon(){
		oponentes= new ListaDoblementeEnlazada<Enemigo>();
		puntos_por_muertes_de_enemigos=0;
	}
	
	//Agrega enemigos a la lista de enemigos
	public void agregarOponente(Gui gui){
		try{
			Random r = new Random();
			oponentes.addLast(new EnemigoBasico(r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32)));
			gui.add(oponentes.last().element().getGrafico(),0);
			gui.revalidate();
			gui.repaint();
		}
>>>>>>> origin/master
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
<<<<<<< HEAD
  
  
  
  public void quitarOponente(Gui gui){
		try{
			if (!oponentes.isEmpty()){
				Position<Enemigo> p=oponentes.last();
				puntaje+=p.element().getPuntaje_por_Destruccion();
=======
	
	//Elimina enemigo de la lista de enemigos
	public void quitarOponente(Gui gui){
		try{
			if (!oponentes.isEmpty()){
				Position<Enemigo> p=oponentes.last();
				puntos_por_muertes_de_enemigos+=p.element().getPuntaje_por_Destruccion();
>>>>>>> origin/master
				gui.remove(oponentes.last().element().getGrafico());
				gui.revalidate();
				gui.repaint();
				oponentes.remove(p);
			}		
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
<<<<<<< HEAD
  
  
  
  
  public void mover(Juego h){
=======
	
	//Retorna puntos acumulados por muertes de enemigos
	public int puntos_acumulados(){
		return puntos_por_muertes_de_enemigos;
	}
	
	public void mover(){
>>>>>>> origin/master
		try {
			if(!oponentes.isEmpty())
			{
			Position<Enemigo>p=oponentes.first(),u=oponentes.last();
			while(p!=null){
<<<<<<< HEAD
				
				p.element().mover(0,h);	
				
=======
				p.element().mover(0);			
>>>>>>> origin/master
				if(p!=u)p=oponentes.next(p);else p=null;			
			}
			}
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (BoundaryViolationException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
<<<<<<< HEAD
	} 
  
  

  public void generar_disparo_enemigo(Gui g,Juego j)
  {
  	try {
  		if(!oponentes.isEmpty())
  		{
  		Position<Enemigo>p=oponentes.first(),u=oponentes.last();
  		while(p!=null){
  			
  			p.element().disparar_bala(g,j,true);	
  			 p.element().update_bala();
  			
  			 if(p!=u)p=oponentes.next(p);else p=null;			
  		
  		  
  		}
  		}
  	}
  	catch (InvalidPositionException e){
  		System.out.println(e.getMessage());
  	}
  	catch (BoundaryViolationException e){
  		System.out.println(e.getMessage());
  	}
  	catch (EmptyListException e){
  		System.out.println(e.getMessage());
  	}
  	
  }

  
  
  public boolean ColisionaConOponente(Rectangle recBala,Element elemento)
  {
  	boolean choca = false;
  	try {
  		if(!oponentes.isEmpty())
  		{
  		Position<Enemigo>p=oponentes.first(),u=oponentes.last();
  		while(p!=null&&!choca){
  			
  		    if(p.element()!=elemento)
  			{choca = p.element().getGrafico().getBounds().intersects(recBala);
  			}
  			if(choca)
  			{
  				choca = elemento.aceptar(p.element());
  			}
  			
  			 if(p!=u)p=oponentes.next(p);else p=null;			
  		
  		  
  		}
  		}
  	}
  	catch (InvalidPositionException e){
  		System.out.println(e.getMessage());
  	}
  	catch (BoundaryViolationException e){
  		System.out.println(e.getMessage());
  	}
  	catch (EmptyListException e){
  		System.out.println(e.getMessage());
  	}
  	
  	
  	return choca;
  	
  }
  
  
  
  
  public int getPuntaje(){
		return puntaje;
	}
  
	
	
  public void quitarOponente(Enemigo ene){
		try{
			if (!oponentes.isEmpty()){
				Position<Enemigo>p=oponentes.first(),u=oponentes.last();
				while(p!=null){
					if(p.element()==ene)
					{
						puntaje+=p.element().getPuntaje_por_Destruccion();
						
						ene.getGrafico().setVisible(false);
						oponentes.remove(p);
						
					}
					
					if(p!=u)p=oponentes.next(p);else p=null;			
				
				
				}
				
			}		
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}catch(BoundaryViolationException e)
		{
			
		}
	}
  
  public void eliminarEnemigos(Gui g)
  {
  	
  	try {
  		Position<Enemigo>p=oponentes.first(),u=oponentes.last();
  		while(p!=null){
  			
  			
  				g.remove(p.element().getGrafico());
  				
  				
  				if(p!=u)p=oponentes.next(p);else p=null;
  			
  			}
  			
  		}catch(EmptyListException e)
  	{
  			
  	}catch(BoundaryViolationException e)
  	{
  		
  	}catch(InvalidPositionException e)
  	{
  		
  	}
  
  
  
  
}
=======
	}
>>>>>>> origin/master
}