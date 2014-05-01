package Core;

public class Little extends Monster
{
	
	public Little()
	{
		health=1;
	}
	
	@Override
	public void update(Entity e)
	{
		if (e instanceof Shot)
		{
				finalize();
		}
		else if (e instanceof Player)
		{
			//Player eliminé ==> how ? Besoin de le gérer ici ?
		}
		// Pas d'autres cas
	}
}
