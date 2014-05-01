package Core;

public abstract class Weapon
{
	protected int nbShots;
	
	public Weapon(int shots)
	{
		nbShots=shots;
	}
	
	public Shot shoot()
	{
		if(nbShots>0)
		{
			nbShots--;
			return new Shot(nbShots);
		}
		return null; //throws something serait mieux 
	}
	
	public void pluShot() //ou appeler la fonction ? on doit l'appeler à la disparition d'un tir
	{
		nbShots++;
	}
}
