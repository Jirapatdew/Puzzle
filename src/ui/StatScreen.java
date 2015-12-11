package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import button.BackButton;
import render.Resource;

public class StatScreen extends JPanel {
	public StatScreen() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(640, 800));
		setLayout(null);
		
		BackButton backButton = new BackButton();
		add(backButton);
		backButton.setLocation(475, 640);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(0, 0, 640, 800);
		
		for(int i = 1; i <= 7; i++) {
			g2d.drawImage(Resource.rank[i], 120, 150 + (70*(i-1)), 45, 45, null);
		}
		
		g2d.setFont(Resource.mediumFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("--- High Score ---", 170, 100);
		
		g2d.setFont(Resource.standardFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Oliver", 250, 180);
		g2d.drawString("500", 440, 180);
		g2d.drawString("Jack", 250, 250);
		g2d.drawString("400", 440, 250);
		g2d.drawString("Noah", 250, 320);
		g2d.drawString("300", 440, 320);
		
		g2d.setFont(Resource.smallFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Jacob", 250, 390);
		g2d.drawString("200", 440, 390);
		g2d.drawString("Charlie", 250, 460);
		g2d.drawString("100", 440, 460);
		g2d.drawString("Harry", 250, 530);
		g2d.drawString("50", 440, 530);
		g2d.drawString("Oscar", 250, 600);
		g2d.drawString("10", 440, 600);
	}
}


