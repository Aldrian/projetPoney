package Display;

import java.util.ArrayList;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import Core.Player;
import Core.Little;
import Game.PointInt;
import Interface.AnimatorCountDown;
import Interface.MyInputProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Etat principal du jeu, définit l'état dans lequel la partie se joue.
 * @author Julien
 *
 */
public class InGameScreen implements GameScreen {
    public static int ID = 2;
    private boolean jeuFini;

	Window w;
    Player P1;
    Player P2;
    MyInputProcessor in;
    Little mouche;
    AnimatorCountDown countDown;
    ElapsedTime t;

    /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    

    /**
     * Appelé au lancement du jeu (et non lors de la transition d'état)
     * Initialise les structures et les objets
     */
    public void initialise(GameContainer gc) {
    	// Initialisation du timer
    	t = new ElapsedTime();
    	// Initialisation de la map
    	w = new Window(t);
    	w.initialise(null);
    	jeuFini = false;
    	
    	//Initialisation du poney et du déplacement
    	P1 = new Player(new PointInt(200,60));
    	P2 = new Player(new PointInt(0,60));
    	mouche = new Little(new PointInt(50,60));
    	in = new MyInputProcessor(P1,P2);
    	Gdx.input.setInputProcessor(in);
    	
    	countDown = new AnimatorCountDown(new Point(0,0));
    	countDown.create();
    }

    /**
     * Attends l'appui sur espace pour mettre fin à la partie (temporaire)
     * appelle la fonction update de la fenêtre
     * Récupère la touche saisie par l'utilisateur
     */
    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
    	
    	if (Gdx.input.isKeyPressed(Keys.SPACE)) jeuFini = true;
    	if(jeuFini) {
            //Fade to EndGameScreen
    		t.getT().arret();
            screenManager.enterGameScreen(EndGameScreen.ID, new FadeOutTransition(), new FadeInTransition());
        }
    	w.update();
    	in.keyboardProcessing();
    }

    
    
    /**
     * Effectue une interpolation linéaire des objets en mouvement
     */
    public void interpolate(GameContainer gc, float alpha) {	
    	P1.interpolate(alpha);
    	P2.interpolate(alpha);
    	mouche.interpolate(alpha);
    }

    /**
     * Dessine la fenêtre et les objets en mouvement
     */
    public void render(GameContainer gc, Graphics g) {

    	w.render(g);
    	P1.render(g);
    	P2.render(g);
    	countDown.render();
   }
    
    /**************************************************************/
    /**************************************************************/
    /**************************************************************/
    /**************************************************************/

    public void preTransitionIn(Transition transitionIn) {
        // Called before transitioning in
    }

    /**
     * A l'arrivée sur l'état, démarre le compteur de jeu
     */
    public void postTransitionIn(Transition transitionIn) {
        t.getT().start();
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

    /**
     * Appelé à la fin du jeu, met à jour le booléen afin que la partie se termine.
     * @param jeuFini
     */
	public void setJeuFini(boolean jeuFini) {
		this.jeuFini = jeuFini;
	}
}