package BattleCity;

import GUI.*;
import TDALista.*;
import javax.swing.ImageIcon;
import Exception.*;

public class Jugador extends Tanque{
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
	
	public void disparar_bala(Gui g,Mapa m){		
		if (balas_disparadas.size()<estado.getDisparos_simultaneos()){
			Bala bala_jugador=null;
			switch (ultima_direccion) {
	        case 0:  bala_jugador=new Bala(pos.x+17,pos.y-14,ultima_direccion,m);
	                 break;
	        case 1:  bala_jugador=new Bala(pos.x+17,pos.y+50,ultima_direccion,m);
	                 break;
	        case 2:  bala_jugador=new Bala(pos.x-15,pos.y+17,ultima_direccion,m);
	        		 break;
	        case 3:  bala_jugador=new Bala(pos.x+50,pos.y+17,ultima_direccion,m);
	                 break;
			}
			balas_disparadas.addFirst(bala_jugador);
			g.add(bala_jugador.getGrafico(),0);
			Thread movimiento1= new Thread(bala_jugador);
			movimiento1.start();
		}
	}
	
	public void update_bala(){
		try {
			Position<Bala>p=balas_disparadas.first(),u=balas_disparadas.last();
			while(p!=null){
				if (!p.element().si_esVisible()){
					Position<Bala>aux;	
					if(p!=u)aux=balas_disparadas.next(p);else aux=null;
					balas_disparadas.remove(p);
					p=aux;
				}
				if(p!=u && p!=null)p=balas_disparadas.next(p);else p=null;			
			}
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (BoundaryViolationException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
}
}