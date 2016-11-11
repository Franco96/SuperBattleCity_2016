package PowerUps;

import javax.swing.ImageIcon;
import BattleCity.Juego;
import Tanques.Jugador;

public class Granada extends PowerUp{

	protected Granada(int x, int y, Juego miJuego) {
		super(x, y, miJuego);
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerGranada.gif"));
	
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		this.sonido("SonidoPowerAp");
		miJuego.OBTENERBATALLON().eliminarEnemigos(miJuego.OBTENERGUI());
		miJuego.pedido_barra().actualizarPuntaje(miJuego.getPuntaje());
		 this.desactivarPower();
		return false;
	}

}
