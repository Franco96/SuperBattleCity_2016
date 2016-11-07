package BattleCity;

import Celdas.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import Celdas.Ladrillo;
import Celdas.Roca;
import GUI.Gui;
import TDALista.*;
import Exception.*;
import java.awt.Rectangle;

public class Mapa {
	
	//ATRIBUTOS
	protected int x;
	protected  int y;
	protected PositionList<Celda> celdas;
	protected Gui g;
	private int xBase;
	private int yBase;
	//CONSTRUCTOR
public Mapa(){   
	x = 0;
	y = 0;	
	xBase = 0;
	yBase = 0;
}
	
public void armarMapa(Gui gui){
	 g=gui; 	
	BufferedReader  br = null;      
      try {
    	  celdas=new ListaDoblementeEnlazada<Celda>();
    	  
          String sCurrentLine;

           br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/Archivos/Mapa_del_Escenario.txt")));

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
          		   break;
          		case 'e':
          		{   xBase = x;
          			yBase = y;
          			celdas.addLast(new Base(x,y));
      				gui.add(celdas.last().element().getGrafico());
          		}  
          		   break;
          		
          		}
          		
          	 if(celdas.isEmpty())	
          	 {
          		if(x<775)
              		x+=25;
              		else
              		{
              		x = 0;
              		if(y<575)
                   	y+=25;
              		}
          	 }
          	 
          	 else
          	 {	if(x<775)
          		x+=celdas.last().element().getAncho();
          		else
          		{
          		x = 0;
          		if(y<575)
               	y+=celdas.last().element().getAlto();
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


//COLISIONADOR DE BALAS Y TAMQUES CON CELDAS
public boolean si_colisiona(Rectangle se_recibe,Element elemento){
	boolean choco=false;
	try {
	
	if(!celdas.isEmpty())	
	{	Position<Celda>p=celdas.first(),u=celdas.last();
		while(p!=null && !choco){
			if (p.element().si_esta_activo()){
				choco=se_recibe.intersects(p.element().obtenerRectangulo());
			}
			if(choco)
			{
			   choco = elemento.aceptar(p.element());	
			}
			
			
			if(p!=u)p=celdas.next(p);else p=null;
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
	return choco;
}



public void CambiarBase()
{
 //GUARDAMOS LAS VARIABLES POR SI SE TIENE QUE CAMBIAR NUEVAMENTE LA BASE	
	int auxX = xBase;
	int auxY = yBase;
	
	xBase -=50;
	yBase -=50;
	
 
	for(int j = 0 ; j<6;j++)	

   {
          if(j<2||j>3)
	          {
        	       for(int i = 0;i<4;i++)
	                  {
		                 this.cambiarCeldaPorRoca(xBase, yBase);
		                 yBase +=25;
	                   }
	              yBase -=4*25;
	           }
          else
              {
	              for(int i = 0;i<2;i++)
		              {
			             this.cambiarCeldaPorRoca(xBase, yBase);
			             yBase +=25;
		              }
		         yBase -=2*25;
               }

	xBase +=25;
}	
	
	xBase = auxX;
	yBase = auxY;
	
}








private void cambiarCeldaPorRoca(int x ,int y)
{
	boolean encontre = false;
try{
	Position<Celda>p=celdas.first(),u=celdas.last();
	while(p!=null&&!encontre){
		
	  if((p.element().getPos().getX() == x) &&(p.element().getPos().getY() == y) )
		{   g.remove(p.element().getGrafico());	
			celdas.remove(p);
			encontre = true;
			
		}
		
	  
	  if(p!=u)p=celdas.next(p);else p=null;
	}
	
	
	celdas.addLast(new Roca(x,y));
	g.add(celdas.last().element().getGrafico());
	
	
	
}catch (InvalidPositionException e){
	System.out.println(e.getMessage());
}
catch (BoundaryViolationException e){
	System.out.println(e.getMessage());
}
catch (EmptyListException e){
	System.out.println(e.getMessage());
}	

}




public void eliminarMapa(){
	try {
		Position<Celda>p=celdas.first(),u=celdas.last();
		while(p!=null){ 
			  	
				p.element().getGrafico().setVisible(false); 
				
				
			  Position<Celda> aux = null;
          if(p!=u)		
			    aux = celdas.next(p); 
				 
             celdas.remove(p);
				
              
				
           p = aux;		
			}
			
	}catch (InvalidPositionException e){
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
