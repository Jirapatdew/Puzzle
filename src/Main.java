import javax.swing.JFrame;

import ui.GameScreen;
import ui.GameWindow;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GameScreen gamescreen = new GameScreen(1);
		GameWindow frame = new GameWindow(gamescreen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		while(true){
			Thread.sleep(20);
			frame.repaint();
		}
	}
}
