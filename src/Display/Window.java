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
		timer.start();
	}
	
	public void render(Graphics g) {
		map.render(g);
		g.setColor(Color.PINK);		
		g.drawString(timer.GetElapsedTime(), 0, 0);
	}
}
