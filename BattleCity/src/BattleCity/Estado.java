package BattleCity;

public abstract class Estado {
	protected int golpes_que_Resiste,movimiento,disparo,disparos_simultaneos;
	
	public int getGolpes_que_resiste(){
		return golpes_que_Resiste;
	}
	public int getMovimiento(){
		return movimiento;
	}
	public int getDisparo(){
		return disparo;
	}
	public int getDisparos_simultaneos(){
		return disparos_simultaneos;
	}
}
