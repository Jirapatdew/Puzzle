package config;

import java.awt.Color;

public class configs {
	public static int mapGridWidth=12;
	public static int mapGridHeight=14;
	public static int singleWidth=40;
	public static int singleHeight=40;
	public static int screenWidth=640;
	public static int screedHeight=800;
	public static int mapWidth=mapGridWidth*singleWidth;
	public static int mapHeight=mapGridHeight*singleHeight;
	public static int otherPanelWidth=640;
	public static int otherPanelHeight=120;
	
	
	public static Color cblack=new Color(59,64,67);
	public static Color cpink=new Color(251,97,105);
	
	
	public static int PLAYER=4;
	public static int PASSABLE_TERRAIN=0;
	public static int UNPASSABLE_TERRAIN=1;
	public static int MOVABLE_BLOCK=2;
	public static int DESTRUCTIBLE_BLOCK=3;
}
