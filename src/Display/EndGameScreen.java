package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class EndGameScreen implements GameScreen {
	BitmapFont bmp = new BitmapFont();
    public static int ID = 3;

    private float loadingTime = 1f;
    
    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    
    public void initialise(GameContainer gc) {}

    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
        
    }

    public void interpolate(GameContainer gc, float alpha) {
    }

    public void render(GameContainer gc, Graphics g) {
    	
    	float w = bmp.getBounds("Game over !").width;
    	float h = bmp.getBounds("Game over !").height;
    	g.drawString("Game over !", (800-w)/2, (700-h)/2);
    	
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