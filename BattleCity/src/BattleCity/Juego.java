package BattleCity;

<<<<<<< HEAD

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Gui;
import TDALista.*;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;
import Exception.*;
=======
import GUI.Gui;
import Mapa.*;
>>>>>>> origin/master






public class Juego  {
	//ATRIBUTOS
<<<<<<< HEAD

	private Batallon enemigos;

	protected Batallon batallon_de_enemigos;

=======
	
	protected Batallon batallon_de_enemigos;
>>>>>>> origin/master
	protected Jugador jugador;
	
	protected Mapa m;

    

    
	int anteriorMovido;
    
	Gui copia;
	
	protected int puntaje;
<<<<<<< HEAD
	protected boolean game_over;
	
	
    //CONSTRUCTOR
public Juego(Gui gui){
	copia = gui;
	
     
	jugador = new Jugador(400,400);
	m = new Mapa();

	anteriorMovido = 0;
 	m.armarMapa(gui); 
 	
 	enemigos = new Batallon();
 	
	gui.add(jugador.getGrafico());
	
	game_over = false;

	
	
=======
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
>>>>>>> origin/master
}



public void GameOver()
{
	
	
	copia.OBTENERTIME().terminar();

	m.eliminarMapa();
	
	enemigos.eliminarEnemigos(copia);
	
	copia.remove(jugador.getGrafico());
	
  copia.getContentPane().setBackground(Color.WHITE);
  
  
  JOptionPane.showMessageDialog(null, "GAME OVER");
 
}

<<<<<<< HEAD


public void agregarOponente()
{
	enemigos.agregarOponente(copia);
}


public void quitarOponente()
{
	enemigos.quitarOponente(copia);
}


public Batallon OBTENERBATALLON()
{
	return enemigos;
}



//MOVER DE JUGADOR

public void mover(int dir){		
	int direccion = 0;
	Rectangle proximo_movimiento=null; 
	switch (dir){
		case KeyEvent.VK_UP : //Arriba
			{proximo_movimiento=new Rectangle(jugador.getPos().x,jugador.getPos().y-jugador.getVelocidad(),jugador.getAncho(),jugador.getAlto());
				direccion = 0;			  
			}
				break;
		case KeyEvent.VK_DOWN ://Abajo
			{proximo_movimiento=new Rectangle(jugador.getPos().x,jugador.getPos().y+jugador.getVelocidad(),jugador.getAncho(),jugador.getAlto());
				direccion = 1;			 
			}
				break;
		case KeyEvent.VK_LEFT : //Izquierda
			{proximo_movimiento=new Rectangle(jugador.getPos().x-jugador.getVelocidad(),jugador.getPos().y,jugador.getAncho(),jugador.getAlto());
				direccion = 2;			
			}
				break;
		case KeyEvent.VK_RIGHT : //Derecha
			{proximo_movimiento=new Rectangle(jugador.getPos().x+jugador.getVelocidad(),jugador.getPos().y,jugador.getAncho(),jugador.getAlto());
				direccion = 3;			  
			}
				break;
	}
	//Verificar si colisiona con algun bloque del mapa
		if (!COLLIDER(proximo_movimiento,jugador)){
			jugador.mover(direccion);
		}
		
}

public void agregarOponente(Gui gui){
	batallon_de_enemigos.agregarOponente(gui);
}

public void quitarOponente(Gui gui){
	batallon_de_enemigos.quitarOponente(gui);
=======
public void agregarOponente(Gui gui){
	batallon_de_enemigos.agregarOponente(gui);
}

public void quitarOponente(Gui gui){
	batallon_de_enemigos.quitarOponente(gui);
}

//Movimiento del jugador en direccion pasada por parametro
public void mover(int dir){		
	jugador.movimiento(jugador.convertir_keyEvent_a_direccionLocal(dir), m);	
>>>>>>> origin/master
}

////Movimiento del jugador en direccion pasada por parametro
//public void mover(int dir){		
//	jugador.movimiento(jugador.convertir_keyEvent_a_direccionLocal(dir), m);	
//
//}

public void eliminar_pared(){
	m.remover_pared();
}

public void cambiar_estado_jugador(){
	jugador.subirNivel();
}

public void reset_estado_jugador(){
	jugador.resetNivel();
}

<<<<<<< HEAD





public void generar_disparo_jugador(){
	jugador.disparar_bala(copia,this,false);
	
}







public void generar_disparo_enemigo()
{
=======
public void generar_disparo_jugador(Gui g){
	jugador.disparar_bala(g,m);
>>>>>>> origin/master
	
	enemigos.generar_disparo_enemigo(copia, this);
}
<<<<<<< HEAD


public void mover()
{
	enemigos.mover(this);
}


public Jugador getJugador()
{
	return jugador;
}


public int getPuntaje()
{
	return enemigos.getPuntaje();
}
	

//COLISIONADOR TODOS CON TODOS BALAS Y TAMQUES CON CELDAS Y TANQUES

public boolean COLLIDER(Rectangle recElemento,Element elemento)
{ 
	boolean colisiono = false;
	
	colisiono = enemigos.ColisionaConOponente(recElemento, elemento);

	if(colisiono == false)
	   colisiono = m.si_colisiona(recElemento, elemento);
	
	if(colisiono == false)
		
      {    colisiono = jugador.getGrafico().getBounds().intersects(recElemento);
		   
           if(colisiono == true)
		       colisiono = elemento.aceptar(jugador);
	  }
	
	
	return colisiono;	
}













}










=======
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
>>>>>>> origin/master
