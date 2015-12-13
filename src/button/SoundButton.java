package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import config.PlayerStatus;
import render.Resource;

public class SoundButton extends RoundButton {
	public SoundButton(MuteSoundButton muteSoundButton) {
		super(Resource.soundButton);
		setSize(80, 80);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				if(muteSoundButton.isVisible()){
					//open sound
					//JOptionPane.showMessageDialog(null, "Open Sound");
					Resource.s_back.loop();
					
					PlayerStatus.enableSound = true;
					muteSoundButton.setVisible(false);
				}
				else {
					//close sound
					Resource.s_back.stop();
					
					//JOptionPane.showMessageDialog(null, "Close Sound");
					PlayerStatus.enableSound = false;
					muteSoundButton.setVisible(true);
				}
			}
		});
	}
}