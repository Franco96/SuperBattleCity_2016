package BattleCity;

import javax.swing.ImageIcon;

public  abstract class Enemigo extends Tanque {
	//Atributos
	protected int porDestruccion;
	
	protected Enemigo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
	}
	abstract public int getPuntaje_por_Destruccion(); 

}
