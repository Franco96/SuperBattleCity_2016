package BattleCity;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Battle_City");
		Juego game =  new Juego();
		ventana.add(game);
        ventana.setSize(500, 500);
        ventana.setBackground(Color.BLACK);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
      
	}

}
