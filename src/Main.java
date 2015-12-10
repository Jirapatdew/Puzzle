import javax.swing.JFrame;

import com.sun.glass.events.KeyEvent;

import config.configs;
import entity.Map;
import entity.Player;
import render.IRenderable;
import render.RenderableHolder;
import ui.GameScreen;
import ui.GameWindow;
import ui.InstructionScreen;
import ui.MainScreen;
import ui.StatScreen;
import utility.InputUtility;



public class Main {
	public static GameWindow frame;
	public static GameScreen gamescreen;
	public static void main(String[] args) throws InterruptedException {
		int mapNumber=1;
		GameScreen gamescreen = new GameScreen(1);
		MainScreen mainscreen = new MainScreen();
		InstructionScreen instructionscreen = new InstructionScreen();
		StatScreen statscreen = new StatScreen();
		frame = new GameWindow(gamescreen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		while(true){
			Thread.sleep(20);
			logicUpdate();
			frame.repaint();
			
		}
	}
	public static void logicUpdate(){
		Player player =null;
		
		//// find player and delete in from renderable holder
		for(IRenderable i : RenderableHolder.getInstance().getRenderableList()){
			if(i instanceof Player){
				player=(Player)i;
				RenderableHolder.getInstance().getRenderableList().remove(i);
				break;
			}
		}
		if(!(frame.currentScene instanceof GameScreen)){
			return;
		}
		//// calculate player final point
		if(InputUtility.getKeyTriggered(KeyEvent.VK_UP)){
			player.calculateDestination(configs.NORTH,gamescreen.getMapArray());
			InputUtility.postUpdate();
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_DOWN)){
			player.calculateDestination(configs.SOUTH,gamescreen.getMapArray());
			InputUtility.postUpdate();
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)){
			player.calculateDestination(configs.WEST,gamescreen.getMapArray());
			InputUtility.postUpdate();
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)){
			player.calculateDestination(configs.EAST,gamescreen.getMapArray());
			InputUtility.postUpdate();
		}
		
		RenderableHolder.getInstance().getRenderableList().add(player);
			
		InputUtility.postUpdate();
	}
}
