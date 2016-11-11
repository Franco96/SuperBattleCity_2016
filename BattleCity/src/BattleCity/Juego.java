package BattleCity;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import PowerUps.LosPowerUps;
import Tanques.Jugador;

public class Juego  {
	
	//ATRIBUTOS
	private Batallon enemigos;    
	protected Jugador jugador;	
	protected Mapa m;    
	protected Actualizador actualizador;  
	protected Gui copia;
	private LosPowerUps power;
	private int enemigosDestruidos;
	protected boolean si_termino;
	protected Barra_Inferior barra;
    
	//CONSTRUCTOR
public Juego(Gui gui){
	enemigosDestruidos = 0;
	power = new LosPowerUps(this);
	actualizador=new Actualizador(this);
	copia = gui;     
	jugador = new Jugador(400,400);
	m = new Mapa();
 	m.armarMapa(gui);  	
 	enemigos = new Batallon(); 	
	gui.add(jugador.getGrafico());
	gui.add(jugador.getLabelInmortal(),0);	
	Thread j1=new Thread(actualizador);
	j1.start();
	si_termino=false;
	
	barra=new Barra_Inferior(copia);
	//Actualizador para controlar el ingreso de los enemigos al juego
	ActualizadorDeApariciones actualizador_oponentes= new ActualizadorDeApariciones(this);
	Thread j2=new Thread(actualizador_oponentes);
	j2.start();

}

//-------------METODOS----------------------------//




private void parar(){
	actualizador.terminar_juego();
	m.eliminarMapa();	
	enemigos.eliminarEnemigos(copia);	
	copia.remove(jugador.getGrafico());	
	si_termino=true;
	copia.setSize(800, 600);
}
public void GameOver(){
	parar();
	Icon img = new ImageIcon(this.getClass().getResource("/Imagenes/game_over.gif"));
	JLabel comp=new JLabel();
	comp.setIcon(img);
	comp.setSize(800,600);
	copia.add(comp);
}

public void win(){
	parar();	
	Icon img = new ImageIcon(this.getClass().getResource("/Imagenes/win.gif"));
	JLabel comp=new JLabel();
	comp.setIcon(img);
	comp.setSize(800,600);
	copia.add(comp); 
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

//-----METODOS PARA LOS ENEMIGOS------------------//

// agregar oponente 
public void agregarOponente(){
	enemigos.agregar_oponente(copia, this);
}

//GENERA EL DISPARO A TODOS LOS ENEMIGOS DEL BATALLON
public void generar_disparo_enemigo(){	
 	enemigos.generar_disparo_enemigo(copia, this);
}

//GENERA EL MOVIENTO PARA TODOS LOS ENEMIGOS DEL BATALLON
public void mover(){
	enemigos.mover(this);
}
//OBTIENE A TODOS LOS ENEMIGOS DEL BATALLON
public Batallon OBTENERBATALLON(){
	return enemigos;
}

public int getPuntaje(){
	return enemigos.getPuntaje();
}

//----------------------------------------------------------------//

//---------METODOS PARA EL JUGADOR-------------------------//

//Mover del jugador
public void mover(int dir){			
	jugador.movimiento(convertir_keyCode_a_direccion(dir),this);
}

public void cambiar_estado_jugador(){
	jugador.subirNivel();
}

public void reset_estado_jugador(){
	jugador.resetNivel();
}

//Genera el disparo del jugador
public void generar_disparo_jugador(){
	jugador.disparar_bala(copia,this,false);	
}

public Jugador getJugador(){
	return jugador;
}

/**
 * Este metodo actualiza la parte grafica de la vida
 * @param num_entrada Numero para actualizacion  
 * @return Nada
 */
public void ActualizarVida(int valor){
   barra.actualizarVidas(valor);
}

//--------------------------------------------------------------------//

//--------------METODOS PARA EL POWERAP----------------------//

//Metodo utilizado para que cuando el jugador mate a 4 enemigos aparesca en pantalla un powerUP
public void incEnemigosDestruidos(){
	if(this.enemigosDestruidos<3)
	 this.enemigosDestruidos++;
	else{
		enemigosDestruidos = 0;
		power.agregarAGui(copia);		
	}
}


public void cambiarBaseARoca(){
	m.CambiarBase();
}

public LosPowerUps ObtenerPower(){
	return power;
}

//-------------------------------------------------------------//

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
	
	if(colisiono == false)
	{
		colisiono = power.ColisionaConPower(recElemento, elemento);
	}
	
	return colisiono;	
}

public void eliminar_pared(){
	m.remover_pared();
}

public Barra_Inferior pedido_barra(){
	return barra;
}

public boolean si_termino_el_juego(){
	return si_termino;
}

public Gui OBTENERGUI(){
	return copia;
}

//Aca se colocan los elementos a actualizar del juego
public void update(){
	generar_disparo_enemigo();
	mover();
	jugador.update_bala();
}
}