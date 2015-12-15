package button;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import config.PlayerStatus;
import entity.Player;
import main.Main;
import render.Resource;
import ui.InfoScreen;

public class LikeButton extends RoundButton {
	public LikeButton() {
		super(Resource.likeButton);
		if(PlayerStatus.CheatMode) bimg = Resource.likeButton2;
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				//Main.gameWindow.switchScreen(new InfoScreen());
				PlayerStatus.CheatMode = !PlayerStatus.CheatMode;
				
				if(PlayerStatus.CheatMode) System.out.println("Cheat Mode is Active");
				else System.out.println("Cheat Mode is Close");
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(PlayerStatus.CheatMode) bimg = Resource.likeButton2;
		else bimg = Resource.likeButton;
	}
}

