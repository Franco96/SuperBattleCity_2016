package BattleCity;

import javax.swing.ImageIcon;
public class Cesped extends Celda {

	
	
	
	protected Cesped(int x, int y) {
		super(x, y);
		sePuede_destruir=false;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/cesped.png"));
	}

	
	
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean eliminarL(){
		return false;
	}
	

	

}