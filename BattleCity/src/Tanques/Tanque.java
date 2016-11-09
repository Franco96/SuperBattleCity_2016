package Tanques;

import java.awt.Rectangle;
import javax.swing.Icon;
import BattleCity.Element;
import BattleCity.GameObject;
import BattleCity.Juego;
import BattleCity.Visitor;
import Exception.BoundaryViolationException;
import Exception.EmptyListException;
import Exception.InvalidPositionException;
import GUI.Gui;
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;

public abstract  class Tanque extends GameObject implements Element,Visitor {
//ATRIBUTOS
    protected Icon image[];
    protected int ultima_direccion;
    protected PositionList<Bala> balas_disparadas;
    protected Estado estado;    
    protected int nivActual;
    protected int golpes_actuales;
    
//CONSTRUCTOR
    
protected Tanque(int x, int y) {
	super(x, y);
    this.image = new Icon[8];  
    this.width = 50;
    this.height = 50;
    balas_disparadas= new ListaDoblementeEnlazada<Bala>();	
}
	
   //METODOS
	
public void disparar_bala(Gui g,Juego j,boolean balaDequien){		
   if (balas_disparadas.size()<estado.getDisparos_simultaneos()){
	Bala bala_jugador=null;
	switch (ultima_direccion) {
       case 0:  bala_jugador=new Bala(pos.x+17,pos.y-14,ultima_direccion,j,balaDequien);
                break;
       case 1:  bala_jugador=new Bala(pos.x+17,pos.y+50,ultima_direccion,j,balaDequien);
                break;
       case 2:  bala_jugador=new Bala(pos.x-15,pos.y+17,ultima_direccion,j,balaDequien);
       		 break;
       case 3:  bala_jugador=new Bala(pos.x+50,pos.y+17,ultima_direccion,j,balaDequien);
                break;
	}		
	
	if(nivActual == 4)
	bala_jugador.setBalaEnNivel4(true);		
	
	balas_disparadas.addFirst(bala_jugador);		
	
	g.add(bala_jugador.getGrafico(),0);
	Thread movimiento1= new Thread(bala_jugador);
	movimiento1.start();  
   }
}	
	
public void update_bala(){
	try {
		
		if(!balas_disparadas.isEmpty())
		{Position<Bala>p=balas_disparadas.first(),u=balas_disparadas.last();
		while(p!=null){
			if (!p.element().si_esVisible()){
				Position<Bala>aux;	
				if(p!=u)aux=balas_disparadas.next(p);else aux=null;
				balas_disparadas.remove(p);
				p=aux;
			}
			if(p!=u && p!=null)p=balas_disparadas.next(p);else p=null;			
		}
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
	
protected void setGrafico(int dir){
	if(this.grafico != null){
		this.grafico.setIcon(this.image[dir]);
		this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
	}
}

private boolean mover(int dir){

	boolean colisiona = false;
	
switch (dir) {
	case 0 : //Arriba
		if(pos.y>=1)pos.setLocation(pos.x, pos.y - 1);
		else colisiona = true;
		break;
	case 1 : //Abajo
		if(pos.y<=549)pos.setLocation(pos.x, pos.y + 1);
		else colisiona = true;
		break;
	case 2 : //Izquierda
		if(pos.x>=1) pos.setLocation(pos.x - 1, pos.y);
		else colisiona = true;
		break;	
    case 3 : //Derecha
		if(pos.x<=749)pos.setLocation(pos.x + 1, pos.y);
		else colisiona = true;
		break;
             }

return colisiona; 
}

public boolean movimiento(int dir,Juego h){
	ultima_direccion=dir;
	
	Rectangle proximo_movimiento=null;
	int indice=0;
	boolean colisiono=false;
	while (indice<estado.getVelocidadMovimiento()&& !colisiono){
		switch (dir){
		case 0 : //Arriba
			proximo_movimiento=new Rectangle(getPos().x,getPos().y-1,getAncho(),getAlto());
			break;
		case 1 ://Abajo
			proximo_movimiento=new Rectangle(getPos().x,getPos().y+1,getAncho(),getAlto());			 
			break;
		case 2 : //Izquierda
			proximo_movimiento=new Rectangle(getPos().x-1,getPos().y,getAncho(),getAlto());			
			break;
		case 3 : //Derecha
			proximo_movimiento=new Rectangle(getPos().x+1,getPos().y,getAncho(),getAlto());			  
			break;
		}
		colisiono=h.COLLIDER(proximo_movimiento,this);	
		if (!colisiono){
			colisiono = mover(dir);
			
		}
		indice++;
	}
	 setGrafico(dir);	 
	return colisiono;	
}
}