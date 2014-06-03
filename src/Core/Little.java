package Core;

import Game.PointInt;
import Interface.AnimatorSmallEnnemy;

public class Little extends Monster
{
	/**
	 * Constructeur de Little Monster
	 * @param p
	 */
	public Little(PointInt spawn)
	{
		super(spawn,new PointInt(0,0),54,54,new AnimatorSmallEnnemy(spawn.pointValue()));// Valeurs brutes de la hitbox à préciser !
		health = 1;
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

		
}
