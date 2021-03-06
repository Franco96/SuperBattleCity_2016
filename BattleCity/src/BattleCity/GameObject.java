package BattleCity;

import java.awt.Point;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GameObject {
  //ATRIBUTOS
	protected Icon imagen;
	protected JLabel grafico;
	protected  int width = 25;
	protected  int height = 25;
	protected Point pos;
	//Sonido
	protected Clip sonido;
	
  //CONSTRUCTOR	
	
	protected GameObject(int x, int y){
		this.pos = new Point(x,y);
	}	
	
  //METODOS
	
	public Point getPos() {
		return pos;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}			
		return this.grafico;
	}

	
	public void setPosicion(int x,int y){
		pos = new Point(x,y);
	}
	
	public int getAncho(){
		return width;
	}
	
	public int getAlto(){
		return height;
	}
	
	
	
	//METODO PARA PRODUCIR SONIDO
	public void sonido(String archivo)
	{ 
		try{
		sonido = AudioSystem.getClip();
		sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Sonido/"+ archivo + ".wav")));
	    sonido.start();
		}catch(Exception e)
		{
			
		}
		}
	
	
}
