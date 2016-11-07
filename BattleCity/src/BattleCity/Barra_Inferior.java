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
	
	public Barra_Inferior(Gui gui){
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
	}
	
	public void quitarEnemigo(){
		try{
			if (!por_derrotar.isEmpty()){
				por_derrotar.last().element().setVisible(false);
				por_derrotar.remove(por_derrotar.last());
			}
		}
		catch(EmptyListException e){
			
		}
		catch(InvalidPositionException e){
			
		}
	}
}
