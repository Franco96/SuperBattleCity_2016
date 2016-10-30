package Tanques;

import java.awt.Rectangle;
import java.util.Random;
import BattleCity.Juego;
import BattleCity.Visitor;

public  abstract class Enemigo extends Tanque implements Visitor {
	//Atributos
	protected int porDestruccion;
	protected int direccion_de_movimiento;
	protected Random generador_de_direcciones;	
	
	protected Enemigo(int x, int y) {
		super(x, y);
		generador_de_direcciones = new Random();
		direccion_de_movimiento = generador_de_direcciones.nextInt(4);		
	}
	
	abstract public int getPuntaje_por_Destruccion(); 
	
	
//MOVIMIENTO DE TANQUE PARA HACER LA INTELIGENCIA ENEMIGOS
	public boolean movimiento(Juego h){
	  boolean colisiona = super.movimiento(direccion_de_movimiento, h);
		
		if(colisiona)
			generar_direccion_nueva();
		

		return colisiona;
	}
	
	
	
	

	
	
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
}
