package Core;

public abstract class Monster extends Entity
{
	protected  int health;
	
	@Override
	public void update(Event e)
	{
		if (e==Event.HealthMinus)
			health--;
		else if(e==Event.HealthMinus3)
		{
			health-=3;
		}
		if(health<=0)
		{
			finalize();
		}
	}
}
