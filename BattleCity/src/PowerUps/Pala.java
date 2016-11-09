package PowerUps;

import javax.swing.ImageIcon;
import BattleCity.Juego;
import Tanques.Jugador;

public class Pala extends PowerUp{

	public Pala(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerPala.gif"));	

		
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		this.sonido("SonidoPowerAp");
		miJuego.cambiarBaseARoca();
		this.desactivarPower();
		return false;
	}

}
