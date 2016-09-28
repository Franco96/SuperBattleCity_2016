package BattleCity;


import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	private Estado estado;
	private int nivActual;
	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
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
}