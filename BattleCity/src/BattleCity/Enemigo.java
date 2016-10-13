package BattleCity;

import java.util.Random;

public  abstract class Enemigo extends Tanque {
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
	public void mover(int dir){
		ultima_direccion=dir;
		
		switch (direccion_de_movimiento) {
			case 0 : //Arriba
				if(pos.y>=getVelocidad()){
					pos.setLocation(pos.x, pos.y - getVelocidad());
					setGrafico(direccion_de_movimiento);
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 1 : //Abajo
				if(pos.y<=(579-(getVelocidad()+height))){
					pos.setLocation(pos.x, pos.y + getVelocidad());
					setGrafico(direccion_de_movimiento);
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 2 : //Izquierda
				if(pos.x>=getVelocidad()){
					pos.setLocation(pos.x - getVelocidad(), pos.y);
					setGrafico(direccion_de_movimiento);
				}
				else{
					generar_direccion_nueva();
				}
				break;
			case 3 : //Derecha
				if(pos.x<=(800-(getVelocidad()+width))){
					pos.setLocation(pos.x + getVelocidad(), pos.y);
					setGrafico(direccion_de_movimiento);
				}
				else{
					generar_direccion_nueva();
				}
				break;
		}
	}
	
	private void generar_direccion_nueva(){
		int r=generador_de_direcciones.nextInt(4);
		while (r==direccion_de_movimiento){
			r=generador_de_direcciones.nextInt(4);
		}
		direccion_de_movimiento=r;
	}
}
