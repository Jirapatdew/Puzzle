package config;

public class PlayerStatus {
	public static boolean enableSound = true;
	public static int level;
	public static int heart;
	public static int score;
	public static int collectedStarThisMap;
	
	public static void reset(){
		enableSound = true;
		level = 1;
		heart = 5;
		score = 0;
		collectedStarThisMap=0;
	}

	public static void increaseScore() {
		// TODO Auto-generated method stub
		score++;
		collectedStarThisMap++;
	}
	public static void updateLevel(){
		level++;
	}
}
