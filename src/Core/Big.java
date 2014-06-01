package Core;

import Game.PointInt;
import Interface.AnimatorBigEnnemy;

public class Big extends Monster
{
	/**
	 * Constructeur des gros monstres
	 * @param p point de spawn
	 */
	public Big()
	{
		super(spawn,60,80,new AnimatorBigEnnemy(spawn.pointValue())); //Valeurs brute de la hitbox à modifier en fonction taille des sprites
		health = 3;				
	}
}
 