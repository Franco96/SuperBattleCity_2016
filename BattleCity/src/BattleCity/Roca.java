package BattleCity;

import javax.swing.ImageIcon;

public class Roca extends Celda {

	
	
	
	protected Roca(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/roca.png"));
		sePuede_destruir=true;
	}

	
	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

	public boolean eliminarL(){
		return false;
	}
}