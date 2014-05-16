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
import com.badlogic.gdx.math.Vector2;

/**
 * Classe fenêtre contenant un header et une carte
 * @author Julien
 *
 */
public class Window {
	
	
	Map map;
	
	//Utility
	BitmapFont bmp = new BitmapFont();
	String buf;
	float h,w;
	
	//Font
	BitmapFont soopafresh;
	
	//Header
	TextWrapper text;
	SpriteBatch batch;
	ElapsedTime timer;
	Sprite header;
	Texture gif;
	
	
	/**
	 * Constructeur prenant en paramètre un compteur
	 * @param t Un compteur (passé dans InGameScreen)
	 */
	public Window(ElapsedTime t)
	{ 
		map = new Map();
		timer = t;
		
	}

	/**
	 * Fonction d'initialisation initialisant les objets et les structures
	 * @param gc Un objet de type GameContainer
	 */
	public void initialise(GameContainer gc) {
		//Créer le header
		
		batch = new SpriteBatch();
		header = new Sprite(new Texture(Gdx.files.internal("res/img/Background/header.png")));	
		header.setPosition(0, 0);
		header.flip(false, true);
		text = new TextWrapper("init", new Vector2(170,0));
		//Générer la police soopafresh
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("res/font/soopafre.ttf"));
		soopafresh = generator.generateFont(28, FreeTypeFontGenerator.DEFAULT_CHARS, true);
		//Initialiser la map
		map.initialise(gc);	
		
		
		
	}
	
	public void update()
	{
	}
	
	/**
	 * Dessine le header et la carte
	 * @param g Un objet de type Graphics
	 */
	public void render(Graphics g) {
		
		batch.begin();
		
		//Charger la police
		g.setFont(soopafresh);
		//Affichage du bandeau		
		g.drawSprite(header);		
		// Affichage du temps
		soopafresh.setColor(Color.valueOf("5491B4"));		
		buf = timer.sec() + "s";
		if (timer.min()!= 0)  buf = timer.min() + "m" + timer.sec() + "s";
		text.setText("Temps écoulé : "+buf);
		text.draw(batch, soopafresh);				
		// Affichage de la carte
		map.render(g);
		
		batch.end();
	}
}
