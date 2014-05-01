package Core;

public abstract class Weapon
{
	private int nbShots;
	private int power;
	
	public Weapon(int shots,int pow)
	{
		nbShots=shots;
		power=pow;
	}
	
	public Shot shoot()
	{
		if(nbShots>0)
		{
			nbShots--;
			return new Shot(power);
		}
		return null; //throws something serait mieux 
	}
	
	public void pluShot() //ou appeler la fonction ? on doit l'appeler à la disparition d'un tir
	{
		nbShots++;
	}
}
