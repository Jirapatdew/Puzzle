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
import button.LikeButton;
import button.PlayButton;
import button.SoundButton;
import button.StatButton;
import config.PlayerStatus;
import render.Resource;

public class MainScreen extends JPanel {
	public MainScreen() {
		// TODO Auto-generated constructor stub

		setPreferredSize(new Dimension(640, 800));
		setLayout(null);
		
		PlayButton playButton = new PlayButton();
		add(playButton);
		//playButton.setLocation(640/2 - playButton.getWidth()/2, 800/2 - playButton.getHeight()/2);
		playButton.setLocation(230,330);
		
		StatButton statButton = new StatButton();
		add(statButton);
		statButton.setLocation(115, 570);
		
		ControlButton controlButton = new ControlButton();
		add(controlButton);
		controlButton.setLocation(225, 570);
		
		SoundButton soundButton = new SoundButton();
		add(soundButton);
		soundButton.setLocation(335, 570);
		
		LikeButton likeButton = new LikeButton();
		add(likeButton);
		likeButton.setLocation(445, 570);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(Resource.mainScreen2,0,0,640,800,null);
		g2d.setColor(new Color(5, 5, 5, 230));
		g2d.fillRect(0, 0, 640, 800);
		
		g2d.setFont(Resource.largeFont);
		g2d.setColor(Color.WHITE);
		
//		String title = "Star King";
//		FontMetrics fm = g2d.getFontMetrics();
//        Rectangle2D r = fm.getStringBounds(title, g2d);
//        int x = (this.getWidth() - (int) r.getWidth()) / 2;
//        g2d.drawString(title, x, 200);
        
        g2d.drawImage(Resource.logo, 70, 80, 450, 200, null);
	}
}
