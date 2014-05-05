package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Window {
	
	
	Map map;
	
	//Utility
	BitmapFont bmp = new BitmapFont();
	String buf;
	float h,w;
	
	//Font
	BitmapFont soopafresh;
	
	//Header
	SpriteBatch batch;
	ElapsedTime timer;
	Sprite header;
	
	public Window()
	{ 
		map = new Map();
		timer = new ElapsedTime();
	}

	public void initialise(GameContainer gc) {
		//Créer le header
		batch = new SpriteBatch();
		header = new Sprite(new Texture(Gdx.files.internal("res/img/Background/header.png")));	
		header.setPosition(0, 0);
		header.flip(false, true);
		//Générer la police soopafresh
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("res/font/soopafre.ttf"));
		soopafresh = generator.generateFont(28, FreeTypeFontGenerator.DEFAULT_CHARS, true);
		//Initialiser la map
		map.initialise(gc);	
		
		
	}
	
	public void update()
	{
	}
	
	public void render(Graphics g) {
		//Charger la police
		g.setFont(soopafresh);
		//Affichage du bandeau
		g.drawSprite(header);
			
		// Affichage du temps
		g.setColor(Color.valueOf("486C88"));		
			buf = timer.sec() + "s";
			if (timer.min()!= 0)  buf = timer.min() + "m" + timer.sec() + "s";
				w = bmp.getBounds("Temps écoulé :").width + bmp.getBounds(buf).width;
			g.drawString("Temps écoulé : "+buf, 40, 10);
				//h = bmp.getBounds("Temps écoulé : ").height;
				//w = bmp.getBounds(buf).width;
			//g.drawString(buf, (800-w)/2, 10+h+4);
		
		// Affichage de la carte
		map.render(g);
		
	}
}
