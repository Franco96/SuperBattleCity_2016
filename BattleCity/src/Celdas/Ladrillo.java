package Celdas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

import java.awt.Rectangle;

public class Ladrillo extends Celda {
	
	 public Ladrillo(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Ladrillo.png"));
		sePuede_destruir=true;
		sePuede_atravesar=false;
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
		vida=4;
	}
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

	public boolean eliminarL(){
		return true;
	}
	
	
	
	
	
	 public boolean visitarConBala(Bala b){
		 
		 vida=vida-1;
		  if (vida==0){
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