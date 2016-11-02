package Celdas;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class Base extends Celda{

	
	public Base(int x, int y) {
		super(x, y);
		
		 this.width = 50;
		 this.height = 50;
		
		sePuede_destruir=false;
		sePuede_atravesar=true;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Aguila.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {
		
		return true;
	}

	@Override
	public boolean visitarConBala(Bala b) {
		b.OBTENERJUEGO().GameOver();
		return false;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

}
