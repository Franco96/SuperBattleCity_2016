package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
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
				//ACCIONES PARA LAS TECLAS
				mover(e);
				añadirEnemigo(e);
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
	
	
	protected void añadirEnemigo(KeyEvent key)
	{
		j.añadirEnemigo(key.getKeyCode());
	}
	
	protected void mover(KeyEvent key){
		j.mover(key.getKeyCode());
		
		this.repaint();
	
	
	}

}