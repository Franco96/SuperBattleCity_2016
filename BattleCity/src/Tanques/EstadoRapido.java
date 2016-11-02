package Tanques;

import javax.swing.Icon;

public class EstadoRapido extends Estado{
	public EstadoRapido(){
		golpes_que_Resiste=1;
		velocidad_movimiento=28;
		velocidad_disparo=19;
		disparos_simultaneos=1;
	}
	
	public  Icon [] ImagenesNivel(){
		return null;
	}
}
