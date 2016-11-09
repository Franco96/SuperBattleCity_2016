package GUI;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BattleCity.Juego;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame{
	protected static final long serialVersionUID = 1L;
	protected JPanel contentPane;	
	protected Juego j;
	protected JLabel game_over;
	
	public static void main(String[] args) {		
		Gui frame = new Gui();
		frame.setTitle("Battle_City");
		frame.setVisible(true);
	}
	
	public Gui()  {
		addKeyListener(new KeyAdapter() {
			@Override			
			public void keyPressed(KeyEvent e){
				mover(e);
				mostrarPuntaje(e);
				retirarPared(e);
				estados_jug(e);
				disparar(e);
			}			
		});
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,729);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    j = new Juego(this);		   
		game_over = new JLabel("GAMEOVER");
		VentanaControles();
	}
	
	private void VentanaControles(){
		Icon imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Controles.gif"));
		JLabel panel=new JLabel(imagen);
		JFrame ventana_ayuda= new JFrame();
		ventana_ayuda.add(panel);
		panel.setBounds(0,0,608,278);
		ventana_ayuda.setBounds(100, 100, 450, 300);
		ventana_ayuda.setSize(608,278);
		ventana_ayuda.setLocationRelativeTo(null);
		ventana_ayuda.setResizable(false);
		ventana_ayuda.setTitle("Controles");
		ventana_ayuda.setVisible(true);
	}
	
	@SuppressWarnings("static-access")
	protected void mover(KeyEvent key){
		if (key.VK_UP==key.getKeyCode() || key.VK_RIGHT==key.getKeyCode() || key.VK_DOWN==key.getKeyCode() || key.VK_LEFT==key.getKeyCode()){
			j.mover(key.getKeyCode());			
			this.repaint();
		}
	}
	
	@SuppressWarnings("static-access")
	// "E" quita enemigos de pantalla
	protected void mostrarPuntaje(KeyEvent key){
		if (key.VK_E==key.getKeyCode()){
			JOptionPane.showMessageDialog(null,"Puntaje: "+j.getPuntaje()); 
		}		
	}
	
	@SuppressWarnings("static-access")
	// "A" quita un ladrillo
	protected void retirarPared(KeyEvent key){
		if (key.VK_A==key.getKeyCode()){
			j.eliminar_pared(); 
		}		
	}
	
	@SuppressWarnings("static-access")
	// "S" cambiar de estado,"D" reset estado
	protected void estados_jug(KeyEvent key){
		if (key.VK_S==key.getKeyCode()){
			j.cambiar_estado_jugador();
		}
		else{
			if (key.VK_D==key.getKeyCode()){
				j.reset_estado_jugador(); 
			}
		}
	}
	
	@SuppressWarnings("static-access")
	// "X" disparar una bala
		protected void disparar(KeyEvent key){
			if (key.VK_X==key.getKeyCode()){
				j.generar_disparo_jugador();
			}
		}
}