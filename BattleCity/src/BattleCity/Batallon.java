package BattleCity;

import java.awt.Point;
import java.awt.Rectangle;
import Exception.BoundaryViolationException;
import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
import TDALista.*;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;

public class Batallon {
	protected PositionList<Enemigo> oponentes;
	protected int puntaje;
	protected int cant_enemigos_simultaneos;
	protected int lugar_de_colocacion;
	protected Rectangle [] rectangulos;
	protected Point [] posiciones;
	
  public Batallon(){
	  puntaje = 0;
	  oponentes = new ListaDoblementeEnlazada<Enemigo>();
	  cant_enemigos_simultaneos=4;
	  lugar_de_colocacion=0;
	  
	  posiciones=new Point[2];
	  posiciones[0]=new Point(0,0);
	  posiciones[1]=new Point(750,0);
	  
	  rectangulos = new Rectangle[2];
	  rectangulos[0]=new Rectangle(posiciones[0].x,posiciones[0].y,50,50);
	  rectangulos[1]=new Rectangle(posiciones[1].x,posiciones[1].y,50,50);
  } 
  
//  public void agregarOponente(Gui gui){
//		try{
//			oponentes.addLast(new EnemigoBasico(0, 0));
//			gui.add(oponentes.last().element().getGrafico());
//			gui.revalidate();
//			gui.repaint();
//		   }
//		catch (EmptyListException e){
//			System.out.println(e.getMessage());
//		}
//	} 
  
  //Agrega un oponente en alguna posicion designada valida disponible
  public void agregar_oponente(Gui gui,Mapa m){
	  try{
		  EnemigoBasico nuevo= new EnemigoBasico(posiciones[lugar_de_colocacion].x,posiciones[lugar_de_colocacion].y);
		  if (oponentes.size()<cant_enemigos_simultaneos && !m.si_colisiona(rectangulos[lugar_de_colocacion], nuevo) && !ColisionaConOponente(rectangulos[lugar_de_colocacion], nuevo)){
			  oponentes.addLast(nuevo);
			  gui.add(oponentes.last().element().getGrafico());
			  gui.revalidate();
			  gui.repaint();
		  }
		  switch (lugar_de_colocacion) {
			case 0 : 
				lugar_de_colocacion=1;
				break;
			case 1 :
				lugar_de_colocacion=0;
				break;
		  }
		  }
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
  }
  
  public void quitarOponente(Gui gui){
		try{
			if (!oponentes.isEmpty()){
				Position<Enemigo> p=oponentes.last();
				puntaje+=p.element().getPuntaje_por_Destruccion();
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
  
  //MUEVE A TODOS LOS ENEMIGOS
  public void mover(Juego h){
		try {
			if(!oponentes.isEmpty())
			{
			Position<Enemigo>p=oponentes.first(),u=oponentes.last();
			while(p!=null){
				
				p.element().movimiento(h);	
				
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

  public void generar_disparo_enemigo(Gui g,Juego j){
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
  
  
  public boolean ColisionaConOponente(Rectangle recBala,Element elemento){
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
					if(p.element()==ene){
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
  
  
  public void eliminarEnemigos(Gui g){  	
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
}
