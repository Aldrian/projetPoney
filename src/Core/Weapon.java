package Core;

import Game.PointInt;

public abstract class Weapon
{
	protected int nbShots;
	
	public Weapon(int shots)
	{
		nbShots=shots;
	}
	
	public abstract Shot shoot(PointInt p,PointInt direction);
	
	
	public void pluShot() //ou appeler la fonction ? on doit l'appeler à la disparition d'un tir
	{
		nbShots++;
	}
}
