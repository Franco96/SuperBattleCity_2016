package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Estado1 extends Estado{
	
	public Estado1(){
		golpes_que_Resiste=1;
		velocidad_movimiento=19;
		velocidad_disparo=10;
		disparos_simultaneos=1;
	}
	
	public  Icon [] ImagenesNivel(){
		Icon imagen[]=new Icon[4];
		imagen[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel1Arriba.gif"));
		imagen[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel1Abajo.gif"));
		imagen[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel1Izquierda.gif"));
		imagen[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel1Derecha.gif"));
		return imagen;
	}
}
