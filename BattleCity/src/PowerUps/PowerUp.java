package PowerUps;

import BattleCity.GameObject;
import BattleCity.Juego;
import BattleCity.Visitor;
import Tanques.Bala;
import Tanques.Enemigo;

public abstract class PowerUp extends GameObject implements Visitor{
	//ATRIBUTOS
	protected boolean estaActivo;
	protected Juego miJuego;
	
	
	protected PowerUp(int x, int y,Juego miJuego) {
		super(x, y);
		this.miJuego = miJuego;
		 this.width = 50;
		 this.height = 50;
		 estaActivo = false;
	}
 
 public boolean getEstaActivo(){
	 return this.estaActivo;
 }
 
 public void desactivarPower(){
		estaActivo = false;
		this.getGrafico().setVisible(false);
}
 
 public void activarPower(){
	 this.estaActivo = true;
	 this.getGrafico().setVisible(true);
	 this.sonido("SonidoAparecePower"); }
 
 
	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return false;}

	@Override
	public boolean visitarConBala(Bala b) {return false;}
 
}
