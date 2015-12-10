package entity;

import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class Player extends Entity implements Movable{

	public boolean isMoving;
	int lastX,lastY;
	int exactX,exactY;
	int speed;
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.speed=configs.playerSpeed;
		exactX=this.x*configs.singleWidth+configs.mapOffsetX;
		exactY=this.y*configs.singleHeight+configs.mapOffsetY;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.player_img, exactX,exactY,configs.singleWidth,configs.singleHeight,null);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		if(lastX==x&&lastY==y){
			isMoving=false;
		}
		if(!isMoving) return;
		
		
	}
	public void calculateDestination(int direction,int[][] mapArray){
		int[] dirx={-1,0,1,0};
		int[] diry={0,1,0,-1};
		
		int dx=dirx[direction];
		int dy=dirx[direction];
		
		lastX=super.x;
		lastY=super.y;
		while(true){
			if(mapArray[lastX+dx][lastY+dy]!=0){
				break;
			}
			lastX+=dx;
			lastY+=dy;
		}
		this.isMoving=true;
		
	}

}
