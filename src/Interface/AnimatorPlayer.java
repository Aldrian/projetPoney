package Interface;

import org.mini2Dx.core.geom.Point;

import Display.TextWrapper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;

/**
 * Classe dérivée d'animation d'un joueur
 * @author Gaëtan
 *
 */
public class AnimatorPlayer extends Animator {

	private static int typeJoueur = 1; // Joueur 1 ou Joeur 2
	
	private int joueur=0;
	
	BitmapFont oldGame;
	TextWrapper text;
	SpriteBatch textContainer;

	public AnimatorPlayer(Point origin) {
		super(origin);
		// TODO Auto-generated constructor stub
	}

	/**
	 * initialisation de l'animation
	 * Initialise différemment si la méthode est appelée pour la première fois ou non
	 */
	@Override
	public void create() 
	{
		FRAME_COLS = 4;
		FRAME_LINES = 3;
		
		if(typeJoueur == 1)
		{
			walkSheet = new Texture(Gdx.files.internal("res\\img\\J1\\1.png"));
			joueur =1;
		}
		else
		{
			walkSheet = new Texture(Gdx.files.internal("res\\img\\J2\\1.png"));
			joueur=2;
		}

		typeJoueur ++;

		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);

		walkFrames = new Array<TextureRegion>();
		walkAnimation = new Animation[4];

		for (int j = 0; j < FRAME_COLS; j++) {
			walkFrames.add(tmp[0][j]);
		}
		walkAnimation[0] = new Animation(0.20f, walkFrames);
		walkFrames.clear();

		for (int j = 0; j < FRAME_COLS; j++) {
			walkFrames.add(tmp[1][j]);
		}
		walkAnimation[1] = new Animation(0.20f, walkFrames);
		walkFrames.clear();

		walkFrames.add(tmp[2][0]);
		walkAnimation[2] = new Animation(0f, walkFrames);
		walkFrames.clear();

		walkFrames.add(tmp[2][1]);
		walkAnimation[3] = new Animation(0f, walkFrames);

		spriteBatch = new SpriteBatch();
		stateTime = 0f;
		
		// Création du texte
		textContainer = new SpriteBatch();
		text = new TextWrapper("init", renderPosition.set(renderPosition.x + 10, renderPosition.y + 50));
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("res/font/Minecraftia.ttf"));
		oldGame = generator.generateFont(14, FreeTypeFontGenerator.DEFAULT_CHARS, true);
		oldGame.setColor(Color.valueOf("FEFEFE"));
		oldGame.setScale(1, -1);
		text.setText("P" + joueur);
	}

	/**
	 * Surcharge le rendu graphique pour ajouter le texte flottant
	 */
	@Override
	public void render()
	{
		//Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = walkAnimation[typeAnimation].getKeyFrame(stateTime, true);
		currentFrame.setRegion(currentFrame, 0, 0, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);

		spriteBatch.begin();
		spriteBatch.draw(currentFrame, renderPosition.x , renderPosition.y);
		spriteBatch.end();
		
		text.setPosition(renderPosition.set(renderPosition.x + 20, renderPosition.y + 70));
		textContainer.begin();
		text.draw(textContainer, oldGame);
		textContainer.end();
	}
}
