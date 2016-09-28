package BattleCity;

import javax.swing.ImageIcon;

public  abstract class Enemigo extends Tanque {
	//Atributos
	protected int porDestruccion;
	
	protected Enemigo(int x, int y) {
		super(x, y);
		
	}
	abstract public int getPuntaje_por_Destruccion(); 

}
