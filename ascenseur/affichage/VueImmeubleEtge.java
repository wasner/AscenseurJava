import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import traitement.Ascenseur;
import traitement.Etage;
import traitement.Immeuble;

public class VueImmeubleEtge implements VueImeuble {
	private JFrame frame;
	private List<JButton> jb;
	private Immeuble im;

	/**
	 * Constructeur de la vue des étages de l'immeuble
	 * @param ime l'immeuble en question
	 */
	public VueImmeubleEtge(Immeuble ime) {
		// TODO Auto-generated constructor stub
		this.frame = new JFrame("Etages");
		this.frame.setResizable(false);
		this.jb = new LinkedList<JButton>();
		this.im = ime;
		this.frame.setLayout(new GridLayout(im.getEtages().size(), 1));
		for(final Etage et : im.getEtages() ){
			JButton jbMon = new JButton("Monter etage : " + Integer.toString(et.getNumEtage()));
			JButton jbDesc = new JButton("Descendre etage : " + Integer.toString(et.getNumEtage()));
			jbMon.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					im.getCo().creerRequeteExterne(et, "montant");
				}
			});
			jbDesc.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					im.getCo().creerRequeteExterne(et, "descendant");
				}
			});
			jb.add(jbMon);
			jb.add(jbDesc);
		}
		for(JButton bou : jb){
			this.frame.add(bou);
		}
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		
	}

}
