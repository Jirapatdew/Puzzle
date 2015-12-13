package button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Main;
import render.Resource;
import ui.MainScreen;

public class BackButton extends RoundButton {
	
	public BackButton() {
		super(Resource.backButton);
		setSize(115, 115);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test BackButton");
				Resource.s_button.play();
				
				Main.gameWindow.switchScreen(new MainScreen());
			}
		});
	}
}
