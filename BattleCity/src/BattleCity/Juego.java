package BattleCity;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;
import GUI.Gui;
import TDALista.*;
import Exception.*;


public class Juego  implements Runnable {
	//ATRIBUTOS
	
	PositionList<Enemigo> oponentes;
	protected Jugador jugador;
	protected Mapa m;
	protected int puntaje;
	protected boolean game_over=false;
	
    //CONSTRUCTOR
public Juego(Gui gui){
	oponentes= new ListaDoblementeEnlazada<Enemigo>();
	puntaje=0;
	jugador = new Jugador(400,400);
	m = new Mapa();
	m.armarMapa(gui);	
	gui.add(jugador.getGrafico());	
	m.armarMapa(gui);     
}

public int getPuntaje(){
	return puntaje;
}

public void agregarOponente(Gui gui){
	try{
		Random r = new Random();
		oponentes.addLast(new EnemigoBasico(r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32)));
		gui.add(oponentes.last().element().getGrafico(),0);
		gui.revalidate();
		gui.repaint();
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

//MOVER DE ENEMIGO
public void mover(){
	try {
		if(!oponentes.isEmpty())
		{
		Position<Enemigo>p=oponentes.first(),u=oponentes.last();
		while(p!=null){
			p.element().mover(0);			
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

//MOVER DE JUGADOR

public void mover(int dir){		
	int direccion = 0;
	Rectangle proximo_movimiento=null; 
	switch (dir){
		case KeyEvent.VK_UP : //Arriba
			proximo_movimiento=new Rectangle(jugador.getPos().x,jugador.getPos().y-jugador.getVelocidad(),jugador.getAncho(),jugador.getAlto());
			direccion = 0;			  
			break;
		case KeyEvent.VK_DOWN ://Abajo
			proximo_movimiento=new Rectangle(jugador.getPos().x,jugador.getPos().y+jugador.getVelocidad(),jugador.getAncho(),jugador.getAlto());
			direccion = 1;			 
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			proximo_movimiento=new Rectangle(jugador.getPos().x-jugador.getVelocidad(),jugador.getPos().y,jugador.getAncho(),jugador.getAlto());
			direccion = 2;			
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			proximo_movimiento=new Rectangle(jugador.getPos().x+jugador.getVelocidad(),jugador.getPos().y,jugador.getAncho(),jugador.getAlto());
			direccion = 3;			  
			break;
	}
	//Verificar si colisiona con algun bloque del mapa
		if (!m.si_colisiona(proximo_movimiento)){
			jugador.mover(direccion);
		}	
}

public void eliminar_pared(){
	m.remover_pared();
}

public void cambiar_estado_jugador(){
	jugador.subirNivel();
}

public void reset_estado_jugador(){
	jugador.resetNivel();
}

public void generar_disparo_jugador(Gui g){
	jugador.disparar_bala(g,m);
	
}
public void run(){
	while(!game_over){
		try{
			mover();
			jugador.update_bala();
			Thread.sleep(500);			
		}
		catch (InterruptedException e){
			//Vacio
		}
	}	
}
}