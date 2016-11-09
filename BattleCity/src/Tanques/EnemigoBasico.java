package Tanques;

import javax.swing.ImageIcon;

public class EnemigoBasico extends Enemigo {	
	
	public EnemigoBasico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoDerecha.gif"));
		estado=new EstadoBasico();
		golpes_actuales=estado.getGolpes_que_resiste();
		puntos=100;
	}




}
