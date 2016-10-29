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
	
	//Actualizador para controlar el ingreso de los enemigos al juego
	ActualizadorDeApariciones actualizador_oponentes= new ActualizadorDeApariciones(this);
	Thread j2=new Thread(actualizador_oponentes);
	j2.start();
}

public void GameOver(){	
	actualizador.terminar_juego();
	m.eliminarMapa();	
	enemigos.eliminarEnemigos(copia);	
	copia.remove(jugador.getGrafico());	
    copia.getContentPane().setBackground(Color.WHITE);  
    JOptionPane.showMessageDialog(null, "GAME OVER"); 
}
//AGREGA OPONENTES AL BATALLON
//public void agregarOponente(){
//	enemigos.agregarOponente(copia);
//}

//Nuevo agregar oponente 
public void agregarOponente(){
	enemigos.agregar_oponente(copia, m);
}

//QUITA OPONENTES AL BATALLON
public void quitarOponente(){
	enemigos.quitarOponente(copia);
}

//OBTIENE A TODOS LOS ENEMIGOS DEL BATALLON
public Batallon OBTENERBATALLON(){
	return enemigos;
}


//MOVER DEL JUGADOR
public void mover(int dir){			
	jugador.movimiento(convertir_keyCode_a_direccion(dir),this);
}

private int convertir_keyCode_a_direccion(int direccion_a_convertir){
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

//GENERA EL DISPARO DEL JUGADOR
public void generar_disparo_jugador(){
	jugador.disparar_bala(copia,this,false);
	
}
//GENERA EL DISPARO A TODOS LOS ENEMIGOS DEL BATALLON
public void generar_disparo_enemigo(){	
 	enemigos.generar_disparo_enemigo(copia, this);
}

//GENERA EL MOVIENTO PARA TODOS LOS ENEMIGOS DEL BATALLON
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