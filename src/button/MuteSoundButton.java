package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import config.PlayerStatus;
import render.Resource;

public class MuteSoundButton extends RoundButton {
	public MuteSoundButton() {
		super(Resource.muteSoundButton);
		setSize(80, 80);
		if(PlayerStatus.enableSound) setVisible(false);
		else setVisible(true);
		
	}
}