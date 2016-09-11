package BattleCity;

import java.awt.Point;

import javax.swing.JLabel;

public abstract class GameObject {
  //ATRIBUTOS
	protected JLabel grafico;
	protected final int width = 45;
	protected final int height = 45;
	protected Point pos;
	
	
  //CONSTRUCTOR	
	protected GameObject(int x, int y)
	{
		this.pos = new Point(x,y);
	}
	
	
  //METODOS
	
	public Point getPos() {
		return pos;
	}
	

	
	abstract public JLabel getGrafico();
	
  abstract protected void setGrafico(int dir);
	
	
	

	

}