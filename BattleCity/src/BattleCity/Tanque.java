package BattleCity;

import java.awt.Image;
import java.awt.event.KeyEvent;

public abstract class Tanque {
	protected int dx;
	protected int dy;
	protected int x;
	protected int y;	
	protected Image imagen;
	
	abstract public void mover();
	
	abstract public int tenerX();
	
	abstract public int tenerY();	
	
	abstract public Image tenerImagen();
}
