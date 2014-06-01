package Core;

import Game.PointInt;
import Interface.AnimatorSmallEnnemy;

public class Little extends Monster
{
	/**
	 * Constructeur de Little Monster
	 * @param p
	 */
	public Little()
	{
		super(spawn,60,80,new AnimatorSmallEnnemy(spawn.pointValue()));// Valeurs brutes de la hitbox à préciser !
		health = 1;
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

		
}
