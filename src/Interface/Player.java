package Interface;

import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;
import com.badlogic.gdx.math.Vector2;

/**
 * Repr�sentation du joueur
 * @author Ga�tan
 *
 */
public class Player 
{
	private Animator animation; // Animation associ�e

    private Move mouvement; // Mouvement courant du joueur
    
    public Player() 
    {
    	mouvement = new Move(new Point(400,200),new Point(400,200));

    	mouvement = new Move(new Point(0,60),new Point(0,60));
          
        // Init l'affiche du joeur
       animation = new AnimatorPlayer(new Point(0,60));
        animation.create();
     }
     
     /**
      * Maj de la position du joueur
      * @param direction
      */
     public void update(Point direction) 
     {
        mouvement.incrementDirection(direction.x, direction.y);
     }
     
     /**
      * Interpolation lin�raire de la direction du joueur : permet ainsi de calculer ses coordonn�es de rendu
      * synchronis�es avec l'horloge du jeu
      * @param alpha
      */
     public void interpolate(float alpha) 
     {
          //Use the lerp (linear interpolate) method from LibGDX 
          //to interpolate between the previous and current positions
          //This will return the render coordinates
          
    	 Vector2 renderPosition = mouvement.getOrigin().lerp(mouvement.getDirection(), alpha);
    	 animation.update(renderPosition.x, renderPosition.y, mouvement);
     }

     /**
      * Rendu graphique. Prend en param�tre le graphic.
      * @param g
      */
     public void render(Graphics g) 
     {
        animation.render();
     }
}
