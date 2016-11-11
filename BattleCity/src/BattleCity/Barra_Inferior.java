package BattleCity;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

public class Barra_Inferior {
	protected Icon imagen;
	protected PositionList<JLabel> por_derrotar;
	protected Icon numeros[];
	protected JLabel digito1;
	protected JLabel digito2;
	protected JLabel puntaje[];
	
	public Barra_Inferior(Gui gui){
		inicializar_numeros();
		inicializar_puntaje(gui);
		por_derrotar = new ListaDoblementeEnlazada<JLabel>();
		imagen=new ImageIcon(this.getClass().getResource("/Imagenes/nave_menu.jpg"));
		JLabel barra=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/barra.jpg")));
		gui.add(barra);
		barra.setBounds(0,600, 800, 100);
		int i=0,posX=25,posY=625;
		while (i<10){
			JLabel barra1=new JLabel(imagen);
			por_derrotar.addLast(barra1);
			gui.add(barra1,1);
			barra1.setBounds(posX, posY, 25, 25);
		    posX+=25;
		    if (posX>125){
		    	posY+=25;
		    	posX=25;
		    }
			i++;
		}
		agregarVisorVida(gui);
		digito1=new JLabel();
		digito2=new JLabel();
		gui.add(digito1,1);
		digito1.setBounds(675, 650, 25, 25);
		gui.add(digito2,1);
		digito2.setBounds(700, 650, 25, 25);
		actualizarVidas(3);
	}
	
	/**
	   * Metodo privado para inicializar el puntaje del jugador
	   * @param Nada
	   * @return Nada
	   */
	private void inicializar_puntaje(Gui g){
		int posY=650;
		puntaje =new JLabel[10];
		for (int i=0,posX=260;i<10;i++, posX=posX+25){
			puntaje[i]=new JLabel(numeros[0]);
			g.add(puntaje[i],1);
			puntaje[i].setBounds(posX, posY, 25, 25);
		}
	}
 
	/**
	   * Metodo para actualizar el puntaje que se muestra
	   * @param Nada
	   * @return Nada
	   */
	public void actualizarPuntaje(int numero_a_mostrar){
		int posArreglo=9,digito=0;
		while (numero_a_mostrar!=0 && posArreglo>=0){
			digito=numero_a_mostrar%10;
			puntaje[posArreglo].setIcon(numeros[digito]);
			numero_a_mostrar/=10;
			posArreglo--;
		}
	}
	
	/**
	   * Este metodo elimina un tanque del hub de muestra
	   * @param Nada
	   * @return Nada
	   */
	public void quitarEnemigo(){
		try{
			if (!por_derrotar.isEmpty()){
				por_derrotar.last().element().setVisible(false);
				por_derrotar.remove(por_derrotar.last());
			}
		}
		catch(EmptyListException e){
			//Nada
		}
		catch(InvalidPositionException e){
			//Nada
		}
	}
	
	/**
	   * Este metodo carga las imagenes de los digitos del arreglo numeros[]
	   * @param Nada  
	   * @return Nada
	   */
	private void inicializar_numeros(){
		numeros =new ImageIcon[10];
		for (int i=0;i<10;i++){
			numeros[i]=new ImageIcon(this.getClass().getResource("/Imagenes/"+i+".jpg"));
		}
	}
	
	/**
	   * Este metodo actualiza las vidas de que se muestran en la barra de estado
	   * @param num_entrada Numero para actualizacion  
	   * @return Nada
	   */
	public void actualizarVidas(int num_entrada){
		int dig_aux=0;
		dig_aux=num_entrada%10;
		digito2.setIcon(numeros[dig_aux]);
		dig_aux=num_entrada/10;
		digito1.setIcon(numeros[dig_aux]);
	}
	
	/**
	   * Este metodo genera en pantalla el hub que rodea los digitos de la vida
	   * @param g Es el jframe sobre el cual hay que dibujar el hub  
	   * @return Nada
	   */
	private void agregarVisorVida(Gui g){
		JLabel aux=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/I.jpg")));
		g.add(aux,1);
		aux.setBounds(650, 625, 25, 25);
		
		aux=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/P.jpg")));
		g.add(aux,1);
		aux.setBounds(675, 625, 25, 25);
		
		aux=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/nave_vida.jpg")));
		g.add(aux,1);
		aux.setBounds(650, 650, 25, 25);
	}
}
