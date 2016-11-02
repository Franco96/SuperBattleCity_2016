package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Estado4 extends Estado{
	public Estado4(){
		golpes_que_Resiste=4;
		velocidad_movimiento=19;
		velocidad_disparo=28;
		disparos_simultaneos=3;
	}
	
	public  Icon [] ImagenesNivel(){
		Icon imagen[]=new Icon[4];
		imagen[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel4Arriba.gif"));
		imagen[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel4Abajo.gif"));
		imagen[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel4Izquierda.gif"));
		imagen[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueJugadorNivel4Derecha.gif"));
		return imagen;
	}
}
