import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import traitement.Ascenseur;
import traitement.AscenseurConcret;
import traitement.Constante;
import traitement.Controleur;
import traitement.Etage;
import traitement.Immeuble;

public class VueInit implements VueImeuble {

	private Immeuble immeuble;
	
	private JFrame frame;
	private JLabel titre;
	private JPanel buttonPanel;
	private Box ajoutAscenceurBoutonBox;
	private JPanel nombreEtagePanel;
	private Box horizontalBox;
	private Box verticalBox;
	
	private Box numEtageMaxBox;
	private Box numEtageMinBox;
	private Box numEtageBox;
	
	private JScrollPane scrollliste;
	private JLabel lblFNombreEtage;
	private JComboBox tfFNombreEtage;
	
	private JLabel lblFNumEtageMin;
	private JComboBox tfFNumEtageMin;
	
	private JButton add;
	private JButton edit;
	private JButton remove;
	private JButton appliquer;
	
	private JList list;
	private String[] data; 
	List<Ascenseur> ascenseurs;
	
	
	
	public VueInit(Immeuble immeublee)
	{
		this.immeuble = immeublee;
		
		//Chargement des donnée
		this.ascenseurs = new LinkedList<Ascenseur>();
		this.data =new String[Constante.getNbAscenceur()];
		List<Etage> etages = new LinkedList<Etage>();
		for(int i = 0; i<Constante.getNbEtage(); ++i)
			etages.add(new Etage(Constante.getNumEtageMin()+i));
		for(int i = 0; i < 5; ++i)
		{
			this.ascenseurs.add(new AscenseurConcret(i, 600, 6, etages));
			this.data[i] = ascenseurs.get(i).toString();
		}
		this.immeuble.setAscenseurs(ascenseurs);
		
		//Layout et Fenetre
		
			this.frame = new JFrame();
			this.frame.setTitle("�tiste");
			this.frame.setResizable(false);
			
			this.numEtageMaxBox = Box.createHorizontalBox();
			this.numEtageMinBox = Box.createHorizontalBox();
			this.numEtageBox = Box.createVerticalBox();
			
			this.ajoutAscenceurBoutonBox = Box.createVerticalBox();
			this.horizontalBox = Box.createHorizontalBox();
			this.verticalBox = Box.createVerticalBox();
			
			this.nombreEtagePanel = new JPanel();
			this.nombreEtagePanel.setPreferredSize(new Dimension(200, 100));
			this.buttonPanel  = new JPanel();
		
		//Creatiion des bouton
		
			Font font = new Font("Arial",Font.BOLD,15);
			Font fontTitre = new Font("Arial",Font.BOLD,35);
			
			this.titre = new JLabel("�tiste Company");
			this.titre.setPreferredSize(new Dimension(400, 60));
			
			this.titre.setFont(fontTitre);
			
			this.add    = new JButton("Ajouter");
			this.add.setMaximumSize(new Dimension(150, 40));
			this.add.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(ascenseurs.size() < Constante.getNbAscenceur())
					{
						remove.setEnabled(true);
						edit.setEnabled(true);
						appliquer.setEnabled(true);
						List<Etage> liste = new LinkedList<Etage>();
						if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) <= 0)
							for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) + Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
							{
								liste.add(new Etage(i));
							}
						
						if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) > 0)
							for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) - Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
							{
								liste.add(new Etage(i));
							}
						
						
						ascenseurs.add(new AscenseurConcret(ascenseurs.size(), 600, 6, liste));
						immeuble.setAscenseurs(ascenseurs);
						data[ascenseurs.size()-1] = ascenseurs.get(ascenseurs.size()-1).toString();
						list.setListData(data);
					}
					else
					{
						add.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Nombre maximum d'ascenceurs", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			
			this.edit   = new JButton("Editer");
			this.edit.setMaximumSize(new Dimension(150, 40));
			this.edit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(!list.isSelectionEmpty() && list.getSelectedIndex() <= ascenseurs.size()-1)
					{
						int index = list.getSelectedIndex();
						ascenseurs.get(index).addVue(new VueEdit(ascenseurs.get(index), immeuble.getVue()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Selectionnez un ascenseur", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
						
				}
			});
			
			this.remove = new JButton("Supprimer");
			this.remove.setMaximumSize(new Dimension(150, 40));
			this.remove.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(!list.isSelectionEmpty())
					{
						if(ascenseurs.size() > 0 && list.getSelectedIndex() < ascenseurs.size())
						{
								add.setEnabled(true);
								ascenseurs.remove(list.getSelectedIndex());
								data = new String[Constante.getNbAscenceur()];
								for(int i =0; i < ascenseurs.size(); ++i)
								{
									data[i] = ascenseurs.get(i).toString();
								}
								list.setListData(data);
								if(ascenseurs.size()-1 == 0)
								{
									remove.setEnabled(false);
								}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Selectionnez un ascenseur", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			
			
			this.appliquer = new JButton("Appliquer");
			this.appliquer.setMaximumSize(new Dimension(150, 40));
			this.appliquer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int i=0;
					for(Ascenseur as : immeuble.getAscenseurs()){
						as.setEtageCourant(immeuble.getEtages().get(0));
						as.addVue(new VuePanneau(as, Integer.toString(i)));
						++i;
					}
					immeuble.addVue(new VueImeubleTrans(immeuble));
					immeuble.addVue(new VueImmeubleEtge(immeuble));
					immeuble.getCo().setAscenseurs(immeuble.getAscenseurs());
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.dispose();
				}
			});
			
			this.lblFNombreEtage = new JLabel("Nombres d'étages");
			this.lblFNombreEtage.setFont(font);
			
	        this.tfFNombreEtage = new JComboBox();
	        for(int i =1; i <= Constante.getNbEtage(); ++i)
	        	this.tfFNombreEtage.addItem(i);
	        this.tfFNombreEtage.setSelectedIndex(Constante.getNbEtage()-1);
	        this.lblFNumEtageMin = new JLabel("Numeros de l'étage minimum");
	        this.lblFNumEtageMin.setFont(font);
	        this.tfFNumEtageMin = new JComboBox();
	        this.tfFNumEtageMin.setPreferredSize(new Dimension(100, 25));
	        for(int i =Constante.getNumEtageMin(); i < Constante.getNbEtage(); ++i)
	        	this.tfFNumEtageMin.addItem(i);
	        
	        this.tfFNumEtageMin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					List<Etage> liste = new LinkedList<Etage>();
					if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()))
						for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) + Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
						{
							liste.add(new Etage(i));
						}
						
					if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) >= Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()))
						for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) - Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
						{
							liste.add(new Etage(i));
						}
					
					for(Ascenseur ascenseur : ascenseurs)
						ascenseur.setEtages(liste);
					
					data = new String[Constante.getNbAscenceur()];
					for(int i =0; i < ascenseurs.size(); ++i)
					{
						data[i] = ascenseurs.get(i).toString();
					}
					
					list.setListData(data);
						
					
				}
			});
	        
	        this.tfFNombreEtage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					List<Etage> liste = new LinkedList<Etage>();
					
					if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()))
						for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) + Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
						{
							liste.add(new Etage(i));
						}
					
						
						
					if(Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()) >= Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()))
						for(int i = Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); i < Integer.parseInt(tfFNombreEtage.getSelectedItem().toString()) - Integer.parseInt(tfFNumEtageMin.getSelectedItem().toString()); ++i)
						{
							liste.add(new Etage(i));
						}
					
					for(Ascenseur ascenseur : ascenseurs)
						ascenseur.setEtages(liste);
					
					data = new String[Constante.getNbAscenceur()];
					for(int i =0; i < ascenseurs.size(); ++i)
					{
						data[i] = ascenseurs.get(i).toString();
					}
					
					list.setListData(data);
					immeuble.setEtages(liste);	
					
				}
			});
	        
	       
	      
		//Definition de la list
			
			
			
			this.list   = new JList<String>(data);
			scrollliste = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
			scrollliste.setPreferredSize(new Dimension(400, 130)); 
		
		//Mise en place des layout
		
			this.ajoutAscenceurBoutonBox.add(add);
			this.ajoutAscenceurBoutonBox.add(edit);
			this.ajoutAscenceurBoutonBox.add(remove);
			this.ajoutAscenceurBoutonBox.add(appliquer);
			this.buttonPanel.add(this.ajoutAscenceurBoutonBox);
			
			this.numEtageMaxBox.add(this.tfFNombreEtage);
			this.numEtageMinBox.add(this.tfFNumEtageMin);
			
			this.numEtageBox.add(this.lblFNumEtageMin);
			this.numEtageBox.add(this.numEtageMinBox);
			this.numEtageBox.add(this.lblFNombreEtage);
			this.numEtageBox.add(this.numEtageMaxBox);
			
			this.nombreEtagePanel.add(this.numEtageBox);
			
			this.horizontalBox.add(this.scrollliste);
			this.horizontalBox.add(this.buttonPanel);
			
			this.verticalBox.add(this.titre);
			this.verticalBox.add(this.nombreEtagePanel);
			this.verticalBox.add(this.horizontalBox);
			
			
			this.frame.add(this.verticalBox);
			
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.frame.pack();
			this.frame.setVisible(true);
	}
	
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		data = new String[Constante.getNbAscenceur()];
		for(int i =0; i < ascenseurs.size(); ++i)
		{
			data[i] = ascenseurs.get(i).toString();
		}
		
		list.setListData(data);
	}

}
