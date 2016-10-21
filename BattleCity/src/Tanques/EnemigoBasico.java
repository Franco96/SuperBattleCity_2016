package Tanques;

import javax.swing.ImageIcon;

public class EnemigoBasico extends Enemigo {	
	
	public EnemigoBasico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueDerecha.gif"));
		porDestruccion=25;
		velocidad=10;
	}
	
	public int getPuntaje_por_Destruccion(){
		return porDestruccion;		
	}

	@Override
	public boolean visitarConBala(Bala b) {	
		if(b.esBaladeEnemigo())
		 return false;
		 else{			 
			b.OBTENERJUEGO().OBTENERBATALLON().quitarOponente(this);			
			return true;	        
			} 
	}

	@Override
	public boolean visitarConTanqueEnemigo(Enemigo j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarConTanqueJugador(Jugador j) {
		// TODO Auto-generated method stub
		return true;
	}
}
