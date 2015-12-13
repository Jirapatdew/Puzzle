package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Main;
import render.Resource;
import ui.InstructionScreen;

public class ControlButton extends RoundButton {
	public ControlButton() {
		super(Resource.controlButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test ControlButton");
				Resource.s_button.play();
				
				Main.gameWindow.switchScreen(new InstructionScreen());
			}
		});
	}
}
