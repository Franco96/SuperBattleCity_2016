package BattleCity;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import TDALista.*;
import Exception.*;
public class Mapa {
	
	//ATRIBUTOS
	private int x;
	private  int y;
	private PositionList<Celda> celdas;
	private Gui g;
	private Celda celdaPrototipo;
	
	//CONSTRUCTOR
	public Mapa(){   
		x = 0;
		y = 0;
	   celdaPrototipo = new Ladrillo(x,y);
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
          		    {
          		       if(!celdas.isEmpty())	
          		        x+=celdas.last().element().width;
          		        else
          		        x+=celdaPrototipo.width; 	 
          		     
          		    }else
          		         {
          		           x = 0;
          		           if(y<575)
          		             {	 
          		        	  if(!celdas.isEmpty())	   
                        	  y+=celdas.last().element().height;
          		        	  else
          		        	  y+=celdaPrototipo.height;  	  
          		             }
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


//verifica si coliciona con alguna pared

/*
public boolean colisionConPared(Line2D lineTanque,int direccion)
{
	boolean intersecta = false;
	
try{	Position<Celda>p=celdas.first();
        Position<Celda>u = celdas.last();
        Celda cel;
	    Line2D lineCelda;
	while (!intersecta && p!=null )
	{
		  cel = p.element();
		
		switch (direccion) {
        case 0:
        {
        
        		
        	lineCelda = new Line2D.Double(50, 50, 1000, 50);
          
             intersecta = lineCelda.intersectsLine(lineTanque);         
          
             break;
        }
        case 1:
        		
                 break;
        case 2: 
        		 
        		 break;
        case 3: 
                
                 break;
		}
	
	
	
		   p = p!=u ? celdas.next(p) : null; 	
	}
		
		
		
		
	
			
			
			
			
			
			
	 
	
	
	
}catch(EmptyListException e)
{
	
}catch(BoundaryViolationException e)
{
	
}catch(InvalidPositionException e)
{
	
}
	return intersecta;


}
*/

}
