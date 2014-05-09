package Core;

public abstract class Monster extends MovingEntity
{
	protected  int health;
	
	@Override
	public void update(Event e)
	{
		if (e==Event.HealthMinus)
			health--;
		
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
}
