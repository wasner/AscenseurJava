import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class IntroPanel extends JPanel{	
	
	private State state;
	private JButton demmarer    = null;
	private JButton parametrer  = null;
	private JButton quitter     = null;
	
	public IntroPanel(State state)
	{
		this.demmarer =   new JButton("Demarrer");
		this.parametrer = new JButton("Parametrer");
		this.quitter =    new JButton("Quitter");
		this.state = state;
	}
	
	public void paintComponent(Graphics graphics)
	{
		try {
	      Image img = ImageIO.read(new File("images/logo.png"));
	      graphics.drawImage(img, 250, 100, this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
		
		demmarer.setLocation(350, 350);
		parametrer.setLocation(350, 400);
		quitter.setLocation(350, 450);
		
		demmarer.setSize(110, 40);
		parametrer.setSize(110, 40);
		quitter.setSize(110, 40);
		
		quitter.addActionListener(new BoutonQuitter());
		parametrer.addActionListener(new BoutonParametrer());
		demmarer.addActionListener(new BoutonDemmarer());
		
		this.add(demmarer);
		this.add(parametrer);
		this.add(quitter);
	}

	class BoutonQuitter implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	System.exit(0);
	    }
	}
	
	class BoutonDemmarer implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	
	    }
	}
	
	class BoutonParametrer implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	state.getParamState().utiliser();
	    }
	}
}
