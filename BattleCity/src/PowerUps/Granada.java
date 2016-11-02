package PowerUps;

import javax.swing.ImageIcon;

import BattleCity.Juego;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class Granada extends PowerUp{

	protected Granada(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerGranada.png"));
	
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {
	
		return false;
	}

	@Override
	public boolean visitarConBala(Bala b) {
		
		return false;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		
		miJuego.OBTENERBATALLON().eliminarEnemigos(miJuego.OBTENERGUI());
		 this.desactivarPower();
		return false;
	}

}
