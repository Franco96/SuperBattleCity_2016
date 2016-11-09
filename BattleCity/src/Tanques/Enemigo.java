package Tanques;

import java.util.Random;
import BattleCity.Juego;
import BattleCity.Visitor;

public  abstract class Enemigo extends Tanque {
	//Atributos
	protected int puntos;
	protected int direccion_de_movimiento;
	protected Random generador_de_direcciones;	
	
	protected Enemigo(int x, int y) {
		super(x, y);
		generador_de_direcciones = new Random();
		direccion_de_movimiento = generador_de_direcciones.nextInt(4);		
	}
	
	
	public int getPuntaje_por_Destruccion(){
		return puntos;		
	}	
	
//MOVIMIENTO DE TANQUE PARA HACER LA INTELIGENCIA ENEMIGOS
	public boolean movimiento(Juego h){
	  boolean colisiona = super.movimiento(direccion_de_movimiento, h);
		
		if(colisiona)
			generar_direccion_nueva();
		

		return colisiona;
	}
	
	
	
	

//Genera una nueva direccion para la inteligencia del mover	
	private void generar_direccion_nueva(){
		int r=generador_de_direcciones.nextInt(4);
		while (r==direccion_de_movimiento){
			r=generador_de_direcciones.nextInt(4);
		}
		direccion_de_movimiento=r;
	}	
	
	
	
	
	public boolean aceptar(Visitor v){
		return v.visitarConTanqueEnemigo(this);
	}
	
	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {return true;}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {return true;}
	
	@Override
	public boolean visitarConBala(Bala b) {	
		if(b.esBaladeEnemigo())
		 return false;
		 else{	
			golpes_actuales--;
			if (golpes_actuales==0){
				b.OBTENERJUEGO().OBTENERBATALLON().quitarOponente(this, b.OBTENERJUEGO());
				b.OBTENERJUEGO().incEnemigosDestruidos();
				b.OBTENERJUEGO().pedido_barra().quitarEnemigo();
			}
			return true;
		 }
	}

}
