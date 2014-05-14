package Core;

import Game.PointInt;


public class Laser extends Weapon
{
	public Laser()
	{
		super(1);
	}
	
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

/*
 *  LASER : Cahier des charges:
 *  Un seul tir à la fois 
 *  Possiblité de l'utiliser pendant 5 secondes après pickup
 *  Le laser traverse les ennemis et ne disparait que contre un mur ou une plateforme
 *	1PV par ennemi traversé   
 */
