package BattleCity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Icon;

public class Bala extends GameObject implements Runnable{
	private int direccion;
	private int velocidad=5;
	protected Icon imagen;
	protected volatile boolean esVisible;
	
	public Bala(int X,int Y,int dir){
		super(X,Y);
		direccion=dir;
		width = 15;
		height=15;
		esVisible=true;
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/bala.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, pos.y, width, height);
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
				if(pos.y>=velocidad){
					pos.setLocation(pos.x, pos.y - velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 1 : //Abajo
				if(pos.y<=(579-(velocidad+height))){
					pos.setLocation(pos.x, pos.y + velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 2 : //Izquierda
				if(pos.x>=velocidad){
					pos.setLocation(pos.x - velocidad, pos.y);
				}
				else{
					volver_invisible();
				}
				break;
			case 3 : //Derecha
				if(pos.x<=(800-(velocidad+width))){
					pos.setLocation(pos.x + velocidad, pos.y);
				}
				else{
					volver_invisible();
				}
				break;
		}
		if (esVisible){setGrafico(dir);}
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
