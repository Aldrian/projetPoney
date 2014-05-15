package Core;

import Game.PointInt;
import Interface.AnimatorBigEnnemy;

public class Big extends Monster
{
	/**
	 * Constructeur des gros monstres
	 * @param p point de spawn
	 */
	public Big(PointInt p)
	{
		super(p,60,80,new AnimatorBigEnnemy(p.pointValue())); //Valeurs brute de la hitbox à modifier en fonction taille des sprites
		health = 3;				
	}
}
 