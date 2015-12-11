package entity;

import java.awt.Graphics2D;

import config.configs;
import render.Resource;
import utility.MapUtility;

public class Player extends Entity implements Movable{

	public boolean isMoving;
	public int lastX,lastY;
	public int exactX,exactY;
	int speed;
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.speed=configs.playerSpeed;
		exactX=this.x*configs.singleWidth+configs.mapOffsetX;
		exactY=this.y*configs.singleHeight+configs.mapOffsetY;
		lastX=exactX;
		lastY=exactY;
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
		int dif;
		if(lastX!=exactX){
			dif=lastX-exactX;
			dif=dif/Math.abs(dif);
			exactX+=dif*speed;
		}
		else if(lastY!=exactY){
			dif=lastY-exactY;
			dif=dif/Math.abs(dif);
			exactY+=dif*speed;
		}
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		if(lastX==exactX&&lastY==exactY){
			isMoving=false;
		}
		if(!isMoving) return;
		move();
		
	}
	public void calculateDestination(int direction,int[][] mapArray){
		if(isMoving) return;
		int[] diry={-1,0,1,0};
		int[] dirx={0,1,0,-1};
		System.out.println("cal"+direction);
		MapUtility.printMap(mapArray);
		int dx=dirx[direction];
		int dy=diry[direction];
		
		lastX=super.x;
		lastY=super.y;
		System.out.println(lastX+" "+lastY);
		System.out.println(dx+" "+dy);
		while(true){
			if(mapArray[lastY+dy][lastX+dx]!=0){
				break;
			}
			System.out.println(lastX+" "+lastY);
			System.out.println(dx+" "+dy);
			lastX+=dx;
			lastY+=dy;
		}
		if(lastX!=x||lastY!=y)this.isMoving=true;
		lastX=lastX*configs.singleWidth+configs.mapOffsetX;
		lastY=lastY*configs.singleHeight+configs.mapOffsetY;
	}

}
