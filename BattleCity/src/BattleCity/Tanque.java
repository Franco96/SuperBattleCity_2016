package BattleCity;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract  class Tanque extends GameObject {
  //ATRIBUTOS
    protected int velocidad;
    protected Icon image[];
<<<<<<< HEAD
	protected int chocaEn;
=======
    protected int ultima_direccion;
	
>>>>>>> origin/master
	//CONSTRUCTOR
    
	protected Tanque(int x, int y) {
		super(x, y);
	    this.image = new Icon[8];  
	    this.width = 50;
	    this.height = 50;
	    chocaEn = -1;
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
		ultima_direccion=dir;
		switch (dir) {
			case 0 : //Arriba
				if(pos.y>=getVelocidad())pos.setLocation(pos.x, pos.y - getVelocidad());
				break;
			case 1 : //Abajo
				if(pos.y<=(579-(getVelocidad()+height)))pos.setLocation(pos.x, pos.y + getVelocidad());
				break;
			case 2 : //Izquierda
				if(pos.x>=getVelocidad()) pos.setLocation(pos.x - getVelocidad(), pos.y);
				break;
			case 3 : //Derecha
				if(pos.x<=(800-(getVelocidad()+width)))pos.setLocation(pos.x + getVelocidad(), pos.y);
				break;
		}
		
	
		setGrafico(dir);
<<<<<<< HEAD
	}
	
	
	public JLabel getLabel(){
		return grafico;
	}
	
	
	
=======
	}	
>>>>>>> origin/master
}



