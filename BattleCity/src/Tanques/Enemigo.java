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
	
	public void mover(int dir,Juego h){
		Rectangle proximo_movimiento=null;
		int indice=0;
		boolean colisiono=false;
		while (indice<getVelocidad() && !colisiono){
			switch (direccion_de_movimiento) {
			case 0 : //Arriba
				proximo_movimiento=new Rectangle(this.getPos().x,this.getPos().y-1,this.getAncho(),this.getAlto());
				if(pos.y>=1&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x, pos.y - 1);		
					this.sonido("SonidoMover");
				}
				else{
				
					generar_direccion_nueva();
					colisiono=true;
				}
				break;
			case 1 : //Abajo
				proximo_movimiento=new Rectangle(this.getPos().x,this.getPos().y+1,this.getAncho(),this.getAlto());
				
				if(pos.y<=(579-(1+height))&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x, pos.y + 1);	
					this.sonido("SonidoMover");
				}
				else{
			
					generar_direccion_nueva();
					colisiono=true;
				}
				break;
			case 2 : //Izquierda
				proximo_movimiento=new Rectangle(this.getPos().x-1,this.getPos().y,this.getAncho(),this.getAlto());
				
				if(pos.x>=1&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x - 1, pos.y);	
					this.sonido("SonidoMover");
				}
				else{
				
					generar_direccion_nueva();
					colisiono=true;
				}
				break;
			case 3 : //Derecha				
				proximo_movimiento=new Rectangle(this.getPos().x+1,this.getPos().y,this.getAncho(),this.getAlto());				
				if(pos.x<=(800-(1+width))&&(!h.COLLIDER(proximo_movimiento, this))){
					pos.setLocation(pos.x + 1, pos.y);				
					this.sonido("SonidoMover");
				}
				else{
					
					generar_direccion_nueva();
					colisiono=true;
				}
				break;	
			}		
			ultima_direccion = direccion_de_movimiento;
			setGrafico(direccion_de_movimiento);
			indice++;
		}		
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
