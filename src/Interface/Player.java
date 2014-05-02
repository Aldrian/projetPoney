package Interface;

import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;
import com.badlogic.gdx.math.Vector2;

/**
 * Représentation du joueur
 * @author Gaëtan
 *
 */
public class Player 
{
	private Animator animation; // Animation associée

	private Move mouvement; // Mouvement courant du joueur

	public Player() 
	{
		mouvement = new Move(new PointRender(400,200),new PointRender(400,200));

		mouvement = new Move(new PointRender(0,60),new PointRender(0,60));

		// Init l'affiche du joeur
		animation = new AnimatorPlayer(new Point(0,60));
		animation.create();
	}

	/**
	 * Maj de la position du joueur
	 * @param direction
	 */
	public void update(PointRender direction) 
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
	}

	/**
	 * Interpolation linéraire de la direction du joueur : permet ainsi de calculer ses coordonnées de rendu
	 * synchronisées avec l'horloge du jeu
	 * @param alpha
	 */
	public void interpolate(float alpha) 
	{
		//Use the lerp (linear interpolate) method from LibGDX 
		//to interpolate between the previous and current positions
		//This will return the render coordinates

		Vector2 renderPosition = mouvement.getOrigin().pointValue().lerp(mouvement.getDirection().pointValue(), alpha);
		animation.update(renderPosition.x, renderPosition.y, mouvement);
	}

	/**
	 * Rendu graphique. Prend en paramètre le graphic.
	 * @param g
	 */
	public void render(Graphics g) 
	{
		animation.render();
	}
}
