package Celdas;


import BattleCity.GameObject;
import BattleCity.Visitor;
import java.awt.Rectangle;

public abstract class Celda extends GameObject implements Visitor {
	  
	//ATRIBUTOS		
		protected boolean sePuede_destruir;
		protected boolean activo;
		protected Rectangle rectangulo_propio;
		protected int vida;
		
	  //CONSTRUCTOR		
		protected Celda(int x, int y) {
			super(x, y);
			activo=true;
		}


	//METODOS
		
		public boolean esEliminable(){
			return sePuede_destruir;
		}
		
		
		public Rectangle obtenerRectangulo(){
			return rectangulo_propio;
		}
		
		public boolean si_esta_activo(){
			return activo;
		}
		
		protected void desactivar(){
			activo=false;
			grafico.setVisible(false);
		}		
	}
