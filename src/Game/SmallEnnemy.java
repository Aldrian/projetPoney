package Game;

import org.mini2Dx.core.geom.Point;

import Interface.AnimatorSmallEnnemy;

/**
 * Petite mouche
 * @author Gaëtan
 *
 */
public class SmallEnnemy extends Character {

	public SmallEnnemy()
	{
		mouvement = new Move(new PointInt(200,400),new PointInt(200,400));
		
		// Init l'affichage de l'ennemi
		animation = new AnimatorSmallEnnemy(new Point(200,400));
		animation.create();
				
	}
}
