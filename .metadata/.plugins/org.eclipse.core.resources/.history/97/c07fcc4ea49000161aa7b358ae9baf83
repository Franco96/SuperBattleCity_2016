package BattleCity;

import java.awt.Rectangle;
import Mapa.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

public abstract  class Tanque extends GameObject {
    
	//ATRIBUTOS
    protected int velocidad;
    protected Icon image[];
    protected int ultima_direccion;
    protected PositionList<Bala> balas_disparadas;
	
    //CONSTRUCTOR    
	protected Tanque(int x, int y) {
		super(x, y);
	    this.image = new Icon[8];  
	    this.width = 50;
	    this.height = 50;
	    balas_disparadas= new ListaDoblementeEnlazada<Bala>();
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
			if(pos.y>=getVelocidad())pos.setLocation(pos.x, pos.y - 1);
			break;
		case 1 : //Abajo
			if(pos.y<=(579-(getVelocidad()+height)))pos.setLocation(pos.x, pos.y + 1);
			break;
		case 2 : //Izquierda
			if(pos.x>=getVelocidad()) pos.setLocation(pos.x - 1, pos.y);
			break;
		case 3 : //Derecha
			if(pos.x<=(800-(getVelocidad()+width)))pos.setLocation(pos.x + 1, pos.y);
			break;
	}	
	setGrafico(dir);
}	
	
//Mover PRUEBA agregando mejora para el sistema de colision
public void movimiento(int direccion_de_movimiento,Mapa mapa_que_recibe){
	Rectangle proximo_movimiento=null;
	int indice=0;
	boolean colisiono=false;
	while (indice<getVelocidad() && !colisiono){
		switch (direccion_de_movimiento){
		case 0 : //Arriba
			proximo_movimiento=new Rectangle(getPos().x,getPos().y-1,getAncho(),getAlto());
			break;
		case 1 ://Abajo
			proximo_movimiento=new Rectangle(getPos().x,getPos().y+1,getAncho(),getAlto());			 
			break;
		case 2 : //Izquierda
			proximo_movimiento=new Rectangle(getPos().x-1,getPos().y,getAncho(),getAlto());			
			break;
		case 3 : //Derecha
			proximo_movimiento=new Rectangle(getPos().x+1,getPos().y,getAncho(),getAlto());			  
			break;
		}
		colisiono=mapa_que_recibe.si_colisiona(proximo_movimiento);	
		if (!colisiono){
			mover(direccion_de_movimiento);
		}
		indice++;
	}
}
	
public JLabel getLabel(){
	return grafico;
}
}



