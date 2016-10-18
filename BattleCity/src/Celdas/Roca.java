package Celdas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

import java.awt.Rectangle;

public class Roca extends Celda {

	 public Roca(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Roca.png"));
		sePuede_destruir=true;
		sePuede_atravesar=false;
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
		vida = 4;
	}	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub		
	}
	
	public boolean eliminarL(){
		return false;
	}
	
	
	


	
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
	public boolean visitarConTanqueEnemigo(Enemigo j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		// TODO Auto-generated method stub
		return true;
	}
	
}