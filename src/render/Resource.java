package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Resource {
	
	private static BufferedImage getImage(String directory){
		/* fill code */
		BufferedImage ret=null;
		
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			ret = ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Bug");
			
			e.printStackTrace();
			return null;
		}
		return ret;
	}
	public final static BufferedImage destructible_block=getImage("res/img/box.png");
	public final static BufferedImage movable_block=getImage("res/img/box4.png");
	public final static BufferedImage point_object=getImage("res/img/star2.png");
	public final static BufferedImage player_img=getImage("res/img/player.png");
	
}
