package Celdas;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Cesped extends Celda {
	
	public Cesped(int x, int y) {
		super(x, y);
		sePuede_destruir=false;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Cesped.png"));
		this.getGrafico();
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}
	
	@Override
	public boolean visitarConBala(Bala b) {	return false;}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return false;}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {return false;}
}