package Game;

import org.mini2Dx.core.geom.Point;

import Interface.AnimatorBigEnnemy;

/**
 * Boss
 * @author Gaëtan
 *
 */
public class BigEnnemy extends Character {

	public BigEnnemy()
	{
		mouvement = new Move(new PointInt(0,200),new PointInt(0,200));
		
		// Init l'affichage de l'ennemi
		animation = new AnimatorBigEnnemy(new Point(0,200));
		animation.create();
				
	}
}
