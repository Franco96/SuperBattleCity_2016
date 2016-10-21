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
	
	//Modificacion del mover de tanque para modelar la inteligencia de los enemigos	
	public void mover(int dir,Juego h){
		Rectangle proximo_movimiento=null;		
		switch (direccion_de_movimiento) {
			case 0 : //Arriba
				proximo_movimiento=new Rectangle(this.getPos().x,this.getPos().y-this.getVelocidad(),this.getAncho(),this.getAlto());
				
				if(pos.y>=getVelocidad()&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x, pos.y - getVelocidad());					
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 1 : //Abajo
				proximo_movimiento=new Rectangle(this.getPos().x,this.getPos().y+this.getVelocidad(),this.getAncho(),this.getAlto());
				
				if(pos.y<=(579-(getVelocidad()+height))&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x, pos.y + getVelocidad());					
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 2 : //Izquierda
				proximo_movimiento=new Rectangle(this.getPos().x-this.getVelocidad(),this.getPos().y,this.getAncho(),this.getAlto());
				
				if(pos.x>=getVelocidad()&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x - getVelocidad(), pos.y);				
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 3 : //Derecha				
				proximo_movimiento=new Rectangle(this.getPos().x+this.getVelocidad(),this.getPos().y,this.getAncho(),this.getAlto());				
				if(pos.x<=(800-(getVelocidad()+width))&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x + getVelocidad(), pos.y);				
				}
				else{
					generar_direccion_nueva();
				}
				break;	
			}		
		ultima_direccion = direccion_de_movimiento;
		setGrafico(direccion_de_movimiento);
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
