package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;

/**
 * Etat de fin de jeu proposant un affichage des scores, et une possibilité de 
 * recommencer une partie en appuyant sur une touche.
 * @author Julien
 *
 */
public class EndGameScreen implements GameScreen {
	
	//Font
	BitmapFont soopafresh;
	SpriteBatch batch;
	TextWrapper text;
	Sprite fond;

	boolean appuiTouche;
	
    public static int ID = 3;
    
    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    
    /**
     * Méthode d'initialisation appelée au début du jeu, initialisant les objets.
     */
    public void initialise(GameContainer gc) {
    	appuiTouche = false;
    	batch = new SpriteBatch();
    	
	    fond = new Sprite(new Texture(Gdx.files.internal("res/img/Background/end.png")));
		fond.setPosition(0, 0);
	    fond.flip(false, true);
	    
	  //Générer la police soopafresh
	    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("res/font/soopafre.ttf"));
  		soopafresh = generator.generateFont(28, FreeTypeFontGenerator.DEFAULT_CHARS, true);
	    
	    text = new TextWrapper("init", new Vector2(170,0));
    }

    /**
     * Attends un appui sur une touche pour redémarrer le jeu
     * Rappelle la fonction d'initialiation des autres écran pour revenir à l'écran 
     * de départ.
     */
    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
    	if (Gdx.input.isKeyPressed(Keys.ANY_KEY)) appuiTouche = true;
    	if(appuiTouche) {
    		screenManager.getGameScreen(LoadingGameScreen.ID).initialise(gc);
    		screenManager.getGameScreen(InGameScreen.ID).initialise(gc);
    		screenManager.getGameScreen(LoadingScreen.ID).initialise(gc);
            //Fade to LoadingScreen
            screenManager.enterGameScreen(LoadingScreen.ID, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void interpolate(GameContainer gc, float alpha) {
    }

    /**
     * Dessine le fond et affiche les scores
     */
    public void render(GameContainer gc, Graphics g) {
    	soopafresh.setColor(Color.valueOf("5491B4"));
    	g.drawSprite(fond);
    	    	
    	
    	
    	/*soopafresh.setColor(Color.valueOf("5491B4"));	
		text.setText("Press space to replay!");
		text.draw(batch, soopafresh);	*/
				
		
    }

    
    /**************************************************************/
    /**************************************************************/
    /**************************************************************/
    public void preTransitionIn(Transition transitionIn) {
        // Called before transitioning in
    }

    public void postTransitionIn(Transition transitionIn) {
        // Called after transitioning in
    }

    public void preTransitionOut(Transition transitionOut) {
        // Called before transitioning out
    }

    public void postTransitionOut(Transition transitionOut) {
        // Called after transitioning out
    }

    public int getId() {
        return ID;
    }
}