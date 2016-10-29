package Tanques;

import javax.swing.ImageIcon;
import BattleCity.Visitor;

public class Jugador extends Tanque implements Visitor{
	
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
	
public boolean aceptar(Visitor v){
	return v.visitarConTanqueJugador(this);
}		

@Override
public boolean visitarConBala(Bala b) {		

	if(!b.esBaladeEnemigo())
	 return false;
	 else{			 
		b.OBTENERJUEGO().GameOver();			
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
	return false;
}

//public void mover(int dir){
//	ultima_direccion=dir;
//	switch (dir) {
//		case 0 : //Arriba
//			if(pos.y>=getVelocidad())pos.setLocation(pos.x, pos.y - 1);
//			break;
//		case 1 : //Abajo
//			if(pos.y<=(579-(getVelocidad()+height)))pos.setLocation(pos.x, pos.y + 1);
//			break;
//		case 2 : //Izquierda
//			if(pos.x>=getVelocidad()) pos.setLocation(pos.x - 1, pos.y);
//			break;
//		case 3 : //Derecha
//			if(pos.x<=(800-(getVelocidad()+width)))pos.setLocation(pos.x + 1, pos.y);
//			break;
//	}	
//	setGrafico(dir);
//}
	
//Mover PRUEBA agregando mejora para el sistema de colision
//public void movimiento(int direccion_de_movimiento,Mapa mapa_que_recibe){
//	Rectangle proximo_movimiento=null;
//	int indice=0;
//	boolean colisiono=false;
//	while (indice<getVelocidad() && !colisiono){
//		switch (direccion_de_movimiento){
//		case 0 : //Arriba
//			proximo_movimiento=new Rectangle(getPos().x,getPos().y-1,getAncho(),getAlto());
//			break;
//		case 1 ://Abajo
//			proximo_movimiento=new Rectangle(getPos().x,getPos().y+1,getAncho(),getAlto());			 
//			break;
//		case 2 : //Izquierda
//			proximo_movimiento=new Rectangle(getPos().x-1,getPos().y,getAncho(),getAlto());			
//			break;
//		case 3 : //Derecha
//			proximo_movimiento=new Rectangle(getPos().x+1,getPos().y,getAncho(),getAlto());			  
//			break;
//		}
//		colisiono=mapa_que_recibe.si_colisiona(proximo_movimiento,this);	
//		if (!colisiono){
//			mover(direccion_de_movimiento);
//			//Producir Sonido
//			this.sonido("SonidoMover");
//			
//		}
//		indice++;
//	}
//}


}