package PowerUps;

import java.awt.Rectangle;
import java.util.Random;
import BattleCity.DetenerTiempo;
import BattleCity.Element;
import BattleCity.Juego;
import GUI.Gui;

public class LosPowerUps {

//ATRIBUTOS 
	
	
private PowerUp power;

private Juego miJuego;


public LosPowerUps(Juego miJuego){
	
this.miJuego = miJuego;
	
power = new Casco(60,60,miJuego);

}




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


public void agregarAGui(Gui gui)
{   //Desactivo el powerUp que tenia antes
	  power.desactivarPower();
	
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
    DetenerTiempo det = new DetenerTiempo(miJuego);
    	Thread j3=new Thread(det);
		j3.start();
        
}
	
	
	
}
