package Interface;

import org.mini2Dx.core.geom.Point;

/**
 * Repr�sentation d'un joueur
 * @author Ga�tan
 *
 */
public class Player extends Character
{
	public Player() 
	{
		mouvement = new Move(new PointInt(400,200),new PointInt(400,200));

		mouvement = new Move(new PointInt(0,60),new PointInt(0,60));

		// Init l'affiche du joeur
		animation = new AnimatorPlayer(new Point(0,60));
		animation.create();
	}
}
