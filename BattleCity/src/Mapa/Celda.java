package Mapa;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Rectangle;
import BattleCity.*;

public abstract class Celda extends GameObject {

	  //ATRIBUTOS
		
		protected Icon imagen;
		protected boolean sePuede_destruir;
		protected boolean sePuede_atravesar;
		protected boolean activo;
		protected Rectangle rectangulo_propio;
		protected int vida;
		
	  //CONSTRUCTOR
		
		protected Celda(int x, int y) {
			super(x, y);
			activo=true;
		}

		public JLabel getGrafico(){
			if(grafico == null){
				grafico = new JLabel(imagen);
				grafico.setBounds(this.pos.x, this.pos.y, width, height);
			}
			
			return grafico;
		}
		
		public boolean esEliminable(){
			return sePuede_destruir;
		}
		
		public boolean esAtravesable(){
			return sePuede_atravesar;
		}
		
		public Rectangle obtenerRectangulo(){
			return rectangulo_propio;
		}
		
		public boolean si_esta_activo(){
			return activo;
		}
		
		public void desactivar(){
			activo=false;
			grafico.setVisible(false);
		}
		
		abstract public void afectar();
	}
