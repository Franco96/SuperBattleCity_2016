package BattleCity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
}
