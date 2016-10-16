package BattleCity;

import java.util.Random;

import Exception.BoundaryViolationException;
import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;

public class Batallon {
	protected PositionList<Enemigo> oponentes;
	protected int puntos_por_muertes_de_enemigos;
	
	public Batallon(){
		oponentes= new ListaDoblementeEnlazada<Enemigo>();
		puntos_por_muertes_de_enemigos=0;
	}
	
	//Agrega enemigos a la lista de enemigos
	public void agregarOponente(Gui gui){
		try{
			Random r = new Random();
			oponentes.addLast(new EnemigoBasico(r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32)));
			gui.add(oponentes.last().element().getGrafico(),0);
			gui.revalidate();
			gui.repaint();
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
	
	//Elimina enemigo de la lista de enemigos
	public void quitarOponente(Gui gui){
		try{
			if (!oponentes.isEmpty()){
				Position<Enemigo> p=oponentes.last();
				puntos_por_muertes_de_enemigos+=p.element().getPuntaje_por_Destruccion();
				gui.remove(oponentes.last().element().getGrafico());
				gui.revalidate();
				gui.repaint();
				oponentes.remove(p);
			}		
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
	
	//Retorna puntos acumulados por muertes de enemigos
	public int puntos_acumulados(){
		return puntos_por_muertes_de_enemigos;
	}
	
	public void mover(){
		try {
			if(!oponentes.isEmpty())
			{
			Position<Enemigo>p=oponentes.first(),u=oponentes.last();
			while(p!=null){
				p.element().mover(0);			
				if(p!=u)p=oponentes.next(p);else p=null;			
			}
			}
		}
		catch (InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		catch (BoundaryViolationException e){
			System.out.println(e.getMessage());
		}
		catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
}
