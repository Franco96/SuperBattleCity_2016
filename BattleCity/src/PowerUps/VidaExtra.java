package PowerUps;

import javax.swing.ImageIcon;

import BattleCity.Juego;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class VidaExtra extends PowerUp{


	
	protected VidaExtra(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerVidaExtra.gif"));
	
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		this.sonido("SonidoPowerAp");
	    j.agregarVida();
		this.desactivarPower();
		return false;
	}

}
