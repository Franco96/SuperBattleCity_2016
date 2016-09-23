package BattleCity;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import javax.swing.ImageIcon;

import GUI.Gui;


public class Juego {
//ATRIBUTOS
Enemigo enemigos[];	
Jugador jugador;
Mapa m;	
//CONSTRUCTOR

public Juego(Gui gui)
{   enemigos = new EnemigoBasico[4];
	jugador = new Jugador(10,400,400);
	m = new Mapa();
	gui.add(jugador.getGrafico());
	
	for(int i = 0; i < enemigos.length; i++){
		Random r = new Random();
		enemigos[i] = new EnemigoBasico(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
		gui.add(enemigos[i].getGrafico());
	}

	
	
	m.armarMapa(gui);
		
	
     
}

public void mover(){
	for(int i = 0; i < enemigos.length; i++){
		
	// Inteligencia de los enemigos
		Random r = new Random();
		
		int dir = r.nextInt(10000);
		if (isBetween(dir,0, 2500)) {
			enemigos[i].mover(0);
			}
		if (isBetween(dir,2501 , 5000)) {
			enemigos[i].mover(1);
			}
		if (isBetween(dir,5001 , 7250)) {
			enemigos[i].mover(2);
			}
		if (isBetween(dir,7251 , 10000)) {
			enemigos[i].mover(3);
			}
		
	}
}

private boolean isBetween(int x, int lower, int upper) {
	  return lower <= x && x <= upper;
	}


public void mover(int dir){		
	int direccion = 0;
	
	switch (dir){
		case KeyEvent.VK_UP : //Arriba
			direccion = 0;
			break;
		case KeyEvent.VK_DOWN : //Abajo
			direccion = 1;
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 3;
			break;
	}
	
	jugador.mover(direccion);
}
}





















	

