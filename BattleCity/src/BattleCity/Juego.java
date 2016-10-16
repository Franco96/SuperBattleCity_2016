package BattleCity;

import java.util.Random;
import GUI.Gui;
import TDALista.*;
import Exception.*;
import Mapa.*;

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


//Movimiento del jugador en direccion pasada por parametro
public void mover(int dir){		
	jugador.movimiento(jugador.convertir_keyEvent_a_direccionLocal(dir), m);	
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