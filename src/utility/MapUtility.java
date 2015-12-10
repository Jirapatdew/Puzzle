package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

import config.configs;

public class MapUtility {
	public static int PLAYER=4;
	public static int PASSABLE_TERRAIN=0;
	public static int UNPASSABLE_TERRAIN=1;
	public static int MOVABLE_BLOCK=2;
	public static int DESTRUCTIBLE_BLOCK=3;
	public static int POINT=5;
	public static int mapOffsetX=10;
	public static int mapOffsetY=10;
	public static int[][] readMap(String file) {
		int[][] mapArray=new int[configs.mapGridHeight+4][configs.mapGridWidth+4];
		Scanner s=null;
		try {
			s = new Scanner(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		for(int i=0;i<configs.mapGridHeight+4;i++) for(int j=0;j<configs.mapGridWidth+4;j++) mapArray[i][j]=1;
		for(int i=0;i<configs.mapGridHeight;i++){
			for(int j=0;j<configs.mapGridWidth;j++){
				mapArray[i+2][j+2]=s.nextInt();
			}
		}
		
		s.close();
		return mapArray;
	}
	public static void main(String[] args) throws FileNotFoundException{
		int[][] mapArray = readMap("res/map/map1.txt");
		for(int i=0;i<mapArray.length;i++){
			for(int j=0;j<mapArray[i].length;j++){
				System.out.print(mapArray[i][j]+" ");
			}System.out.println();
		}
	}
	///Just a Comment Passing by
}
