package BattleCity;

public class DetenerTiempo extends Actualizador {

	public DetenerTiempo(Juego juego_recibido) {
		super(juego_recibido);
	}

	public void run(){
		{
			try{
				
			
				
			
		 if(juego_a_actualizar.OBTENERBATALLON().getEstaDetenido())	
		      {	Thread.sleep(10000);
			   juego_a_actualizar.OBTENERBATALLON().setEstaDetenido(false);
		      
		      }
		 if(juego_a_actualizar.getJugador().getEstaInmortal())
		      {Thread.sleep(15000);
			  juego_a_actualizar.getJugador().volverNormal();
		      juego_a_actualizar.getJugador().setEstaInmortal(false);
		      }
		 if( juego_a_actualizar.ObtenerPower().estaActivo())     
		      {Thread.sleep(13000);
			   juego_a_actualizar.ObtenerPower().desactivarPower();
		      }
			
			}
			catch (InterruptedException e){
				//Vacio
			}
		}	
	}
	
	

}
