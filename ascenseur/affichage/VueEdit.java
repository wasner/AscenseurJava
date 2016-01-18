import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import traitement.Ascenseur;
import traitement.Constante;
import traitement.Etage;
import traitement.Immeuble;

public class VueEdit implements VueAscenseur {
	
	private JFrame frame;
	private List<VueImeuble> vues;
	private Ascenseur ascenseur;
	
	private JLabel nomVue;

	private JLabel lblFPoidMax;
	private JTextField poidMax;
	
	private JLabel lblFPersonnesMax;
	private JTextField personnesMax;
	
	private JLabel lblFEtageDesservit;
	
	private Box horizontalBox1;
	private Box horizontalBox2;
	private Box horizontalBox3;
	
	private Box verticalBox;
	private Box verticalCenterBox;
	
	private Box globalBox;
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private JScrollPane scrollliste;
	
	private JList<String> list;
	private String[] data; 
	List<Etage> etages;
	
	private JButton remove;
	private JButton appliquer;
	
	public VueEdit(Ascenseur ascenseure, List<VueImeuble> vuess)
	{
		this.ascenseur = ascenseure;
		this.vues = vuess;
		Font font = new Font("Arial",Font.BOLD,20);
		
		this.etages = new LinkedList<Etage>();
		
		this.frame = new JFrame();
		this.frame.setTitle("�tiste");
		this.frame.setResizable(false);
		this.frame.setLayout(new BorderLayout());
		
		verticalBox = Box.createVerticalBox();
		verticalCenterBox = Box.createVerticalBox();
		horizontalBox1 = Box.createHorizontalBox();
		horizontalBox2 = Box.createHorizontalBox();
		horizontalBox3 = Box.createHorizontalBox();
		
		appliquer = new JButton("Appliquer");
		appliquer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ascenseur.setPoidMax(Integer.parseInt(poidMax.getText()));
				ascenseur.setPersonneMax(Integer.parseInt(personnesMax.getText()));
				ascenseur.setEtages(etages);
				for(int i =0; i < vues.size(); ++i)
					vues.get(i).miseAJour();
				frame.dispose();
			}
		});
		appliquer.setMaximumSize(new Dimension(200, 300));
		
		remove = new JButton("Supprimer");
		remove.setMaximumSize(new Dimension(200, 300));
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!list.isSelectionEmpty())
				{
					if(etages.size()-1 > 0 && list.getSelectedIndex() < etages.size())
					{
						etages.remove(list.getSelectedIndex());
						data = new String[Constante.getNbEtage()];
						for(int i =0; i < etages.size(); ++i)
						{
							data[i] = etages.get(i).toString();
						}
						list.setListData(data);
						if(etages.size()-1 == 0)
						{
							remove.setEnabled(false);
						}
						for(int i =0; i < vues.size(); ++i)
							vues.get(i).miseAJour();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selectionnez un etage", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
	
		
		nomVue = new JLabel("Edition Ascenseur");
		nomVue.setFont(font);
		nomVue.setPreferredSize(new Dimension(200, 60));

		lblFPoidMax =        new JLabel("Poid Maximum : ");
		lblFPersonnesMax =   new JLabel("Personne Max : ");
		lblFEtageDesservit = new JLabel("Etage Desservit :");
		
		personnesMax    = new JTextField();
		personnesMax.setText(Integer.toString(ascenseur.getPersonneMax()));
		
		poidMax         = new JTextField();
		poidMax.setText(Integer.toString(ascenseur.getPoidMax()));
		
		data = new String[Constante.getNbEtage()];
		int i = 0;
		
		for(Etage etage : ascenseur.getEtages())
		{
			etages.add(etage);
			data[i] = etage.toString();
			++i;
		}
		
		list = new JList<String>(data);
		list.setPreferredSize(new Dimension(180, 300));
		this.list   = new JList<String>(data);
		scrollliste = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollliste.setPreferredSize(new Dimension(400, 130)); 
		
		northPanel.add(nomVue);
		
		horizontalBox1.add(lblFPoidMax);
		horizontalBox1.add(poidMax);
		verticalCenterBox.add(horizontalBox1);
		horizontalBox2.add(lblFPersonnesMax);
		horizontalBox2.add(personnesMax);
		verticalCenterBox.add(horizontalBox2);
		horizontalBox3.add(lblFEtageDesservit);
		verticalCenterBox.add(horizontalBox3);
		verticalCenterBox.add(scrollliste);
		
		centerPanel.add(verticalCenterBox);

		verticalBox.add(remove);
		verticalBox.add(appliquer);
		
		southPanel.add(verticalBox);
		
		this.frame.add(this.northPanel, BorderLayout.NORTH);
		this.frame.add(this.centerPanel, BorderLayout.CENTER);
		this.frame.add(this.southPanel, BorderLayout.SOUTH);
		
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);
	}


	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		
	}

}
