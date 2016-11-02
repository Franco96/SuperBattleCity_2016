package Tanques;

import javax.swing.Icon;

public abstract class Estado {
	protected int golpes_que_Resiste,velocidad_movimiento,velocidad_disparo,disparos_simultaneos;
	
	public int getGolpes_que_resiste(){
		return golpes_que_Resiste;
	}
	public int getVelocidadMovimiento(){
		return velocidad_movimiento;
	}
	public int getVelocidadDisparo(){
		return velocidad_disparo;
	}
	public int getDisparos_simultaneos(){
		return disparos_simultaneos;
	}
	
	public abstract Icon [] ImagenesNivel();
}
