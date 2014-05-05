package Display;

import java.util.ArrayList;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import Game.Player;
import Game.SmallEnnemy;
import Interface.MyInputProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class InGameScreen implements GameScreen {
    public static int ID = 2;
    private boolean jeuFini;

	Window w;
    Player P1;
    Player P2;
    MyInputProcessor in;
    SmallEnnemy mouche;

    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    

    public void initialise(GameContainer gc) {
    	// Initialisation de la map
    	w = new Window();
    	w.initialise(null);
    	jeuFini = false;
    	
    	//Initialisation du poney et du déplacement
    	P1 = new Player();
    	P2 = new Player();
    	mouche = new SmallEnnemy();
    	in = new MyInputProcessor(P1,P2);
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
    	P2.interpolate(alpha);
    	mouche.interpolate(alpha);
    }

    public void render(GameContainer gc, Graphics g) {
    		
    	
        w.render(g);
        P1.render(g);
        P2.render(g);
        mouche.render(g);
        
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