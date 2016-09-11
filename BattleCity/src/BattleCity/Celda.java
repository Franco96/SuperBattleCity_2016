package BattleCity;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Celda extends GameObject {

  //ATRIBUTOS
	
	Icon imagen;

	
	
	
  //CONSTRUCTOR
	
	protected Celda(int x, int y) {
		super(x, y);
		
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}	
	
}