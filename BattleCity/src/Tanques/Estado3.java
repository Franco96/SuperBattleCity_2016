package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Estado3 extends Estado{
	
	public Estado3(){
		golpes_que_Resiste=2;
		velocidad_movimiento=19;
		velocidad_disparo=19;
		disparos_simultaneos=2;
	}
	
	public  Icon [] ImagenesNivel(){
		Icon imagen[]=new Icon[4];
		imagen[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel3Arriba.gif"));
		imagen[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel3Abajo.gif"));
		imagen[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel3Izquierda.gif"));
		imagen[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel3Derecha.gif"));
		return imagen;
	}
}
