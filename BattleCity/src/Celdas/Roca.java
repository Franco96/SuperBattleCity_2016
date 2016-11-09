package Celdas;

import javax.swing.ImageIcon;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import java.awt.Rectangle;

public class Roca extends Celda {

	 public Roca(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Roca.png"));
		sePuede_destruir=true;
		this.getGrafico();
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
		vida = 4;
	}	
	


		@Override
	public boolean visitarConBala(Bala b) {	
		if(b.estaEnNivel4())
		{
			vida--;
			if(vida == 0)
				desactivar();
		}		
		return true;
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return true;}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {	return true;}	
}