package Core;

public class Bomb extends Entity
{
	private boolean weapon;
	
	public Bomb(boolean weapon)
	{
		this.weapon=weapon;
	}
	
	public boolean isWeapon()
	{
		return weapon;
	}
	
	@Override
	public void update(Event e) {
		if(e==Event.Death)
			finalize();

	}

}
