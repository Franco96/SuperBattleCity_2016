package BattleCity;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import Exception.BoundaryViolationException;
import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
import TDALista.*;
import Tanques.*;

public class Batallon {
	protected PositionList<Enemigo> oponentes;
	protected int puntaje;
	protected int cant_enemigos_simultaneos;
	protected int lugar_de_colocacion;
	protected Rectangle [] rectangulos;
	protected Point [] posiciones;
	//atributo para detener a los enemigos
	protected boolean estaDetenido;
	protected int cantEnemigos;
	
  public Batallon(){
	  
	  estaDetenido = false;
	  puntaje = 0;
	  oponentes = new ListaDoblementeEnlazada<Enemigo>();
	  cant_enemigos_simultaneos=4;
	  lugar_de_colocacion=0;
	  cantEnemigos=10;
	  
	  posiciones=new Point[2];
	  posiciones[0]=new Point(0,0);
	  posiciones[1]=new Point(750,0);
	  
	  rectangulos = new Rectangle[2];
	  rectangulos[0]=new Rectangle(posiciones[0].x,posiciones[0].y,50,50);
	  rectangulos[1]=new Rectangle(posiciones[1].x,posiciones[1].y,50,50);
  } 
  
  //Agrega un oponente en alguna posicion designada valida disponible
  public void agregar_oponente(Gui gui,Mapa m){
	  try{
		  Enemigo nuevo =generarEnemigoRandom();
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
  
  private Enemigo generarEnemigoRandom(){
	  Enemigo nuevo=null;
	  Random r = new Random();
	  int eleccion = r.nextInt(4);
	  switch (eleccion) {
		case 0 : 
			nuevo= new EnemigoBasico(posiciones[lugar_de_colocacion].x,posiciones[lugar_de_colocacion].y);
			break;
		case 1 :
			nuevo= new EnemigoRapido(posiciones[lugar_de_colocacion].x,posiciones[lugar_de_colocacion].y);
			break;
		case 2 :
			nuevo= new EnemigoDePoder(posiciones[lugar_de_colocacion].x,posiciones[lugar_de_colocacion].y);
			break;
		case 3 :
			nuevo= new EnemigoBlindado(posiciones[lugar_de_colocacion].x,posiciones[lugar_de_colocacion].y);
			break;
	  }
	  return nuevo;
  }
  

  //MUEVE A TODOS LOS ENEMIGOS
  public void mover(Juego h){
		try {
		
		if(!estaDetenido)	
		{	
			if(!oponentes.isEmpty())
			{
			Position<Enemigo>p=oponentes.first(),u=oponentes.last();
			while(p!=null){
				
				p.element().movimiento(h);	
				
				if(p!=u)p=oponentes.next(p);else p=null;			
			}
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
  		
  	 if(!estaDetenido)	
  		
  	 { if(!oponentes.isEmpty())
  		{
  		Position<Enemigo>p=oponentes.first(),u=oponentes.last();
  		while(p!=null){
  			
  			p.element().disparar_bala(g,j,true);	
  			if (p!=null)p.element().update_bala();
  			
  			if(p!=u)p=oponentes.next(p);else p=null;  		  
  		}
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
	
  public void quitarOponente(Enemigo ene,Juego j){
		try{
			boolean encontre = false;
			if (!oponentes.isEmpty()){
				Position<Enemigo>p=oponentes.first(),u=oponentes.last();
				while(p!=null&&!encontre){
					if(p.element()==ene){
						cantEnemigos--;
						encontre = true;
						puntaje+=p.element().getPuntaje_por_Destruccion();						
						ene.getGrafico().setVisible(false);
						oponentes.remove(p);						
					}					
					if(p!=u)p=oponentes.next(p);else p=null;				
				}
				if(cantEnemigos==0){
					j.win();
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
  			   puntaje+=p.element().getPuntaje_por_Destruccion();		
  				p.element().getGrafico().setVisible(false); 
  				
  				
  			  Position<Enemigo> aux = null;
             if(p!=u)		
  			    aux = oponentes.next(p); 
  				 
                oponentes.remove(p);
  				
                 
  				
              p = aux;		
  			}
  			
  		}catch(EmptyListException e)
  	{
  			
  	}catch(BoundaryViolationException e)
  	{
  		
  	}catch(InvalidPositionException e)
  	{
  		
  	}  
}
  
  
 //SETEA EL ESTA DETENIDO PARA PARAR A LOS ENEMIGOS CUANDO SE AGARRA EL POWER TIME
  
  public void setEstaDetenido(boolean esta)
  {
	  this.estaDetenido = esta;
  }
  
  
  
  public boolean getEstaDetenido()
  {
	  return this.estaDetenido;
  }
  
}
