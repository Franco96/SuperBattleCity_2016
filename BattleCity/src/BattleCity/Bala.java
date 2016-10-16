package BattleCity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.Rectangle;
import Mapa.*;

public class Bala extends GameObject implements Runnable{
	private int direccion;
	private int velocidad=5;
	protected Icon imagen;
	protected volatile boolean esVisible;
	protected Mapa mapa_que_usa;
	protected Rectangle rectangulo;
	
	public Bala(int X,int Y,int dir,Mapa m){
		super(X,Y);
		direccion=dir;
		mapa_que_usa=m;
		width = 15;
		height=15;
		esVisible=true;
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/bala.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, pos.y, width, height);
		rectangulo=null;
	}
	
    public JLabel getGrafico(){
    	return grafico;    	
    }
	
    protected void setGrafico(int dir){
			grafico.setIcon(imagen);
			grafico.setBounds(pos.x, pos.y, width, height);
	}
	
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				rectangulo=new Rectangle(pos.x, pos.y - velocidad, width, height);
				if(pos.y>=velocidad && !mapa_que_usa.si_colisiona_con_efecto(rectangulo)){
					pos.setLocation(pos.x, pos.y - velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 1 : //Abajo
				rectangulo=new Rectangle(pos.x, pos.y + velocidad, width, height);
				if(pos.y<=(579-(velocidad+height)) && !mapa_que_usa.si_colisiona_con_efecto(rectangulo)){
					pos.setLocation(pos.x, pos.y + velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 2 : //Izquierda
				rectangulo=new Rectangle(pos.x - velocidad, pos.y, width, height);
				if(pos.x>=velocidad && !mapa_que_usa.si_colisiona_con_efecto(rectangulo)){
					pos.setLocation(pos.x - velocidad, pos.y);
				}
				else{
					volver_invisible();
				}
				break;
			case 3 : //Derecha
				rectangulo=new Rectangle(pos.x + velocidad, pos.y, width, height);
				if(pos.x<=(800-(velocidad+width)) && !mapa_que_usa.si_colisiona_con_efecto(rectangulo)){
					pos.setLocation(pos.x + velocidad, pos.y);
				}
				else{
					volver_invisible();
				}
				break;
		}
		if (esVisible){setGrafico(dir);}
	}
	
	public boolean si_esVisible(){
		return esVisible;
	}
	
	public void mover_en_direccion(){
		mover(direccion);
	}	
	
	public void volver_invisible(){
		grafico.setVisible(false);
		esVisible=false;
	}
	
	public void run(){
		while(esVisible){
			try{
				mover_en_direccion();
				Thread.sleep(15);			
			}
			catch (InterruptedException e){
				//Vacio
			}
		}	
	}
}
