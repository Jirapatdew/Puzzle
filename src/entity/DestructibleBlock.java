package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class DestructibleBlock extends Block{

	public DestructibleBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.cyan);
		int startX=this.x*configs.singleWidth+configs.mapOffsetX;
		int startY=this.y*configs.singleHeight+configs.mapOffsetY;
		g2d.drawImage(Resource.destructible_block, startX,startY,configs.singleWidth,configs.singleHeight,null);
		//g2d.fillRect(startX, startY, configs.singleWidth, configs.singleHeight);
		//g2d.drawImage(Resource.destructible_block, null, startX, startY);
		//System.out.println(startX+" "+startY);
		//System.out.println(x+" "+y);
	}
}
