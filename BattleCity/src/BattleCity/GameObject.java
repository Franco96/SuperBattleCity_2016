package BattleCity;

import java.awt.Point;

import javax.swing.JLabel;

public abstract class GameObject {
  //ATRIBUTOS
	protected JLabel grafico;
	protected  int width = 25;
	protected  int height = 25;
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
