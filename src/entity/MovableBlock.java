package entity;

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
}
