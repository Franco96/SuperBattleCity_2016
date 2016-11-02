package Tanques;

import javax.swing.Icon;

public class EstadoBlindado extends Estado{
	public EstadoBlindado(){
		golpes_que_Resiste=4;
		velocidad_movimiento=10;
		velocidad_disparo=19;
		disparos_simultaneos=1;
	}
	
	public  Icon [] ImagenesNivel(){
		return null;
	}
}