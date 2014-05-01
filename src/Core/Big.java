package Core;

public class Big extends Monster
{
	public Big()
	{
		health=3;
	}

	@Override
	public void update(Entity e)
	{
		if (e instanceof Shot)
		{
			if(((Shot) e).getPower()>=3)
				finalize();
			else
				health--;
			if (health==0)
				finalize();
		}
		else if (e instanceof Player)
		{
			//Player eliminé ==> how ? Besoin de le gérer ici ?
		}
		// Pas d'autres cas
	}
}
 