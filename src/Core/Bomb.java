package Core;

import org.mini2Dx.core.geom.Point;

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
			try {
				finalize();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

	@Override
	public Entity move(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean moveAllowed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}
