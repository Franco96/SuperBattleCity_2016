package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Estado2 extends Estado{
	
	public Estado2(){
		golpes_que_Resiste=1;
		velocidad_movimiento=28;
		velocidad_disparo=19;
		disparos_simultaneos=1;
	}
	
	public  Icon [] ImagenesNivel(){
		Icon imagen[]=new Icon[4];
		imagen[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel2Arriba.gif"));
		imagen[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel2Abajo.gif"));
		imagen[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel2Izquierda.gif"));
		imagen[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel2Derecha.gif"));
		return imagen;
	}
}
