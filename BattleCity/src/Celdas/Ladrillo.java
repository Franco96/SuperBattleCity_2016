package Celdas;

import javax.swing.ImageIcon;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import java.awt.Rectangle;

public class Ladrillo extends Celda {
	
	 public Ladrillo(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Ladrillo.png"));
		sePuede_destruir=true;
		this.getGrafico();
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
		vida=4;
	}
	
	
		@Override
	 public boolean visitarConBala(Bala b){		 
		 vida=vida-1;
		  if (vida==0){
				desactivar();
			}		 
		 return true;
	 }

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return true;}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {return true;}	
}