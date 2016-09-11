package BattleCity;

import javax.swing.ImageIcon;

public class Agua extends Celda {

	
	
	
	protected Agua(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/agua.png"));
	}

	
	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

	

	

}
