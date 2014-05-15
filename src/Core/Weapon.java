package Core;

import Game.PointInt;

public abstract class Weapon
{
	protected int nbShots;
	
	/**
	 * Constructeur de Weapon
	 * @param shots
	 */
	public Weapon(int shots)
	{
		nbShots=shots;
	}
	
	/**
	 * Fonction appelé lorsqu'un joueur tire
	 * @param p position du joueur
	 * @param direction
	 * @return Shot
	 */
	public abstract Shot shoot(PointInt p,PointInt direction);
	
	//partie non encore définie
	public void pluShot() //ou appeler la fonction ? on doit l'appeler à la disparition d'un tir
	{
		nbShots++;
	}
}
