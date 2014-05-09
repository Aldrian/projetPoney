package Core;

import org.mini2Dx.core.geom.Point;


public class Player extends MovingEntity
{
	private boolean state;
	private Weapon wp;
	
	
	@Override
	public void update(Event e)
	{
		if (e==Event.Death)
		{
				try {
					finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if (e==Event.PvP)
		{
			//Replacement ? gérer avant ?
		}
		else if(e==Event.WeaponUp)
		{
			this.setWp(new Laser());
			
		}
		// Pas d'autres cas
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public Weapon getWp() {
		return wp;
	}


	public void setWp(Weapon wp) {
		this.wp = wp;
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
