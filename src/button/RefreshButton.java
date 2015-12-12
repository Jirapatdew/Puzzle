package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import config.PlayerStatus;
import main.Main;
import render.Resource;
import ui.GameScreen;

public class RefreshButton extends RoundButton {
	public RefreshButton() {
		super(Resource.refreshButton);
		setSize(70, 70);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(PlayerStatus.heart > 1) {
					PlayerStatus.heart--;
					PlayerStatus.collectedStarThisMap=0;
					Main.gameWindow.switchScreen(new GameScreen());
				}
				else {
					JOptionPane.showMessageDialog(null, "GAME OVER");
				}
				
			}
		});
	}
}
