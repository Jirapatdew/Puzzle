package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import config.configs;
import entity.Map;

public class GameScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8593735507163883962L;
	public GameScreen(){
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(configs.screenWidth,configs.screedHeight));
		this.setBackground(configs.cblack);
		
		///////// Title Panel
		JPanel TitlePanel=new JPanel();
		TitlePanel.setBackground(configs.cblack);
		TitlePanel.setPreferredSize(new Dimension(configs.otherPanelWidth,configs.otherPanelHeight));
		
		
		///////// Center Panel ()
		JPanel MapEastPanel = new JPanel();
		JPanel MapWestPanel = new JPanel();
		JPanel MapPanel=new JPanel();
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new BorderLayout());
		MapPanel.setBackground(configs.cpink);
		MapEastPanel.setBackground(configs.cblack);
		MapWestPanel.setBackground(configs.cblack);
		MapPanel.setPreferredSize(new Dimension(configs.mapWidth,configs.mapHeight));
		int sideWidth=(configs.screenWidth-configs.mapWidth)/2;
		int sideHeight=(configs.screedHeight-configs.mapHeight)/2;
		MapEastPanel.setPreferredSize(new Dimension(sideWidth,sideHeight));
		MapWestPanel.setPreferredSize(new Dimension(sideWidth,sideHeight));
		CenterPanel.add(MapWestPanel,BorderLayout.WEST);
		CenterPanel.add(MapPanel,BorderLayout.CENTER);
		CenterPanel.add(MapEastPanel,BorderLayout.EAST);
		
		///////// Level Panel
		JPanel LevelPanel=new JPanel();
		LevelPanel.setBackground(configs.cblack);
		LevelPanel.setPreferredSize(new Dimension(configs.otherPanelWidth,configs.otherPanelHeight));
		
		
		this.add(TitlePanel, BorderLayout.NORTH);
		this.add(CenterPanel, BorderLayout.CENTER);
		this.add(LevelPanel, BorderLayout.SOUTH);
	}
	
}
