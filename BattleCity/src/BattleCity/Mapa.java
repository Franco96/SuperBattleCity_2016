package BattleCity;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;

public class Mapa {
	
	//ATRIBUTOS
	private int x;
	private  int y;
	
	private Celda celda;
	
	//CONSTRUCTOR
	public Mapa()
	{   
		x = 0;
		y = 0;
		
	}

	
public void armarMapa(Gui gui){
	  
	
	
	
	BufferedReader br = null;
      
      String fileName = "C:/Users/Lautaro/Documents/GitHub/SuperBattleCity_2016/BattleCity/src/Archivos/mapa1.txt";
      
      try {

          String sCurrentLine;

          br = new BufferedReader(new FileReader(fileName));

          // Para cada linea del archivo
          while ((sCurrentLine = br.readLine()) != null) {
          	// Para cada letra de la linea
          	for(int i = 0; i < sCurrentLine.length(); i++){
          		char letra = sCurrentLine.charAt(i);
          		switch (letra) {
          		case 'a' : // Si aparece una a
          			{    celda = new Ladrillo(x,y);
          				gui.add(celda.getGrafico());
          			
          			}
          			break;
          		case 'b' :
          		{
          			celda = new Agua(x,y);
      				gui.add(celda.getGrafico());
          		}
          			break;
          		case 'c' :
          		{
          			celda = new Cesped(x,y);
      				gui.add(celda.getGrafico());
          		}
          			break;
          		case 'd':
          		{
          			celda = new Roca(x,y);
      				gui.add(celda.getGrafico());
          		}
          		
          		}
          		
          		if(x<1320)
          		x+=celda.width;
          		else
          		{
          		x = 0;
               	y+=celda.height;
          		}
          		
          	}
          
          }
      } catch (IOException e) { // Esto es por si ocurre un error
          e.printStackTrace();
      } finally { // Esto es para que, haya ocurrido error o no
          try {
              if (br != null)br.close(); // Cierre el archivo
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
  }
}