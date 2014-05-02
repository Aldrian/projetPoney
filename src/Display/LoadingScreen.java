package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class LoadingScreen implements GameScreen {
    public static int ID = 1;

    private float loadingTime = 1f;
    
    Sprite fond;

    
    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    
    public void initialise(GameContainer gc) {
    	
    	fond = new Sprite(new Texture(Gdx.files.internal("res/img/title.png")));
    	fond.setPosition(75, 100);
	    fond.flip(false, true);
    }

    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
        if(loadingTime > 0f) {
            loadingTime -= delta;
            if(loadingTime < 0f) {
                //Fade to InGameScreen after 4 seconds
                screenManager.enterGameScreen(InGameScreen.ID, new FadeOutTransition(),
            new FadeInTransition());
            }
        }
    }

    public void interpolate(GameContainer gc, float alpha) {
    }

    public void render(GameContainer gc, Graphics g) {
    	g.setColor(Color.valueOf("C1DDDE"));	
		g.fillRect(0, 0, 800, 700); 
		g.drawSprite(fond);
		
		
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