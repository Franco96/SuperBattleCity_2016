package Celdas;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class Base extends Celda{

	
	public Base(int x, int y) {
		super(x, y);
		
		 this.width = 50;
		 this.height = 50;
		
		sePuede_destruir=false;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Aguila.png"));
		this.getGrafico();
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}



	@Override
	public boolean visitarConBala(Bala b) {
		b.OBTENERJUEGO().GameOver();
		return false;
	}
	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return true;}
	

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {return true;}

	

}
