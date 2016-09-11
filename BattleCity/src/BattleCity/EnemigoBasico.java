package BattleCity;

import javax.swing.ImageIcon;

public class EnemigoBasico extends Enemigo {

	protected EnemigoBasico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueDerecha.gif"));
	}
	

	
}
