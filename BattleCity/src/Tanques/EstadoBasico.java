package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EstadoBasico extends Estado{
	public EstadoBasico(){
		golpes_que_Resiste=1;
		velocidad_movimiento=10;
		velocidad_disparo=10;
		disparos_simultaneos=1;
	}
	public  Icon [] ImagenesNivel(){
		return null;
	}
}