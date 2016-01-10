package ascenceur.affichage;

public class InitState{
	
	private Window window = null;
	private State state = null;
	
	public InitState(Window window, State state)
	{
		this.window = window;
		this.state = state;
	}
	
	public void utiliser()
	{
		this.window.getContentPane().setVisible(false);
    	this.window.getContentPane().remove(this.window.getContentPane());
    	this.window.setContentPane(new IntroPanel(this.state));
    	this.window.getContentPane().setVisible(true);
	}
}
