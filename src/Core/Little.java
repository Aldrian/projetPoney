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
			//Player elimin� ==> how ? Besoin de le g�rer ici ?
		}
		// Pas d'autres cas
	}
}
