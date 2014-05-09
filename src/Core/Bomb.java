package Core;

import org.mini2Dx.core.geom.Point;

public class Bomb extends NotMovingEntity
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
			try {
				finalize();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}



}
