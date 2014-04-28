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
		timer.update();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.PINK);		
		
			w = bmp.getBounds("Temps écoulé :").width;
		g.drawString("Temps écoulé : ", (800-w)/2, 10);
			h = bmp.getBounds("Temps écoulé : ").height;
			w = bmp.getBounds(timer.GetElapsedTime()).width;
		g.drawString(timer.GetElapsedTime(), (800-w)/2, 10+h+4);
		map.render(g);
		
	}
}
