package Mapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Rectangle;
public class Agua extends Celda {

	public Agua(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Agua.png"));
		sePuede_destruir=false;
		sePuede_atravesar=false;
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, this.pos.y, width, height);
		rectangulo_propio=new Rectangle(pos.x,pos.y,width,height);
	}
	
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