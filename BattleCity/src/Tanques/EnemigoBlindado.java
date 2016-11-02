package Tanques;

import javax.swing.ImageIcon;

public class EnemigoBlindado extends Enemigo{
	public EnemigoBlindado(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBlindadoArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBlindadoAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBlindadoIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/TanqueEnemigoBlindadoDerecha.gif"));
		estado=new EstadoBlindado();
		puntos=400;
		golpes_actuales=estado.getGolpes_que_resiste();
		golpes_actuales=4;
	}
	
	@Override
	public boolean visitarConBala(Bala b) {	
		if(b.esBaladeEnemigo())
		 return false;
		 else{	
			golpes_actuales--;
			if (golpes_actuales==0){
				b.OBTENERJUEGO().OBTENERBATALLON().quitarOponente(this);
			}
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
