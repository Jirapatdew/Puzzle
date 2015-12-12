package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import config.PlayerStatus;
import config.configs;
import entity.DestructibleBlock;
import entity.Map;
import entity.MovableBlock;
import entity.Player;
import entity.PointObject;
import render.IRenderable;
import render.RenderableHolder;
import render.Resource;
import utility.InputUtility;
import utility.MapUtility;

public class GameScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8593735507163883962L;
	public static Map currentMap;
	public static int[][] getMapArray(){
		if(currentMap.mapArray==null) System.out.println("mapnull");
		return currentMap.mapArray;
	}
	public GameScreen(){
		super();
		this.currentMap = new Map(PlayerStatus.level,configs.cblack,configs.cpink);
		RenderableHolder.getInstance().getRenderableList().clear();
		//MapUtility.printMap(currentMap.mapArray);
		addAllEntitiesInMap();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(configs.screenWidth,configs.screedHeight));
		this.setBackground(configs.cblack);
		setDoubleBuffered(true);
		setVisible(true);
		setFocusable(true);
		requestFocus();
		///////// Title Panel
//		JPanel TitlePanel=new JPanel();
//		TitlePanel.setBackground(configs.cblack);
//		TitlePanel.setPreferredSize(new Dimension(configs.otherPanelWidth,configs.otherPanelHeight));
		StatusPanel TitlePanel = new StatusPanel();
		
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
//		JPanel levelPanel=new JPanel();
//		levelPanel.setBackground(configs.cblack);
//		levelPanel.setPreferredSize(new Dimension(configs.otherPanelWidth,configs.otherPanelHeight));
		LevelPanel levelPanel = new LevelPanel();
		
		this.add(TitlePanel, BorderLayout.NORTH);
		//this.add(CenterPanel, BorderLayout.CENTER);
		this.add(levelPanel, BorderLayout.SOUTH);
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//if(InputUtility.getKeyPressed(e.getKeyCode()))
					//InputUtility.setKeyTriggered(e.getKeyCode(), true);
				System.out.println(111);
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				InputUtility.setKeyTriggered(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setVisible(true);
	}
	
	private void addAllEntitiesInMap() {
		// TODO Auto-generated method stub
		for(int i=2;i<currentMap.mapArray.length-2;i++){
			for(int j=2;j<currentMap.mapArray[i].length-2;j++){
				int cur = currentMap.mapArray[i][j];
				if(cur==MapUtility.DESTRUCTIBLE_BLOCK) RenderableHolder.getInstance().add(new DestructibleBlock(j-2, i-2));
				else if(cur==MapUtility.MOVABLE_BLOCK) RenderableHolder.getInstance().add(new MovableBlock(j-2, i-2));
				else if(cur==MapUtility.POINT) RenderableHolder.getInstance().add(new PointObject(j-2, i-2));
				else if(cur==MapUtility.PLAYER){
					RenderableHolder.getInstance().add(new Player(j-2, i-2));
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.white);
		g2d.setColor(configs.cblack);
		
		g2d.fillRect(0, configs.otherPanelHeight, configs.screenWidth, configs.mapHeight);
		if(currentMap.isVisible()) currentMap.draw(g2d);
		
		//System.out.println(RenderableHolder.getInstance().getRenderableList().size());
		
		
		for(IRenderable obj : RenderableHolder.getInstance().getRenderableList()){
			if(obj.isVisible()){
				obj.draw(g2d);
				if(obj instanceof MovableBlock){
					MovableBlock mvb = (MovableBlock)obj;
					//System.out.println(mvb.exactX+" "+mvb.exactY);
					//System.out.println(mvb.lastX+" "+mvb.lastY);
				}
			}
		}
		
	}
	
}
