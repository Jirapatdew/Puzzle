package config;

public class PlayerStatus {
	public static boolean enableSound;
	public static int level;
	public static int heart;
	public static int score;
	
	public static void reset(){
		enableSound = true;
		level = 1;
		heart = 5;
		score = 0;
	}
}
