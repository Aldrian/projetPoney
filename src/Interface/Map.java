package Interface;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;

public class Map {
	
	private BackgroundElement[][] mapElements = new BackgroundElement[10][10];
	
	/* Error handling
	 * Some operations on FileHandles can fail. 
	 * We adopted RuntimeExceptions to signal errors instead of checked Exceptions. 
	 * Our reasoning goes like this: 90% of the time we will access files 
	 * that we know exist and are readable (e.g. internal files packaged with our application).
	 */
	FileHandle f = Gdx.files.internal("res/map/map.txt");
	public void render(Graphics g) {
		String text = f.readString();
		int x = 0, y =0, pos = 0;
		int i = 0, j =0;
		
		for (j = 0; j < 10; j++)
		{
			y=j*60;
			
			for (i = 0; i < 10; i++)
			{			
				System.out.println("tour");
				x = i*80;
				BackgroundElement temp = new BackgroundElement(x,y,80,60);
				mapElements[i][j] = temp;
				switch(text.charAt(pos))
				{
				case '0' :
					g.setColor(Color.MAGENTA);			        
					mapElements[i][j].render(g);
					break;
				case '1' : 
					g.setColor(Color.RED);			        
					mapElements[i][j].render(g);
					break;
				case '2' : 
					g.setColor(Color.ORANGE);			        
					mapElements[i][j].render(g);
					break;	
					
				}
				pos++;
			}
			
		}
		
		
		
       
   }
}
