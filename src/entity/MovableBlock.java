package entity;

import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class MovableBlock extends Block implements Movable{

	public MovableBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	int nextX,nextY;
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	public void update(){
		super.x=this.nextX;
		super.y=this.nextY;
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		int startX=this.x*configs.singleWidth+configs.mapOffsetX;
		int startY=this.y*configs.singleHeight+configs.mapOffsetY;
		g2d.drawImage(Resource.movable_block, startX,startY,configs.singleWidth,configs.singleHeight,null);
	}
}
