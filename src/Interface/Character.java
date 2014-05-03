package Interface;

import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.math.Vector2;

public abstract class Character {

	protected Animator animation; // Animation associée
	protected Move mouvement; // Mouvement courant du personnage
	
	/**
	 * Maj de la position du joueur
	 * @param direction
	 */
	public void update(PointInt direction) 
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
	}
	
	/**
	 * Interpolation linéraire de la direction du personnage : permet ainsi de calculer ses coordonnées de rendu
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
