package Core;

import java.util.Random;

import Game.PointInt;
import Interface.Animator;

public abstract class Monster extends MovingEntity
{
	protected  int health;
	protected boolean air;
	private static PointInt spawn;
	private static Random r;
	
	
	public static void setSpawn(PointInt p)
	{
		spawn=p;
	}
	
	public boolean isAir() {
		return air;
	}

	public void setAir(boolean air) {
		this.air = air;
	}

	/**
	 * Constructeur de Monster
	 * @param p spawn point
	 * @param w width
	 * @param h height
	 * @param a animation
	 */
	public Monster(PointInt p,int w,int h, Animator a)
	{
		super(p,new PointInt(0,-9),w,h,a);
	}

	@Override
	public void update(Event e)
	{
		if (e==Event.HealthMinus)
			health--;
		
		else if (e==Event.Repop)
		{
			this.currentPosition.set(spawn.getX(), spawn.getY());
		}
		
		else if (e==Event.Otherside)
		{
			if(getCPx()==0)
			{
				this.currentPosition.setX(800-width);
			}
			else
				this.currentPosition.setX(0);
		}
		
		else if (e==Event.Land)
		{
			if (r.nextBoolean())	
				this.update(new PointInt(2,0));
			else
				this.update(new PointInt(-2,0));
		}
		
		if(health<=0)
		{
			try {
				finalize();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
		super.move(p);
	}
}
