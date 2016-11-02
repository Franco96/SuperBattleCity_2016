package Tanques;

import javax.swing.ImageIcon;

public class EnemigoRapido extends Enemigo{
	public EnemigoRapido(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoRapidoDerecha.gif"));
		estado=new EstadoRapido();
		puntos=200;
	}
	
	@Override
	public boolean visitarConBala(Bala b) {	
		if(b.esBaladeEnemigo())
		 return false;
		 else{			 
			b.OBTENERJUEGO().OBTENERBATALLON().quitarOponente(this);
			b.OBTENERJUEGO().incEnemigosDestruidos();
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
