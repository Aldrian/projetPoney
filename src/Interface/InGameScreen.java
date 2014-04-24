package Interface;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class InGameScreen implements GameScreen {
    public static int ID = 2;
    boolean jeuFini;
    
    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    

    public void initialise(GameContainer gc) {
    	jeuFini = false;
    }
    @SuppressWarnings("rawtypes")
    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
    	
    	if (Gdx.input.isKeyPressed(Keys.SPACE)) jeuFini = true;
    	if(jeuFini) {
            //Fade to EndGameScreen
            screenManager.enterGameScreen(EndGameScreen.ID, new FadeOutTransition(),
        new FadeInTransition());
        }
    	
    }

    public void interpolate(GameContainer gc, float alpha) {
    }

    public void render(GameContainer gc, Graphics g) {
    	/*g.drawRect(0, 0, 800, 600);
    	
        g.setColor(Color.PINK);
        g.fillRect(0, 0, 800, 600);
        
        g.setColor(Color.MAGENTA);
        
        g.fillRect(0, 0, 360, 60);     
        g.fillRect(440, 0, 360, 60);  
        
        g.fillRect(60, 180, 680, 60);
        
        g.fillRect(0, 360, 250, 60);
        g.fillRect(550, 360, 250, 60);
        
        g.fillRect(0, 540, 360, 60); 
        g.fillRect(440, 540, 360, 60);*/	
        
        Map m = new Map();
        m.render(g);
        
        
   }
    
    /**************************************************************/
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