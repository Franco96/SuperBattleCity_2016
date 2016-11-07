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
	int anteriorMovido;    
	Gui copia;
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
	anteriorMovido = 0;
 	m.armarMapa(gui);  	
 	enemigos = new Batallon(); 	
	gui.add(jugador.getGrafico());
	Thread j1=new Thread(actualizador);
	j1.start();
	si_termino=false;
	
	barra=new Barra_Inferior(copia);
	
	//Actualizador para controlar el ingreso de los enemigos al juego
	ActualizadorDeApariciones actualizador_oponentes= new ActualizadorDeApariciones(this);
	Thread j2=new Thread(actualizador_oponentes);
	j2.start();
	
//	Icon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/SuperInmortal.gif"));
//	
//   JLabel eti = new JLabel(imagen);
//   
//	eti.setBounds(500, 100, imagen.getIconWidth(), imagen.getIconHeight());	
	
	gui.add(jugador.getLabelInmortal(),0);	

	gui.add(jugador.getLabelInmortal(),0);
	
	
	

}

public Barra_Inferior pedido_barra(){
	return barra;
}

public boolean si_termino_el_juego(){
	return si_termino;
}


private void parar(){
	actualizador.terminar_juego();
	m.eliminarMapa();	
	enemigos.eliminarEnemigos(copia);	
	copia.remove(jugador.getGrafico());	
	si_termino=true;
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

//Nuevo agregar oponente 
public void agregarOponente(){
	enemigos.agregar_oponente(copia, m);
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
	
	if(colisiono == false)
	{
		colisiono = power.ColisionaConPower(recElemento, elemento);
	}
	
	return colisiono;	
}

//METODO PARA OBTENER LA GUI
public Gui OBTENERGUI(){
	return copia;
}

public LosPowerUps ObtenerPower(){
	return power;
}

public void incEnemigosDestruidos()
{
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

//Aca se colocan los elementos a actualizar del juego
public void update(){
	generar_disparo_enemigo();
	mover();
	jugador.update_bala();
}

public Jugador getJugador(){
	return jugador;
}
}