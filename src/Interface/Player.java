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
    private Point previousPosition; // Position pr�c�dente
    private Point currentPosition; // Position actuelle
     
    private Animator animation; // Animation associ�e

    public Player() 
    {
          previousPosition = new Point(400,200);
          currentPosition = new Point(400,200);
          
          // Init l'affiche du joeur
          animation = new Animator(new Point(400,200));
          animation.create();
     }
     
     /**
      * Maj de la position du joueur
      * @param direction
      */
     public void update(Point direction) 
     {
         previousPosition = new Point(currentPosition);
         currentPosition.set(currentPosition.x + direction.x, currentPosition.y + direction.y);
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
          
    	 Vector2 renderPosition = previousPosition.lerp(currentPosition, alpha);
    	 animation.update(renderPosition.x, renderPosition.y);
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