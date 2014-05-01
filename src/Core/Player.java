package Core;


public class Player extends Entity
{
	private boolean state;
	private Weapon wp;
	
	
	@Override
	public void update(Event e)
	{
		if (e==Event.Death)
		{
				finalize();
		}
		else if (e==Event.PvP)
		{
			//Replacement ? gérer avant ?
		}
		else if(e==Event.WeaponUp)
		{
			this.wp=new Laser();
			
		}
		// Pas d'autres cas
	}
	
	
}
