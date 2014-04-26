package Interface;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Map {
	
	Sprite fond;
	
	/* Error handling
	 * Some operations on FileHandles can fail. 
	 * We adopted RuntimeExceptions to signal errors instead of checked Exceptions. 
	 * Our reasoning goes like this: 90% of the time we will access files 
	 * that we know exist and are readable (e.g. internal files packaged with our application).
	 */
	FileHandle f = Gdx.files.internal("res/map/map.txt");
	
	public Map()
	{
		fond = new Sprite(new Texture(Gdx.files.internal("res/img/bg.png")));;
	}
	
	public void initialise(GameContainer gc)
	{
		fond.setPosition(0, 0);
	    fond.flip(false, true);
	    
	    
	}
	
    
    
	public void render(Graphics g) {
		
        
        g.drawSprite(fond);
		String text = f.readString();
		int x = 0, y =0, pos = 0;
		int i = 0, j =0;
		
		for (j = 0; j < 10; j++)
		{
			y=j*60;
			
			for (i = 0; i < 10; i++)
			{
				
				x = i*80;
				switch(text.charAt(pos))
				{
				case '0' :
					g.setColor(Color.MAGENTA);			        
			        g.fillRect(x, y, 80, 60); 
					break;
				case '1' : 
					g.setColor(Color.RED);			        
			        g.fillRect(x, y, 80, 60); 
					break;
				case '2' : 
					g.setColor(Color.ORANGE);			        
			        g.fillRect(x, y, 80, 60); 
					break;				
					
				}
				pos++;
			}
			
		}
		
		
		
       
   }
}
