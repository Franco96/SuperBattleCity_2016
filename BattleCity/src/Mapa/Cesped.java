package Mapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Rectangle;

public class Cesped extends Celda {
	
	protected Cesped(int x, int y) {
		super(x, y);
		sePuede_destruir=false;
		sePuede_atravesar=true;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/cesped.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean eliminarL(){
		return false;
	}
	
	public void afectar(){
		//por ahora nada
	}
}