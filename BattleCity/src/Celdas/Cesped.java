package Celdas;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Rectangle;

public class Cesped extends Celda {
	
	public Cesped(int x, int y) {
		super(x, y);
		sePuede_destruir=false;
		sePuede_atravesar=true;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Cesped.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}
	
	@Override
	protected void setGrafico(int dir) {		
		
	}
	
	public boolean eliminarL(){
		return false;
	}
	
	@Override
	public boolean visitarConBala(Bala b) {	
	  return false;
		
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		// TODO Auto-generated method stub
		return false;
	}
}