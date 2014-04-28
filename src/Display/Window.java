package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;

public class Window {
	
	ElapsedTime timer;
	Map map;
	
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
		//BitmapFont.getBounds(String str).width
		g.drawString("Temps écoulé : ", 330, 10);
		g.drawString(timer.GetElapsedTime(), 360, 30);
		map.render(g);
		
	}
}
