package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import config.configs;
import entity.Map;

public class GameScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8593735507163883962L;
	private Map currentMap=new Map(1,configs.cblack,configs.cpink);
	public GameScreen(){
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(configs.screenWidth,configs.screedHeight));
		this.setBackground(configs.cblack);
		setDoubleBuffered(true);
		setVisible(true);
		setFocusable(true);
		requestFocus();
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
		MapPanel.setBackground(Color.red);
		MapEastPanel.setBackground(configs.cblack);
		MapWestPanel.setBackground(configs.cblack);
		MapPanel.setPreferredSize(new Dimension(configs.mapWidth,configs.mapHeight));
		int sideWidth=(configs.screenWidth-configs.mapWidth)/2;
		int sideHeight=(configs.screedHeight-configs.mapHeight)/2;
		MapEastPanel.setPreferredSize(new Dimension(sideWidth,sideHeight));
		MapWestPanel.setPreferredSize(new Dimension(sideWidth,sideHeight));
		CenterPanel.add(MapWestPanel,BorderLayout.WEST);
		//CenterPanel.add(MapPanel,BorderLayout.CENTER);
		CenterPanel.add(MapEastPanel,BorderLayout.EAST);
		
		///////// Level Panel
		JPanel LevelPanel=new JPanel();
		LevelPanel.setBackground(configs.cblack);
		LevelPanel.setPreferredSize(new Dimension(configs.otherPanelWidth,configs.otherPanelHeight));
		
		
		this.add(TitlePanel, BorderLayout.NORTH);
		//this.add(CenterPanel, BorderLayout.CENTER);
		this.add(LevelPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setBackground(Color.white);
		g2d.clearRect(0, 0, configs.screenWidth, configs.screedHeight);
		g2d.setColor(configs.cblack);
		g2d.fillRect(0, configs.otherPanelHeight, configs.screenWidth, configs.mapHeight);
		if(currentMap.isVisible()) currentMap.draw(g2d);
		//System.out.println(111);
		
	}
	
}
