package Celdas;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Agua extends Celda {

	public Agua(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Agua.png"));
		sePuede_destruir=false;
		this.getGrafico();
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}
	


	@Override
	public boolean visitarConTanqueEnemigo(Enemigo t) {return true;}

	@Override
	public boolean visitarConBala(Bala b) {return false;}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {return true;}
}
