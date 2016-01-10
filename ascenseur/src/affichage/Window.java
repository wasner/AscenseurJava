package ascenceur.affichage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	private State state;
	
	public Window()
	{
		this.state = new State(this);
		this.state.getInitState().utiliser();
		this.setTitle("Otiste Corp");
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
}
