import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import traitement.Ascenseur;
import traitement.Etage;

public class VuePanneau implements VueAscenseur {
	private Ascenseur ascenseurLis;
	private JFrame frame;
	private JPanel panel;
	private String textJLabel;
	private List<JButton> boutons;
	private JLabel jl;
	private JScrollPane scrollliste;
	private JLabel jlEtat;
	private JPanel jpane;

	/**
	 * Constructeur de la vue du panneau (c'est en faite l'intérieure de l'ascenseur)
	 * @param ascenseur l'ascenseur sur le qu'elle on agit
	 * @param nom nom de l'ascenseur
	 */
	public VuePanneau(Ascenseur ascenseur, final String nom) {
		// TODO Auto-generated constructor stub
		this.panel= new JPanel();
		this.ascenseurLis=ascenseur;
		this.frame = new JFrame("Panneau "+ nom);
		this.textJLabel = "Panneau "+ nom;
		this.boutons=new LinkedList<JButton>();
		this.jpane = new JPanel();
		this.jpane.setLayout(new BorderLayout());
		this.jlEtat = new JLabel("Etat : "+ ascenseurLis.getEtat());
		for(final Etage e : ascenseur.getEtages()){
			//System.out.println(e.getNumEtage());
			JButton b = new JButton(Integer.toString(e.getNumEtage()));
			b.setPreferredSize(new Dimension(100,30));
			b.setMinimumSize(new Dimension(50, 30));
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
					ascenseurLis.creerRequeteInterne(e);
					textJLabel +="<br>"+" ascenseur : "+ nom + " etage : " + e.getNumEtage() ;
					jl.setText("<html>"+textJLabel+"</html>");
					//System.out.println(textJLabel);
					
				}
			});
			boutons.add(b);
			
		}
		this.panel.setLayout(new GridLayout(ascenseur.getEtages().size()/2, 2));
		this.frame.setLayout(new BorderLayout());
		jl =new JLabel(this.frame.getTitle());
		jl.setMaximumSize(new Dimension(10, 20));
		scrollliste = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollliste.setPreferredSize(new Dimension(10, 200));
		this.jpane.add(scrollliste, BorderLayout.CENTER);
		
		for(int i=boutons.size()-1; i>=0; --i){
			this.panel.add(boutons.get(i));
		}
		JButton bStop = new JButton("STOP");
		bStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ascenseurLis.isBloquer()){
					ascenseurLis.debloquer();
					textJLabel +="<br>"+" ascenseur : "+ nom + " debloquer " ;
					jl.setText("<html>"+textJLabel+"</html>");
					
				}
				else{
					ascenseurLis.bloquer();
					textJLabel +="<br>"+" ascenseur : "+ nom + " bloquer ";
					jl.setText("<html>"+textJLabel+"</html>");
				}
				
			}
		});
		
		
		this.frame.add(panel, BorderLayout.CENTER);
		this.frame.add(bStop, BorderLayout.SOUTH);
		this.jpane.add(jlEtat, BorderLayout.NORTH);
		this.frame.add(jpane, BorderLayout.NORTH);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setResizable(false);
		this.frame.setVisible(true);
	}
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		this.jlEtat.setText("Etat : "+ ascenseurLis.getEtat());
	}

}
