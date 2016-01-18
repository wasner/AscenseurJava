import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import traitement.Ascenseur;

public class VueDeplace implements VueAscenseur {
	private Ascenseur ascen;
	private JFrame frame;

	/**
	 * constructeur de la vue qui permet le déplacement de l'ascenseur
	 * @param asc ascenseur
	 * @param nom nom de l'ascenseur
	 */
	public VueDeplace(Ascenseur asc, String nom) {
		// TODO Auto-generated constructor stub
		this.ascen= asc;
		this.frame = new JFrame(nom);
		JButton bplus =new JButton("plus");
		bplus.addActionListener(new ActionListener() {
			
			@Override
			/**
			 * permet de gérer les actions suite au différents bouton, ici pour monter
			 */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ascen.monter();
				//System.out.println("ee");
				//System.out.println(ascen.getEtageCourant().getNumEtage());
			}
		});
		JButton bmoin = new JButton("moins");
		bmoin.addActionListener(new ActionListener() {
			/**
			 * permet de gérer les actions suite au différents boutons, ici pour descendre
			 * @param e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ascen.descendre();
			}
		});
		this.frame.setLayout(new BorderLayout());
		this.frame.add(bplus, BorderLayout.SOUTH);
		this.frame.add(bmoin, BorderLayout.NORTH);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		
	}

}
