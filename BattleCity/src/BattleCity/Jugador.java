package BattleCity;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	private String tanqueUP="/Imagen/tanqueArriba.gif";
	private String tanqueDO="/Imagen/tanqueAbajo.gif";
	private String tanqueRI="/Imagen/tanqueDerecha.gif";
	private String tanqueLE="/Imagen/tanqueIzquierda.gif";
	private String tanqueUPQuieto="/Imagen/tanqueArribaQuieto.png";
	private String tanqueDOQuieto="/Imagen/tanqueAbajoQuieto.png";
	private String tanqueRIQuieto="/Imagen/tanqueDerechaQuieto.png";
	private String tanqueLEQuieto="/Imagen/tanqueIzquierdaQuieto.png";
	
	public Jugador(){
		x=40;y=60;
		ImageIcon img=new ImageIcon(this.getClass().getResource(tanqueUP));
		imagen =img.getImage();
	}
	
	public void mover(){
		x+=dx;
		y+=dy;
	}
	
	public int tenerX(){
		return x;
	}
	
	public int tenerY(){
		return y;		
	}
	
	public Image tenerImagen(){
		return imagen;
	}
	
	public void KeyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			dx=-1;
			ImageIcon img=new ImageIcon(this.getClass().getResource(tanqueLE));
			imagen =img.getImage();
		}
		if (key == KeyEvent.VK_RIGHT){
			dx=1;
			ImageIcon img=new ImageIcon(this.getClass().getResource(tanqueRI));
			imagen =img.getImage();
		}
		if (key == KeyEvent.VK_UP){
			dy=-1;
			ImageIcon img=new ImageIcon(this.getClass().getResource(tanqueUP));
			imagen =img.getImage();
		}
		if (key == KeyEvent.VK_DOWN){
			dy=1;
			ImageIcon img=new ImageIcon(this.getClass().getResource(tanqueDO));
			imagen =img.getImage();
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			dx=0;		
		}
		if (key == KeyEvent.VK_RIGHT){
			dx=0;
		}
		if (key == KeyEvent.VK_UP){
			dy=0;
		}
		if (key == KeyEvent.VK_DOWN){
			dy=0;
		}
	}
}
