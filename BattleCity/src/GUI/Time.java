package GUI;

import BattleCity.Juego;

public class Time extends Thread {

	private Juego elJuego;
    private boolean gameover;
	public Time(Juego j) {
		this.elJuego = j;
		
		gameover = false;
	}
	
	public void terminar()
	{
		gameover = true;
	}
	

	public void run() {
		while(!gameover){
			try {
				
				elJuego.generar_disparo_enemigo();
				elJuego.mover();
				elJuego.getJugador().update_bala();
				
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}