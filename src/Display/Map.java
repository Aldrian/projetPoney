package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/** 
 * Structure de gestion de la carte, comprenant une matrice contenant les différents éléments
 * de la carte.
 * @author Julien
 *
 */
public class Map {
	
	Sprite fond, platform, pit;
	Sprite platformRight, platformLeft;
	BackgroundElement mapElements[][];
	
	/* Error handling
	 * Some operations on FileHandles can fail. 
	 * We adopted RuntimeExceptions to signal errors instead of checked Exceptions. 
	 * Our reasoning goes like this: 90% of the time we will access files 
	 * that we know exist and are readable (e.g. internal files packaged with our application).
	 */
	
	
	/**
	 * Initialise la matrice d'éléments ainsi que les sprites des éléments
	 * qui seront affichés.
	 */
	public Map()
	{
		fond = new Sprite(new Texture(Gdx.files.internal("res/img/Background/bg.png")));		
		platform = new Sprite(new Texture(Gdx.files.internal("res/img/Platform/platform.png")));	
		platformRight = new Sprite(new Texture(Gdx.files.internal("res/img/Platform/platformRight.png")));	
		platformLeft = new Sprite(new Texture(Gdx.files.internal("res/img/Platform/platformLeft.png")));	
		mapElements = new BackgroundElement[10][10];
	}
	
	/**(A RECODER)
	 * @return ElementType si trouvé, null si erreur
	 * 
	 */
	public ElementType ElementAt(int x, int y)
	{		
		for(int i = 0; i<10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if(
						(mapElements[i][j].getHautGauche().getY() >= y)
					 && (mapElements[i][j].getBasGauche().getY() <= y)
					 && (mapElements[i][j].getHautGauche().getX() >= x)
					 && (mapElements[i][j].getHautDroite().getX() <= x)
				) return mapElements[i][j].getType();
			}	
		}
		return null	;
	}
	
	/**
	 * Lecture du fichier map et création de l'objet map correspondant
	 * @param gc
	 */
	public void initialise(GameContainer gc)
	{
		
		FileHandle f = Gdx.files.internal("res/map/map.txt");
		String text = f.readString();
		
		int pos = 0;
		int x=0, y=0;
		for(int i = 0; i<10; i++)
		{
			y = i*60;
			for (int j = 0; j < 10; j++)
			{
				x = j*80;				
				mapElements[i][j] = new BackgroundElement (x,y,80,60,(text.charAt(pos)));
				pos ++;
			}
		}	
		
		fond.setPosition(0, 50);
	    fond.flip(false, true);
	    
	    
	}
	
    
    /**
     * Dessin des éléments de la carte en lisant la matrice et en affichant
     * les sprites correspondant
     * @param g Un objet Graphics
     */
	public void render(Graphics g) {
		        
		boolean isPlatformRight = false;
		boolean noPlatformYet = true;
        g.drawSprite(fond);
        
		int x = 0, y =0;
		int i = 0, j =0;
		
		for (j = 0; j < 10; j++)
		{
			isPlatformRight = false;
			y=(j*60) + 50;						
			for (i = 0; i < 10; i++)
			{				
				x = i*80;
				switch(mapElements[j][i].getType())
				{
				case Platform :
					if(noPlatformYet)
					{
						platformLeft.setPosition(x-34, y);
						g.drawSprite(platformLeft);
					}
					noPlatformYet = false;
					isPlatformRight = true;
					platform.setPosition(x,y);
					g.drawSprite(platform);
			      	break;
				case Spawner : 
					if (isPlatformRight) {
						platformRight.setPosition(x,y);
						g.drawSprite(platformRight);						
					}
					isPlatformRight = false;
					
					noPlatformYet = true;
			        break;
				case Pit : 
					if (isPlatformRight) {
						platformRight.setPosition(x,y);
						g.drawSprite(platformRight);						
					}
					isPlatformRight = false;
					
					noPlatformYet = true;
			        break;				
				
				case None :
					if (isPlatformRight) {
						platformRight.setPosition(x,y);
						g.drawSprite(platformRight);						
					}
					isPlatformRight = false;
					noPlatformYet = true;
					break;
				}
				
				
			}			
		}	
		
		
		g.drawSprite(platformRight);
   }
}
