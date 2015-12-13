package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.PlayerStatus;
import main.Main;
import render.Resource;
import ui.GameScreen;

public class PlayButton extends RoundButton {
	
	public PlayButton() {
		super(Resource.playButton);
		//setPreferredSize(new Dimension(180, 180));
		setSize(180, 180);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				PlayerStatus.reset();
				Main.gameWindow.switchScreen(new GameScreen());
			}
		});
	}
}
