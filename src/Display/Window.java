package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Window {
	
	ElapsedTime timer;
	Map map;
	
	//Utility
	BitmapFont bmp = new BitmapFont();
	String buf;
	float h,w;
	
	public Window()
	{ 
		map = new Map();
		timer = new ElapsedTime();
	}

	public void initialise(GameContainer gc) {
		map.initialise(gc);	
		
	}
	
	public void update()
	{
	}
	
	public void render(Graphics g) {
		g.setColor(Color.PINK);		
		
			
		// Affichage du temps
			buf = timer.sec() + "s";
			if (timer.min()!= 0)  buf = timer.min() + "m" + timer.sec() + "s";
				w = bmp.getBounds("Temps écoulé :").width;
			g.drawString("Temps écoulé : ", (800-w)/2, 10);
				h = bmp.getBounds("Temps écoulé : ").height;
				w = bmp.getBounds(buf).width;
			g.drawString(buf, (800-w)/2, 10+h+4);
		
		
		map.render(g);
		
	}
}
