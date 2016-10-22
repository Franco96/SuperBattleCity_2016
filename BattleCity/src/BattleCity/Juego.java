package BattleCity;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import GUI.Gui;
import Tanques.Jugador;

public class Juego  {
	
	//ATRIBUTOS
	private Batallon enemigos;    
	protected Jugador jugador;	
	protected Mapa m;    
	protected Actualizador actualizador;
	int anteriorMovido;    
	Gui copia;
	
    //CONSTRUCTOR
public Juego(Gui gui){
	actualizador=new Actualizador(this);
	copia = gui;     
	jugador = new Jugador(400,400);
	m = new Mapa();
	anteriorMovido = 0;
 	m.armarMapa(gui);  	
 	enemigos = new Batallon(); 	
	gui.add(jugador.getGrafico());
	Thread j1=new Thread(actualizador);
	j1.start();
}

public void GameOver(){	
//	copia.OBTENERTIME().terminar();
	actualizador.terminar_juego();
	m.eliminarMapa();	
	enemigos.eliminarEnemigos(copia);	
	copia.remove(jugador.getGrafico());	
    copia.getContentPane().setBackground(Color.WHITE);  
    JOptionPane.showMessageDialog(null, "GAME OVER"); 
}

public void agregarOponente(){
	enemigos.agregarOponente(copia);
}

public void quitarOponente(){
	enemigos.quitarOponente(copia);
}

public Batallon OBTENERBATALLON(){
	return enemigos;
}

//MOVER DE JUGADOR
public void mover(int dir){			
	jugador.movimiento(convertir_keyCode_a_direccion(dir),m);
}

public int convertir_keyCode_a_direccion(int direccion_a_convertir){
	int direccion_resultante=0;
	switch (direccion_a_convertir){
	case KeyEvent.VK_UP : //Arriba
		{
			direccion_resultante = 0;			  
		}
			break;
	case KeyEvent.VK_DOWN ://Abajo
		{
			direccion_resultante = 1;			 
		}
			break;
	case KeyEvent.VK_LEFT : //Izquierda
		{
			direccion_resultante = 2;			
		}
			break;
	case KeyEvent.VK_RIGHT : //Derecha
		{
			direccion_resultante = 3;			  
		}
			break;
	}
	return direccion_resultante;	
}

public void eliminar_pared(){
	m.remover_pared();
}

public void cambiar_estado_jugador(){
	jugador.subirNivel();
}

public void reset_estado_jugador(){
	jugador.resetNivel();
}

public void generar_disparo_jugador(){
	jugador.disparar_bala(copia,this,false);
	
}

public void generar_disparo_enemigo(){	
	enemigos.generar_disparo_enemigo(copia, this);
}

public void mover(){
	enemigos.mover(this);
}

public int getPuntaje(){
	return enemigos.getPuntaje();
}	

//COLISIONADOR TODOS CON TODOS BALAS Y TAMQUES CON CELDAS Y TANQUES
public boolean COLLIDER(Rectangle recElemento,Element elemento){ 
	boolean colisiono = false;	
	colisiono = enemigos.ColisionaConOponente(recElemento, elemento);
	if(colisiono == false)
	   colisiono = m.si_colisiona(recElemento, elemento);
	
	if(colisiono == false)
		
      {    colisiono = jugador.getGrafico().getBounds().intersects(recElemento);
		   
           if(colisiono == true)
		       colisiono = elemento.aceptar(jugador);
	  }	
	return colisiono;	
}

//Aca se colocan los elementos a actualizar del juego
public void update(){
	generar_disparo_enemigo();
	mover();
	jugador.update_bala();
}
}