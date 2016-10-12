package BattleCity;
import GUI.*;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Jugador extends Tanque{
	protected Bala bala_jugador;
	private Estado estado;
	private int nivActual;
	public Jugador(int x, int y) {
		super(x, y);

		resetNivel();
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueArriba.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueAbajo.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/tanqueDerecha.gif"));
	}
	
	public void resetNivel(){
		estado= new Estado1();
		nivActual=1;
	}
	
	public void subirNivel(){
		if (nivActual!=4){
			asignarNivel(nivActual+1);			
		}
	}
	
	private void asignarNivel(int n){
		if (n>=0 && n<=4){
			switch (n) {
            case 1:  resetNivel();
                     break;
            case 2:  estado=new Estado2();
            		 nivActual=2;
                     break;
            case 3:  estado=new Estado3();
            		 nivActual=3;
            		 break;
            case 4:  estado=new Estado4();
                     nivActual=4;
                     break;
			}
		}
	}
	public int getVelocidad() {
		return estado.getMovimiento();
	}
	
	public JLabel bala_disparada(){
		return bala_jugador.getGrafico();
	}
	
	public void disparar_bala(Gui g){		
		switch (ultima_direccion) {
        case 0:  bala_jugador=new Bala(pos.x+17,pos.y-14,ultima_direccion);
                 break;
        case 1:  bala_jugador=new Bala(pos.x+17,pos.y+50,ultima_direccion);
                 break;
        case 2:  bala_jugador=new Bala(pos.x-15,pos.y+17,ultima_direccion);
        		 break;
        case 3:  bala_jugador=new Bala(pos.x+50,pos.y+17,ultima_direccion);
                 break;
		}
		g.add(bala_jugador.getGrafico(),0);
		Thread movimiento1= new Thread(bala_jugador);
		movimiento1.start();
	}
}