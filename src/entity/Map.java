package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import config.configs;
import render.IRenderable;

public class Map implements IRenderable{

	int[][] mapArray = null;
	int singleWidth,singleHeight;
	Color backgroundColor;
	Color foregoundColor;
	CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	public Map(int[][] mapArray,Color bg,Color fg){
		this.mapArray=mapArray;
		this.entities= new CopyOnWriteArrayList<Entity>();
		this.backgroundColor=bg;
		this.foregoundColor=fg;
		this.singleHeight=configs.singleHeight;
		this.singleWidth=configs.singleWidth;
	}
	public void addEntity(Entity e){
		entities.add(e);
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i=0;i<mapArray.length;i++){
			for(int j=0;j<mapArray[i].length;j++){
				if(mapArray[i][j]==0) g2d.setColor(backgroundColor);
				else g2d.setColor(foregoundColor);
				g2d.fillRect(singleWidth*10, singleHeight*10, singleWidth, singleHeight);
			}
		}
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
