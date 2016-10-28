package Tanques;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import BattleCity.Element;
import BattleCity.GameObject;
import BattleCity.Juego;
import BattleCity.Visitor;
import javax.swing.Icon;
import java.awt.Rectangle;

public class Bala extends GameObject implements Runnable,Element{
	
	private int direccion;
	private int velocidad=5;
	protected Icon imagen;
	protected volatile boolean esVisible;
	protected Rectangle rectangulo;	
	protected boolean balaNivel4;	
	private boolean balaDeEnemigo;	
	private Juego j;
	
	public Bala(int X,int Y,int dir,Juego gh,boolean balaEnemigo){
		super(X,Y);
		direccion=dir;
		width = 15;
		height=15;
		esVisible=true;
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/bala.png"));
		grafico = new JLabel(imagen);
		grafico.setBounds(pos.x, pos.y, width, height);
		rectangulo=null;		
		balaDeEnemigo = balaEnemigo;		
		j = gh;
		balaNivel4 = false;
		
		
		//producirSonido
		this.sonido("SonidoBala");
		
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
				if(pos.y>=velocidad &&!j.COLLIDER(rectangulo, this)){
					pos.setLocation(pos.x, pos.y - velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 1 : //Abajo
				rectangulo=new Rectangle(pos.x, pos.y + velocidad, width, height);
				if(pos.y<=(579-(velocidad+height)) && !j.COLLIDER(rectangulo, this)){
					pos.setLocation(pos.x, pos.y + velocidad);
				}
				else{
					volver_invisible();
				}
				break;
			case 2 : //Izquierda
				rectangulo=new Rectangle(pos.x - velocidad, pos.y, width, height);
				if(pos.x>=velocidad && !j.COLLIDER(rectangulo, this)){
					pos.setLocation(pos.x - velocidad, pos.y);
				}
				else{
					volver_invisible();
				}
				break;
			case 3 : //Derecha
				rectangulo=new Rectangle(pos.x + velocidad, pos.y, width, height);
				if(pos.x<=(800-(velocidad+width)) && !j.COLLIDER(rectangulo, this)){
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
	
	public void setBalaEnNivel4(boolean b){
		balaNivel4 = b;
	}	
	
	public boolean estaEnNivel4(){
		return balaNivel4;
	}
	
	public Juego OBTENERJUEGO(){
		return j;
	}
	
	public boolean aceptar(Visitor t){		 
		return t.visitarConBala(this);		 
	}

   public boolean esBaladeEnemigo(){
	   return balaDeEnemigo;
   }	
}
