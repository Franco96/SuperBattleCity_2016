package PowerUps;

import javax.swing.ImageIcon;
import BattleCity.DetenerTiempo;
import BattleCity.Juego;
import Tanques.Jugador;

public class Timer extends PowerUp {
	
	protected Timer(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerTime.gif"));	
			
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		
		this.sonido("SonidoPowerAp");
		miJuego.OBTENERBATALLON().setEstaDetenido(true);
		
		DetenerTiempo det = new DetenerTiempo(miJuego);
		Thread j3=new Thread(det);
		j3.start();		
		
		this.desactivarPower();
		return false;
	}	
}
