package Core;

import Game.PointInt;
import Interface.AnimatorGunShot;
import Interface.AnimatorLaserShot;

public class Shot extends MovingEntity
{
	
	
	private boolean laser;
	
	
	/**
	 * Constructeur
	 * @param p
	 * @param direction
	 * @param laser
	 */
	public Shot(PointInt p, PointInt direction,boolean laser) {
		super(p, direction);
		
		this.laser=laser;
		
		if (laser)
		{
			super.setAnimation(new AnimatorLaserShot(p.pointValue()));
			this.setWidth(50);
			this.setHeight(1);//set width and height 
		}
		else
		{
			super.setAnimation(new AnimatorGunShot(p.pointValue()));
			this.setWidth(1);
			this.setHeight(1);//set width and height
		}
	}



	@Override
	public void update(Event e) throws Throwable
	{
		if (e==Event.Death)
				finalize();
		else if (e==Event.HealthMinus)
		{
			if(!laser)
				finalize();
		}
		
	}



	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}



	/**
	 * @return the laser
	 */
	public boolean isLaser() {
		return laser;
	}



	/**
	 * @param laser the laser to set
	 */
	public void setLaser(boolean laser) {
		this.laser = laser;
	}



	

}
