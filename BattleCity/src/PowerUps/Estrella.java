package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import BattleCity.Juego;
import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;

public class Estrella extends PowerUp {

	protected Estrella(int x, int y,Juego miJuego) {
		super(x, y,miJuego);
		
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/PowerEstrella.gif"));
	
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
		this.sonido("SonidoPowerAp");
		j.subirNivel();
        this.desactivarPower();
		return false;
	}


	

}
