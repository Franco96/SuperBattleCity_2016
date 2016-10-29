package BattleCity;

import java.util.concurrent.ThreadLocalRandom;

//Nuevo actualizador para poder modificar el tiempo del sleep 
public class ActualizadorDeApariciones extends Actualizador{
	protected volatile int tiempo;
	
	public ActualizadorDeApariciones(Juego juego_recibido){
		super(juego_recibido);
		tiempo=4000;
	}
	
	public void generarTiempo(){
		tiempo = ThreadLocalRandom.current().nextInt(4000, 10000 + 1);
	}
	
	public void run(){
		while(!game_over){
			try{
				juego_a_actualizar.agregarOponente();				
				Thread.sleep(tiempo);
				generarTiempo();
			}
			catch (InterruptedException e){
				//Vacio
			}
		}	
	}
}
