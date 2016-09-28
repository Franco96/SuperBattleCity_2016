package BattleCity;

import javax.swing.ImageIcon;
public class Agua extends Celda {

	
	
	
	public Agua(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/agua.png"));
		sePuede_destruir=false;
	}

	
	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

	public boolean eliminarL(){
		return false;
	}

	

}
