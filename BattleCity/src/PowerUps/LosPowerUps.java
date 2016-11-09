package PowerUps;

import java.awt.Rectangle;
import java.util.Random;
import BattleCity.DetenerTiempo;
import BattleCity.Element;
import BattleCity.Juego;
import GUI.Gui;


/*Clase para manejar los powerUp...osea para que aparescan en pantalla 
 *de manera aleatoria y ademas manejar su colision con los gameObject
 */
public class LosPowerUps {

//ATRIBUTOS 	
private PowerUp power;
private Juego miJuego;
private DetenerTiempo det;
private Thread hilo;

//CONSTRUCTOR
public LosPowerUps(Juego miJuego){
	
this.miJuego = miJuego;
power = new Casco(60,60,miJuego);



}


//METODOS


//-----METODO PARA VERIFICAR COLISION Y AFECTAR AL JUGADOR----------//
public boolean ColisionaConPower(Rectangle rectangulo ,Element elemento)
{
	boolean choca = false;
	
	
	if(power.getEstaActivo())
	    choca = power.getGrafico().getBounds().intersects(rectangulo);
	
	
	if(choca)
		choca = elemento.aceptar(power);

	
	return choca;
	
	
}

public boolean estaActivo()
{
	return power.getEstaActivo();
}

public void desactivarPower()
{
	power.desactivarPower();
}


//-------METODO PARA AGREGAR A LA GUI DE MANERA RANDOM UN POWERUP--------//

public void agregarAGui(Gui gui)
{   
	Random x0 = new Random();
	   int x = x0.nextInt(750);
	Random y0 = new Random();
	   int y = y0.nextInt(530);
    Random r = new Random();
	   int eleccion = r.nextInt(6);
	 
	   
	  switch (eleccion) {
		case 0 : 
			 power = new Casco(x,y,miJuego);
			break;
		case 1 :
			 power = new Granada(x,y,miJuego);
			break;
		case 2 :
			 power = new Pala(x,y,miJuego);
			break;
		case 3 :
			 power = new Estrella(x,y,miJuego);
			break;
        case 4 :
			 power = new Timer(x,y,miJuego);
			break;
        case 5 :
	         power = new VidaExtra(x,y,miJuego);
         	break;
	  }
	
	
	   
	    power.activarPower();
        gui.add(power.getGrafico(),0);
   
       /*Utilizamos la clase "DetenerTiempo" para que nos detenga por unos segundos el poweup para 
        *que lo agarre el jugador
        */
       
        det = new DetenerTiempo(miJuego);
        hilo = new Thread(det);
		hilo.start();
        
}
	
	
	
}
