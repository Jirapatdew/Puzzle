package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Main;
import render.Resource;
import ui.StatScreen;

public class StatButton extends RoundButton {
	public StatButton() {
		super(Resource.statButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test StatButton");
				Main.gameWindow.switchScreen(new StatScreen());
			}
		});
	}
}
