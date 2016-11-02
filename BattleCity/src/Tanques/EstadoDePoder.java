package Tanques;

import javax.swing.Icon;

public class EstadoDePoder extends Estado{
	public EstadoDePoder(){
		golpes_que_Resiste=1;
		velocidad_movimiento=19;
		velocidad_disparo=28;
		disparos_simultaneos=1;
	}
	
	public  Icon [] ImagenesNivel(){
		return null;
	}
}