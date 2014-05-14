package Core;

import Game.PointInt;


public class Gun extends Weapon
{
	public Gun()
	{
		super(2);
	}
	
	public Shot shoot(PointInt p,PointInt direction)
	{
		if(nbShots>0)
		{
			nbShots--;
			return new Shot(p,direction,false);
		}
		return null; //throws something serait mieux 
	}
}
