package BattleCity;

<<<<<<< HEAD
=======
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
>>>>>>> 7bea0e86814d7ba1df5341dcf5b707fd5c3cb534
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
<<<<<<< HEAD
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
{   enemigos = new EnemigoBasico[7];
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
		
		int dir = r.nextInt(4);
		
		enemigos[i].mover(dir);
	}
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




=======
import javax.swing.JPanel;
import javax.swing.Timer;

public class Juego extends JPanel implements ActionListener{
	private Jugador tanque;
	private Timer timer;
	
	public Juego(){
		setBackground(Color.BLACK);
		setOpaque(false);
		setFocusable(true);
		addKeyListener(new teclado());
		
		tanque= new Jugador();
		timer = new Timer(5,(ActionListener) this);
		timer.start();		
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g2 = (Graphics2D)grafica;
		g2.drawImage(tanque.tenerImagen(),tanque.tenerX(),tanque.tenerY(),null);
	}
	
	public void actionPerformed(ActionEvent e){
		tanque.mover();
		repaint();
	}
	
	private class teclado extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			tanque.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e){
			tanque.KeyPressed(e);
		}
	}
>>>>>>> 7bea0e86814d7ba1df5341dcf5b707fd5c3cb534
}

















	

