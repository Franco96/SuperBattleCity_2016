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
	
	public void setPosicion(int x,int y)
	{
		pos = new Point(x,y);
	}
	
	public int getAncho(){
		return width;
	}
	
	public int getAlto(){
		return height;
	}
<<<<<<< HEAD
<<<<<<< HEAD

=======
	
>>>>>>> origin/master
=======
	
>>>>>>> origin/master
	public int convertir_keyEvent_a_direccionLocal(int direccion_recibida){
		int resultado=0;
		switch (direccion_recibida) {
        case 38:  resultado=0;
                 break;
        case 40:  resultado=1;
                 break;
        case 37:  resultado=2;
        		 break;
        case 39:  resultado=3;
                 break;
		}
		return resultado;
	}
	
	public int convertir_direccionLocal_a_keyEvent(int direccion_recibida){
		int resultado=0;
		switch (direccion_recibida) {
        case 0:  resultado=38;
                 break;
        case 1:  resultado=40;
                 break;
        case 2:  resultado=37;
        		 break;
        case 3:  resultado=39;
                 break;
		}
		return resultado;
	}
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
}
