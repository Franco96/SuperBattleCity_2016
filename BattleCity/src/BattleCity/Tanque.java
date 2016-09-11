package BattleCity;

import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract  class Tanque extends GameObject {
  //ATRIBUTOS
    protected int velocidad;
    protected Icon image[];

	
	//CONSTRUCTOR
    
	protected Tanque(int velocidad,int x, int y) {
		super(x, y);
	    this.velocidad = velocidad;
	    this.image = new Icon[8];    
	}
	
   //METODOS
	
	public int getVelocidad() {
		return velocidad;
	}
	
	
	
	protected void setGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				if(pos.y>=getVelocidad())pos.setLocation(pos.x, pos.y - velocidad);
				break;
			case 1 : //Abajo
				if(pos.y<=(710-(getVelocidad()+height)))pos.setLocation(pos.x, pos.y + velocidad);
				break;
			case 2 : //Izquierda
				if(pos.x>=getVelocidad()) pos.setLocation(pos.x - velocidad, pos.y);
				break;
			case 3 : //Derecha
				if(pos.x<=(1365-(getVelocidad()+width)))pos.setLocation(pos.x + velocidad, pos.y);
				break;
		}
		setGrafico(dir);
	}
	
	



}