package BattleCity;

public class Actualizador implements Runnable{
	
	protected volatile boolean game_over;
	protected Juego juego_a_actualizar;
	
	public Actualizador(Juego juego_recibido){
		juego_a_actualizar=juego_recibido;
		game_over=false;
	}
	
	public void terminar_juego(){
		game_over=true;
	}
	
	public void run(){
		while(!game_over){
			try{
				juego_a_actualizar.update();				
				Thread.sleep(200);			
			}
			catch (InterruptedException e){
				//Vacio
			}
		}	
	}
}
