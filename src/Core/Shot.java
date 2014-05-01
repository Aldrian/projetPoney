package Core;

public class Shot extends Entity
{
	private int power;
	
	public Shot(int pow)
	{
		power=pow;
	}
	
	public int getPower()
	{
		return power;
	}

	@Override
	public void update(Entity e) {
		
		
	}
}
