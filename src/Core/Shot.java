package Core;

import Game.PointInt;
import Interface.Animator;
import Interface.AnimatorGunShot;
import Interface.AnimatorLaserShot;

public class Shot extends MovingEntity
{
	
	
	private boolean laser;
	
	

	public Shot(PointInt p, PointInt direction,boolean laser) {
		super(p, direction);
		
		this.laser=laser;
		
		if (laser)
		{
			super.setAnimation(new AnimatorLaserShot(p.pointValue()));
			//set width and height 
		}
		else
		{
			super.setAnimation(new AnimatorGunShot(p.pointValue()));
			//set width and height
		}
	}



	@Override
	public void update(Event e) throws Throwable
	{
		try {
			if (e==Event.Death)
				finalize();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}



	

}
