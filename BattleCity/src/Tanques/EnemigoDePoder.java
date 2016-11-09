package Tanques;

import javax.swing.ImageIcon;

public class EnemigoDePoder extends Enemigo{
	public EnemigoDePoder(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoDePoderArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoDePoderAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoDePoderIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoDePoderDerecha.gif"));
		estado=new EstadoDePoder();
		golpes_actuales=estado.getGolpes_que_resiste();
		puntos=300;
	}
	


}
