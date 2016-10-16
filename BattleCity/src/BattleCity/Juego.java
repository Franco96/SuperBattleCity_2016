package BattleCity;

import GUI.Gui;
import Mapa.*;

public class Juego  implements Runnable {
	//ATRIBUTOS
	
	protected Batallon batallon_de_enemigos;
	protected Jugador jugador;
	protected Mapa m;
	protected int puntaje;
	protected boolean game_over=false;
	
    //CONSTRUCTOR
public Juego(Gui gui){
	batallon_de_enemigos=new Batallon();
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
	batallon_de_enemigos.agregarOponente(gui);
}

public void quitarOponente(Gui gui){
	batallon_de_enemigos.quitarOponente(gui);
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
			batallon_de_enemigos.mover();
			jugador.update_bala();
			Thread.sleep(500);			
		}
		catch (InterruptedException e){
			//Vacio
		}
	}	
}
}