package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;

import BattleCity.Juego;
import BattleCity.Mapa;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Juego j;
	private Time tiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Gui frame = new Gui();
					frame.setTitle("Battle_City");
					frame.setVisible(true);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Gui() throws InterruptedException {
		addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e){
				mover(e);
				agregar(e);
				quitar(e);
				mostrarPuntaje(e);
				retirarPared(e);
				estados_jug(e);
			}
			
		});
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		   j = new Juego(this);
		
		   

		   Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() {
		        @Override
		        public void run()
		        {
		            j.mover();
		        }
		        };
		        // Empezamos dentro de 0ms y luego lanzamos la tarea cada 425ms
		    timer.schedule(task, 0, 425);
		   
		   
		   
//		 tiempo = new Time(j);
//		 tiempo.start();
	    
	
	}
	
	protected void mover(KeyEvent key){
		if (key.VK_UP==key.getKeyCode() || key.VK_RIGHT==key.getKeyCode() || key.VK_DOWN==key.getKeyCode() || key.VK_LEFT==key.getKeyCode()){
			j.mover(key.getKeyCode());			
			this.repaint();
		}
	}
	// "Q" agrega enemigos en pantalla
	protected void agregar(KeyEvent key){
		if (key.VK_Q==key.getKeyCode()){
			j.agregarOponente(this);
			this.repaint();
		}		
	}
	
	// "W" quita enemigos de pantalla
	protected void quitar(KeyEvent key){
		if (key.VK_W==key.getKeyCode()){
			j.quitarOponente(this);;
			this.repaint();
		}		
	}
	
	// "E" quita enemigos de pantalla
		protected void mostrarPuntaje(KeyEvent key){
			if (key.VK_E==key.getKeyCode()){
				JOptionPane.showMessageDialog(null,"Puntaje: "+j.getPuntaje()); 
			}		
		}
	// "A" quita un ladrillo
	protected void retirarPared(KeyEvent key){
		if (key.VK_A==key.getKeyCode()){
			j.eliminar_pared(); 
		}		
	}
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
	
}