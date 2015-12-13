package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import render.Resource;

public class GameWindow extends JFrame {
	
	public JPanel currentScene;
	
	public GameWindow() {
		super("Star King");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		currentScene = new MainScreen();
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
		
		Resource.s_back.loop();
	}
	
	public void switchScreen(JPanel screen){
		getContentPane().remove(currentScene);
		this.currentScene = screen;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		currentScene.requestFocus();
	}
	
}
