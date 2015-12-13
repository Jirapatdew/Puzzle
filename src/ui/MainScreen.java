package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.ControlButton;
import button.InfoButton;
import button.MuteSoundButton;
import button.PlayButton;
import button.SoundButton;
import button.StatButton;
import config.PlayerStatus;
import render.Resource;

public class MainScreen extends JPanel {
	public MainScreen() {
		// TODO Auto-generated constructor stub
		//if(PlayerStatus.enableSound) Resource.s_back.loop();
		
		setPreferredSize(new Dimension(640, 800));
		setLayout(null);
		
		PlayButton playButton = new PlayButton();
		add(playButton);
		//playButton.setLocation(640/2 - playButton.getWidth()/2, 800/2 - playButton.getHeight()/2);
		playButton.setLocation(230,280);
		
		StatButton statButton = new StatButton();
		add(statButton);
		statButton.setLocation(115, 520);
		
		ControlButton controlButton = new ControlButton();
		add(controlButton);
		controlButton.setLocation(225, 520);
		
		MuteSoundButton muteSoundButton = new MuteSoundButton();
		SoundButton soundButton = new SoundButton(muteSoundButton);
		add(soundButton);
		add(muteSoundButton); // must add after soundButton
		soundButton.setLocation(335, 520);
		muteSoundButton.setLocation(335, 520);
		
		InfoButton infoButton = new InfoButton();
		add(infoButton);
		infoButton.setLocation(445, 520);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(Resource.mainScreen2,0,0,640,800,null);
		g2d.setColor(new Color(0, 0, 0, 200));
		g2d.fillRect(0, 0, 640, 800);
		
		g2d.setFont(Resource.largeFont);
		g2d.setColor(Color.WHITE);
		
		String title = "Star King";
		FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(title, g2d);
        int x = (this.getWidth() - (int) r.getWidth()) / 2;
        g2d.drawString(title, x, 200);
	}
}
