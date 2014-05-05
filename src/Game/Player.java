package Game;

import org.mini2Dx.core.geom.Point;

import Interface.AnimatorPlayer;

/**
 * Représentation d'un joueur
 * @author Gaëtan
 *
 */
public class Player extends Character
{
	public Player() 
	{
		mouvement = new Move(new PointInt(400,200),new PointInt(400,200));

		mouvement = new Move(new PointInt(0,60),new PointInt(0,60));

		// Init l'affichage du joueur
		animation = new AnimatorPlayer(new Point(0,60));
		animation.create();
	}
}
