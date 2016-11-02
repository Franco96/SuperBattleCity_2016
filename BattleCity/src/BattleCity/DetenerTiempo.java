package BattleCity;

public class DetenerTiempo extends Actualizador {

	public DetenerTiempo(Juego juego_recibido) {
		super(juego_recibido);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		{
			try{
				
				Thread.sleep(8000);
				
			
		 if(juego_a_actualizar.OBTENERBATALLON().getEstaDetenido())	
		      juego_a_actualizar.OBTENERBATALLON().setEstaDetenido(false);
		 if(juego_a_actualizar.getJugador().getEstaInmortal())
		      {juego_a_actualizar.getJugador().volverNormal();
		      juego_a_actualizar.getJugador().setEstaInmortal(false);
		      }
		 if( juego_a_actualizar.ObtenerPower().estaActivo())     
		      juego_a_actualizar.ObtenerPower().desactivarPower();
			 
			
			}
			catch (InterruptedException e){
				//Vacio
			}
		}	
	}
	
	

}
