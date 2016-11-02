package Tanques;

import javax.swing.ImageIcon;

public class EnemigoBasico extends Enemigo {	
	
	public EnemigoBasico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBasicoDerecha.gif"));
		estado=new EstadoBasico();
		puntos=100;
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
