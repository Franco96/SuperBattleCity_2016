package Tanques;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import com.sun.javafx.scene.paint.GradientUtils.Point;

import BattleCity.Visitor;

public class Jugador extends Tanque{

protected boolean estaInmortal;
protected int auxGolpes_Actuales;
protected int vida;
protected Icon imagenInmortal;
JLabel etiInmortal;

public Jugador(int x, int y) {
	super(x, y);
	resetNivel();
	  this.imagen = this.image[0];
	estaInmortal = false;
	auxGolpes_Actuales = 0;
	vida=3;	
	imagenInmortal = new ImageIcon(this.getClass().getResource("/Imagenes/SuperInmortal.gif"));
}

//Metodo que quita 1 vida, retorna si sigue con vida(FALSE-vivo,TRUE-muerto)
public boolean quitarVida(){
	vida--;
	this.resetNivel();
	this.resetPosicion();
	return vida==0;
}

private void resetPosicion(){
	grafico.setLocation(400, 400);
	pos.setLocation(400, 400);
}

//Metodo suma 1 vida al jugador y la retorna
public int agregarVida(){
	 vida++;
	 return vida;
}

public void resetNivel(){
	estado= new Estado1();
	nivActual=1;
	this.image=estado.ImagenesNivel();
	golpes_actuales=estado.getGolpes_que_resiste();
}
	
public void subirNivel(){
	if (nivActual!=4){
		asignarNivel(nivActual+1);
		golpes_actuales=estado.getGolpes_que_resiste();
		this.image=estado.ImagenesNivel();
	}
}
	
private void asignarNivel(int n){
	if (n>=0 && n<=4){
		switch (n) {
           case 1:  resetNivel();
                    break;
           case 2:  estado=new Estado2();
           		 nivActual=2;
                    break;
           case 3:  estado=new Estado3();
           		 nivActual=3;
           		 break;
           case 4:  estado=new Estado4();
                    nivActual=4;
                    break;
		}			
	}
}

public void volverInmortal()
{
//Guardamos los golpes que resiste el jugador antes de que se vuelva inmortal para luego recuperarlos 
	auxGolpes_Actuales = this.golpes_actuales;
	golpes_actuales +=1000;	
}

public void volverNormal(){
	etiInmortal.setVisible(false);
	this.golpes_actuales = auxGolpes_Actuales;
}

public void setEstaInmortal(boolean esta){   
	this.estaInmortal = esta;
}

public boolean getEstaInmortal(){
	return estaInmortal;
}

//Obtiene la etiqueta del aura inmortal y le cambia la posicion dependiendo de donde se movio el jugador
public JLabel getLabelInmortal(){
	if(etiInmortal == null)
		etiInmortal = new JLabel(this.imagenInmortal);

	etiInmortal.setBounds((int)this.getPos().getX()-16,(int) this.getPos().getY()-20, this.imagenInmortal.getIconWidth(),this.imagenInmortal.getIconHeight());
	
	return this.etiInmortal;
}

//Redefine el metodo de setGrafico para verificar si el jugador esta en estado inmortal y agregarle el aura inmortal
protected void setGrafico(int dir){
     super.setGrafico(dir);		
     if(this.getEstaInmortal())	
		{this.getLabelInmortal();
		etiInmortal.setVisible(true);
		}
	else
		etiInmortal.setVisible(false);	
}

public boolean aceptar(Visitor v){
	return v.visitarConTanqueJugador(this);
}		

@Override
public boolean visitarConBala(Bala b) {			
	if(!b.esBaladeEnemigo())
		 return false;
		 else{	
			golpes_actuales--;
			if (golpes_actuales==0){
				if (this.quitarVida()){
					b.OBTENERJUEGO().GameOver();
				}
				b.OBTENERJUEGO().ActualizarVida(this.vida);
			}
			return true;
		 }
}

@Override
public boolean visitarConTanqueEnemigo(Enemigo j) {	return true;}

@Override
public boolean visitarConTanqueJugador(Jugador j) {return false;}

}