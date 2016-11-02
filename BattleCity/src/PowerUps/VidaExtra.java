package PowerUps;

import javax.swing.ImageIcon;

import BattleCity.Juego;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class VidaExtra extends PowerUp{


	
	protected VidaExtra(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerVidaExtra.png"));
	
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarConBala(Bala b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {

	    j.incVida();
		this.desactivarPower();
		return false;
	}

}
