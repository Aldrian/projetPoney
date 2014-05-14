package Core;

import Game.Move;
import Game.PointInt;
import org.mini2Dx.core.graphics.Graphics;
import Interface.Animator;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity extends Entity {
	
	
	
	protected PointInt previousPosition; // Position pr�c�dente
	
	public void move(PointInt p) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Partie graphique
	 */
	protected Animator animation; // Animation associ�e
	protected Move mouvement; // Mouvement courant du personnage

	public void  update(PointInt direction)
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
	}
	
	
	/**
	 * Interpolation lin�raire de la direction du personnage : permet ainsi de calculer ses coordonn�es de rendu
	 * synchronis�es avec l'horloge du jeu
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
	 * Rendu graphique. Prend en param�tre le graphic.
	 * @param g
	 */
	public void render(Graphics g) 
	{
		animation.render();
	}
 
}
