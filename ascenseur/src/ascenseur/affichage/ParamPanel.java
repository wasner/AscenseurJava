package ascenseur.affichage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import ascenceur.traitement.Ascenceur;
import ascenseur.traitement.Constante;

@SuppressWarnings("serial")
public class ParamPanel extends JPanel {

	private State state;
	private JLabel label;
	private Object donnee[][];
	private String titre[];
	private JButton addAscenceur    = null;
	private JButton suppAscenceur   = null;
	private JButton retour          = null;
	private JButton appliquer          = null;
	JTable tableAscenceur           = null;
	
	public ParamPanel(State state)
	{
		super();
		this.state = state;
		
		this.addAscenceur = new JButton("+");
		this.suppAscenceur = new JButton("-");
		this.retour        = new JButton("Retour");
		this.appliquer        = new JButton("Appliquer");
		
		this.donnee = new Object[Constante.getNbAscenceur()][4];
		
		for(int i = 0; i <= state.getParamState().getNombreAscenceur(); ++i)
		{
			this.donnee[i][0] = Integer.toString(i);
			this.donnee[i][1] = Integer.toString(this.state.getParamState().getAscenceur(i).getPoidMax());
			this.donnee[i][2] = Integer.toString(this.state.getParamState().getAscenceur(i).getPersonneMax());
			this.donnee[i][3] = Integer.toString(this.state.getParamState().getAscenceur(i).getEtage(0).getNumEtage()) + ", ";
			for(int j = 1; j < this.state.getParamState().getAscenceur(i).getNombreEtagesDesservis(); ++j)
			{
				try{
					this.donnee[i][3] += Integer.toString(this.state.getParamState().getAscenceur(i).getEtage(j).getNumEtage()) + ", ";
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		
		this.titre = new String[]{"Num", "Poid Max", "Personne Max", "Etage"};
		this.label = new JLabel("Liste des ascenceurs de votre immeuble");
		this.tableAscenceur = new JTable(this.donnee, this.titre);

	}
	
	public void paintComponent(Graphics graphics)
	{
		this.label.setSize(250, 20);
		this.label.setLocation(270, 100);
		
		this.tableAscenceur.setSize(300, 160);
		this.tableAscenceur.setLocation(270, 200);
		this.tableAscenceur.getTableHeader().setSize(300, 20);
		this.tableAscenceur.getTableHeader().setLocation(270, 180);
		
		this.addAscenceur.setSize(110, 40);
		this.addAscenceur.setLocation(270, 135);
		
		this.suppAscenceur.setSize(110, 40);  
		this.suppAscenceur.setLocation(385, 135);
		
		this.retour.setSize(110, 40);
		this.retour.setLocation(565, 625);
		
		this.appliquer.setSize(110, 40);
		this.appliquer.setLocation(680, 625);
		
		this.addAscenceur.addActionListener(new BoutonCreerAscenceur());
		this.suppAscenceur.addActionListener(new BoutonSuppAscenceur());
		this.retour.addActionListener(new BoutonRetour());
		this.appliquer.addActionListener(new BoutonAppliquer());
		
		this.add(label);
		this.add(addAscenceur);
		this.add(suppAscenceur);
		this.add(retour);
		this.add(appliquer);
		this.add(this.tableAscenceur.getTableHeader());
		this.add(this.tableAscenceur);
	}
	
	class BoutonCreerAscenceur implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if(state.getParamState().creerAscenceur())
	    	{
	    		appliquer.setEnabled(true);
	    		donnee[state.getParamState().getNombreAscenceur()][0]  = Integer.toString(state.getParamState().getNombreAscenceur());
		    	donnee[state.getParamState().getNombreAscenceur()][1]  = Integer.toString(state.getParamState().getAscenceur(state.getParamState().getNombreAscenceur()).getPoidMax());
		    	donnee[state.getParamState().getNombreAscenceur()][2]  = Integer.toString(state.getParamState().getAscenceur(state.getParamState().getNombreAscenceur()).getPersonneMax());
		    	donnee[state.getParamState().getNombreAscenceur()][3]  = Integer.toString(state.getParamState().getAscenceur(state.getParamState().getNombreAscenceur()).getEtage(0).getNumEtage()) + ", ";
		    	for(int j = 1; j < state.getParamState().getAscenceur(state.getParamState().getNombreAscenceur()).getNombreEtagesDesservis(); ++j)
				{
					try{
						donnee[state.getParamState().getNombreAscenceur()][3] += Integer.toString(state.getParamState().getAscenceur(state.getParamState().getNombreAscenceur()).getEtage(j).getNumEtage()) + ", ";
					}catch(Exception e1){
						System.out.println(e1.getMessage());
					}
				}
			}
	    	else
	    	{
	    		JOptionPane jop1 = new JOptionPane();
	    		JOptionPane.showMessageDialog(null, "Vous avez atteint le nombre maximum d'ascenceur", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	}
		    	
		    	tableAscenceur = null;
		    	tableAscenceur = new JTable(donnee, titre);
		    	tableAscenceur.setSize(300, 160);
				tableAscenceur.setLocation(270, 200);
	    	}
	    }
	
	class BoutonSuppAscenceur implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	appliquer.setEnabled(true);
	    	int[] rowSelect = tableAscenceur.getSelectedRows();
	    	tableAscenceur.removeAll();
	    }
	}
	
	class BoutonRetour implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	state.getInitState().utiliser();
	    }
	}
	
	class BoutonAppliquer implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	for(int i =0; i < state.getParamState().getNombreAscenceur(); ++i)
	    	{
	    		state.getParamState().getAscenceur(i).setPoidMax(Integer.parseInt((String) tableAscenceur.getValueAt(i, 1)));
	    		state.getParamState().getAscenceur(i).setPersonneMax(Integer.parseInt((String) tableAscenceur.getValueAt(i, 2)));
	    		/*Etage etages[] = new Etage[Constante.getNbEtage()];
	    		String str = (String) tableAscenceur.getValueAt(i, 3);
	    		for(int j =0; j < str.length() / 3; ++j)
	    		{
	    			etages[i] = new Etage(Character.getNumericValue(str.charAt(j*3)));
	    		}
	    		state.getParamState().getAscenceur(i).setEtages(etages);
	    		tableAscenceur.getValueAt(i, 3);*/
	    	}
	    			
	    	appliquer.setEnabled(false);
	    }
	}
}
