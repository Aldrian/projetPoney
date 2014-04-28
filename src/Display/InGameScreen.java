package Display;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import Interface.MyInputProcessor;
import Interface.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class InGameScreen implements GameScreen {
    public static int ID = 2;
    private boolean jeuFini;

	Window w;
    Player P1;
    MyInputProcessor in;
    
    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    

    public void initialise(GameContainer gc) {
    	w = new Window();
    	w.initialise(null);
    	jeuFini = false;
    	
    	P1 = new Player();
    	in = new MyInputProcessor(P1);
    	Gdx.input.setInputProcessor(in);
    	
    }

    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
    	
    	if (Gdx.input.isKeyPressed(Keys.SPACE)) jeuFini = true;
    	if(jeuFini) {
            //Fade to EndGameScreen
            screenManager.enterGameScreen(EndGameScreen.ID, new FadeOutTransition(), new FadeInTransition());
        }
    	w.update();
    	in.keyboardProcessing();
    }

    public void interpolate(GameContainer gc, float alpha) {	
    	P1.interpolate(alpha);
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
    	
        w.render(g);
        P1.render(g);
        
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
    
    public boolean isJeuFini() {
		return jeuFini;
	}

	public void setJeuFini(boolean jeuFini) {
		this.jeuFini = jeuFini;
	}
}