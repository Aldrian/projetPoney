package Core;

import Game.PointInt;


public class Laser extends Weapon
{
	/**
	 * Constructeur du laser
	 */
	public Laser()
	{
		super(1);
	}
	
	@Override
	public Shot shoot(PointInt p,PointInt direction)
	{
		if(nbShots>0)
		{
			nbShots--;
			return new Shot(p,direction,true);
		}
		return null; //throws something serait mieux 
	}
}

