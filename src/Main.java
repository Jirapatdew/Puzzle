import ui.GameScreen;
import ui.GameWindow;

public class Main {

	public static void main(String[] args) {
		GameScreen gamescreen = new GameScreen();
		GameWindow frame = new GameWindow(gamescreen);
		frame.setVisible(true);
		//frame.pack();
	}
}
