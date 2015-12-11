package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Main;
import render.Resource;
import ui.InfoScreen;

public class InfoButton extends RoundButton {
	public InfoButton() {
		super(Resource.infoButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.gameWindow.switchScreen(new InfoScreen());
			}
		});
	}
}
