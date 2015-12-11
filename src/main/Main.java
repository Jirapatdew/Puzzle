package main;
import javax.swing.JFrame;

import com.sun.glass.events.KeyEvent;

import config.PlayerStatus;
import config.configs;
import entity.DestructibleBlock;
import entity.Map;
import entity.MovableBlock;
import entity.Player;
import render.IRenderable;
import render.RenderableHolder;
import ui.GameScreen;
import ui.GameWindow;
import ui.InstructionScreen;
import ui.MainScreen;
import ui.StatScreen;
import utility.InputUtility;
import utility.MapUtility;



public class Main {
	public static GameWindow gameWindow;
	public static GameScreen gamescreen;
	public static PlayerStatus playerStatus;
	public static void main(String[] args) throws InterruptedException {
		int mapNumber=1;
//		GameScreen gamescreen = new GameScreen(1);
//		MainScreen mainscreen = new MainScreen();
//		InstructionScreen instructionscreen = new InstructionScreen();
//		StatScreen statscreen = new StatScreen();
		gameWindow = new GameWindow();
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setVisible(true);
		gameWindow.pack();
		while(true){
			Thread.sleep(20);
			logicUpdate();
			gameWindow.repaint();
			
		}
	}
	public static void logicUpdate(){
		if(!(gameWindow.currentScene instanceof GameScreen)){
			return;
		}
		Player player =null;
		
		//// find player and delete in from renderable holder
		for(IRenderable i : RenderableHolder.getInstance().getRenderableList()){
			if(i instanceof Player){
				player=(Player)i;
				RenderableHolder.getInstance().getRenderableList().remove(i);
				break;
			}
		}
		
		//// calculate player final point
		if(InputUtility.getKeyTriggered(KeyEvent.VK_UP)){
			player.calculateDestination(configs.NORTH,gamescreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_DOWN)){
			player.calculateDestination(configs.SOUTH,gamescreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)){
			player.calculateDestination(configs.WEST,gamescreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)){
			player.calculateDestination(configs.EAST,gamescreen.getMapArray());
		}
		//System.out.println(player.exactX+" "+player.exactY+" e");
		//System.out.println(player.lastX+" "+player.lastY+" l");
		
		player.update();
		RenderableHolder.getInstance().getRenderableList().add(player);
			
		InputUtility.postUpdate();
	}
	public static void moveBlock(int currentX, int currentY,int lastX,int lastY) {
		// TODO Auto-generated method stub
		
		for(IRenderable cur : RenderableHolder.getInstance().getRenderableList()){
			if(cur instanceof MovableBlock){
				MovableBlock mvb = (MovableBlock)cur;
				if(mvb.x==currentX&&mvb.y==currentY){
					RenderableHolder.getInstance().getRenderableList().remove(cur);
					gamescreen.currentMap.mapArray[currentY+2][currentX+2]=MapUtility.PLAYER;
					gamescreen.currentMap.mapArray[lastY+2][lastY+2]=MapUtility.MOVABLE_BLOCK;
					mvb.setNewPlace(lastX,lastY);
					RenderableHolder.getInstance().getRenderableList().add(mvb);
				}
			}
		}
	}
	public static void destroyBlock(int currentX, int currentY) {
		// TODO Auto-generated method stub
		for(IRenderable cur : RenderableHolder.getInstance().getRenderableList()){
			if(cur instanceof DestructibleBlock){
				DestructibleBlock dtb = (DestructibleBlock)cur;
				if(dtb.x==currentX&&dtb.y==currentY){
					RenderableHolder.getInstance().getRenderableList().remove(cur);
					gamescreen.currentMap.mapArray[currentY+2][currentX+2]=MapUtility.PASSABLE_TERRAIN;
				}
			}
		}
	}
}
