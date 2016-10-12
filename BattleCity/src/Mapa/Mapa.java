package Mapa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import GUI.Gui;
import TDALista.*;
import Exception.*;
import java.awt.Rectangle;

public class Mapa {
	
	//ATRIBUTOS
	private int x;
	private  int y;
	private PositionList<Celda> celdas;
	private Gui g;
	
	//CONSTRUCTOR
	public Mapa(){   
		x = 0;
		y = 0;		
	}
	
public void armarMapa(Gui gui){
	 g=gui; 
	
	
	BufferedReader  br = null;
	  
      
      try {
    	  celdas=new ListaDoblementeEnlazada<Celda>();
    	  
          String sCurrentLine;

           br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/Archivos/mapa1.txt")));

          // Para cada linea del archivo
          while ((sCurrentLine = br.readLine()) != null) {
          	// Para cada letra de la linea
          	for(int i = 0; i < sCurrentLine.length(); i++){
          		char letra = sCurrentLine.charAt(i);
          		switch (letra) {
          		case 'a' : // Si aparece una a
          			{   
          				celdas.addLast(new Ladrillo(x,y));
          				gui.add(celdas.last().element().getGrafico());
          			
          			}
          			break;
          		case 'b' :
          		{
          			celdas.addLast(new Agua(x,y));
      				gui.add(celdas.last().element().getGrafico());
          		}
          			break;
          		case 'c' :
          		{
          			celdas.addLast(new Cesped(x,y));
      				gui.add(celdas.last().element().getGrafico());
          		}
          			break;
          		case 'd':
          		{
          			celdas.addLast(new Roca(x,y));
      				gui.add(celdas.last().element().getGrafico());
          		}
          		
          		}
          		
          		if(x<775)
          		x+=celdas.last().element().getAncho();
          		else
          		{
          		x = 0;
          		if(y<575)
               	y+=celdas.last().element().getAlto();
          		}     		
          	}          
          }
      } catch (IOException e) { // Esto es por si ocurre un error
          e.printStackTrace();
      }	catch (EmptyListException e) { // Esto es por si ocurre un error
    	  System.out.println(e.getMessage());
      } 
      
      finally { // Esto es para que, haya ocurrido error o no
          try {
              if (br != null)br.close(); // Cierre el archivo
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
  }

//busca una pared removible random y la elimina
public void remover_pared(){
	try {
		Position<Celda>p=celdas.first();
		Random r = new Random();
		int i,j;
		while(p!=null){
			j=r.nextInt(celdas.size());
			p=celdas.first();
			for (i=0;i<j;i++){
				p=celdas.next(p);
			}
			if (p.element().esEliminable()){
				g.remove(p.element().getGrafico());
				g.revalidate();
				g.repaint();
				celdas.remove(p);
				p=null;
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

public boolean si_colisiona(Rectangle se_recibe){
	boolean choco=false;
	try {
		Position<Celda>p=celdas.first(),u=celdas.last();
		while(p!=null && !choco){
			if (p.element().si_esta_activo() && !p.element().esAtravesable()){
				choco=se_recibe.intersects(p.element().obtenerRectangulo());
			}
			if(p!=u)p=celdas.next(p);else p=null;
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
	return choco;
}

public boolean si_colisiona_con_efecto(Rectangle se_recibe){
	boolean choco=false;
	try {
		Position<Celda>p=celdas.first(),u=celdas.last();
		while(p!=null && !choco){
			if (p.element().si_esta_activo()&& !p.element().esAtravesable()){
				choco=se_recibe.intersects(p.element().obtenerRectangulo());
			}
			if (choco){
				p.element().afectar();;
			}
			if(p!=u)p=celdas.next(p);else p=null;
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
	return choco;
}

}


