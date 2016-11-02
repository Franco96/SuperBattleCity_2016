package Tanques;

import BattleCity.Visitor;

public class Jugador extends Tanque implements Visitor{
	
public Jugador(int x, int y) {
	super(x, y);
	resetNivel();
}
	
public void resetNivel(){
	estado= new Estado1();
	nivActual=1;
	this.image=estado.ImagenesNivel();
	golpes_actuales=estado.getGolpes_que_resiste();
}
	
public void subirNivel(){
	if (nivActual!=4){
		asignarNivel(nivActual+1);
		golpes_actuales=estado.getGolpes_que_resiste();
		this.image=estado.ImagenesNivel();
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
	return estado.getVelocidadMovimiento();
}
	
public boolean aceptar(Visitor v){
	return v.visitarConTanqueJugador(this);
}		

@Override
public boolean visitarConBala(Bala b) {			
	if(!b.esBaladeEnemigo())
		 return false;
		 else{	
			golpes_actuales--;
			if (golpes_actuales==0){
				b.OBTENERJUEGO().GameOver();
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
	return false;
}


}