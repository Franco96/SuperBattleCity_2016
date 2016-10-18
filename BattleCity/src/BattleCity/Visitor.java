package BattleCity;

import Tanques.Bala;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public interface Visitor {

	 public boolean visitarConTanqueEnemigo(Enemigo j);

	 public boolean visitarConBala(Bala b);	
	 
	 public boolean visitarConTanqueJugador(Jugador j);
	
}