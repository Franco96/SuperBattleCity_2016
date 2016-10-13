package BattleCity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Rectangle;

public class Roca extends Celda {

	protected Roca(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Roca.png"));
		sePuede_destruir=true;
		sePuede_atravesar=false;
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
		//por ahora data
	}
}