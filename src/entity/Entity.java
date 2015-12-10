package entity;

import render.IRenderable;

public abstract class Entity implements IRenderable{
	int x,y;
	boolean isDestroyed,isDestroyedNextState;
	public Entity(int x,int y){
		this.x=x;
		this.y=y;
		isDestroyed=false;
	}
	abstract void update();
}
