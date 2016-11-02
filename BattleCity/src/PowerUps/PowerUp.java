package PowerUps;

import javax.swing.Icon;
import javax.swing.JLabel;

import BattleCity.GameObject;
import BattleCity.Juego;
import BattleCity.Visitor;

public abstract class PowerUp extends GameObject implements Visitor{
	//ATRIBUTOS
	protected Icon imagen;
	protected boolean estaActivo;
	protected Juego miJuego;
	
	
	protected PowerUp(int x, int y,Juego miJuego) {
		super(x, y);
		this.miJuego = miJuego;
		 this.width = 50;
		 this.height = 50;
		 estaActivo = false;
	}
	
	@Override
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}			
		return this.grafico;
	}
	
	@Override
	protected void setGrafico(int dir) {
		// TODO Auto-generated method stub
		
	}
	
 public void desactivarPower()
 {
		estaActivo = false;
		this.getGrafico().setVisible(false);
		this.sonido("SonidoPowerAp");
 }
 
 public boolean getEstaActivo()
 {
	 return this.estaActivo;
 }
 
 
 public void activarPower()
 {
	 this.estaActivo = true;
	 this.getGrafico().setVisible(true);
		this.sonido("SonidoAparecePower");
 }
 
}
