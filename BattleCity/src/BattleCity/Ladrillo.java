package BattleCity;

import javax.swing.ImageIcon;

public class Ladrillo extends Celda {

	
	
	
	protected Ladrillo(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/ladrillo.png"));
	}

	
	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}

	

	

}
