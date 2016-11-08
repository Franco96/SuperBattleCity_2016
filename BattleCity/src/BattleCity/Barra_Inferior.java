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
	
	public Barra_Inferior(Gui gui){
		inicializar_numeros();
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
		digito1=new JLabel(numeros[0]);
		digito2=new JLabel(numeros[3]);
		gui.add(digito1,1);
		digito1.setBounds(675, 650, 25, 25);
		gui.add(digito2,1);
		digito2.setBounds(700, 650, 25, 25);
	}
	
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
	
	private void inicializar_numeros(){
		numeros =new ImageIcon[10];
		for (int i=0;i<10;i++){
			numeros[i]=new ImageIcon(this.getClass().getResource("/Imagenes/"+i+".jpg"));
		}
	}
	
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
