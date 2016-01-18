import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import traitement.Ascenseur;
import traitement.Immeuble;

public class VueImeubleTrans implements VueImeuble {
	private JFrame frame;
	private Immeuble ime;
	private List<JSlider> slidList;
	private List<JPanel> pane;
	private List<JLabel> labelList;
	private List<VueAscenseurPosition> vues;
	public VueImeubleTrans(Immeuble im) {
		// TODO Auto-generated constructor stub
		frame= new JFrame("Ôtiste");
		this.ime=im;
		this.vues = new LinkedList<VueAscenseurPosition>();
		this.pane = new LinkedList<JPanel>();
		slidList=new LinkedList<JSlider>();
		this.labelList = new LinkedList<JLabel>();
		frame.setLayout(new GridLayout(1,1));
		frame.setResizable(false);
		for(Ascenseur asc : ime.getAscenseurs()){
			JSlider js =new JSlider();
			js.setMaximum(asc.getEtages().get(asc.getEtages().size()-1).getNumEtage());
			js.setMinimum(asc.getEtages().get(0).getNumEtage());
			js.setValue(asc.getEtageCourant().getNumEtage());
			js.setOrientation(SwingConstants.VERTICAL);
			js.setEnabled(false);
			JLabel jl = new JLabel("Etage : " +Integer.toString(js.getValue()));
			this.slidList.add(js);
			this.labelList.add(jl);
			VueAscenseurPosition vu = new VueAscenseurPosition(asc, this);
			this.vues.add(vu);
			asc.addVue(vu);
		}
		for(int i = 0; i<this.labelList.size() && i<this.slidList.size(); ++i){
			pane.add(new JPanel());
			pane.get(i).setLayout(new BorderLayout());
			pane.get(i).add(this.slidList.get(i), BorderLayout.SOUTH);
			pane.get(i).add(this.labelList.get(i), BorderLayout.CENTER);
			pane.get(i).add(new JLabel("Ascenceur : "+Integer.toString(i)+"  "), BorderLayout.NORTH);
		}
		for(JPanel jp : pane){
			this.frame.add(jp);
		}
		
		JButton jaction = new JButton("Action");
		jaction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ime.getCo().choisirAscenseur();
				for(Ascenseur ascense : ime.getAscenseurs()){
					ascense.triAppel();
					ascense.action();
					//System.out.println(ascense.getEtageCourant().getNumEtage());

				}
			}
		});
		this.frame.add(jaction);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		for(int i = 0; i<this.slidList.size() && i<this.vues.size(); ++i){
			slidList.get(i).setValue(this.vues.get(i).getEtage().getNumEtage());
			this.labelList.get(i).setText("Etage : "+Integer.toString(this.vues.get(i).getEtage().getNumEtage()));
			
		}
	}

}
