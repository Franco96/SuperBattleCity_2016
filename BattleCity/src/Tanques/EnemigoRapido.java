package Tanques;

import javax.swing.ImageIcon;

public class EnemigoRapido extends Enemigo{
	public EnemigoRapido(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoDerecha.gif"));
		estado=new EstadoRapido();
		golpes_actuales=estado.getGolpes_que_resiste();
		puntos=200;
	}
	

	
}
