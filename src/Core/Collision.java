package Core;

import java.util.*;

public class Collision
{
	Entity e1;
	Entity e2;
	
	public Collision(Entity e1,Entity e2)
	{
		this.e1=e1;
		this.e2=e2;
	}
	
	public void update()
	{
		if (e1 instanceof Player)
		{
			if (e2 instanceof Monster)
			{
				e1.update(Event.Death);
			}
			else if (e2 instanceof Bomb)
			{
				if (((Bomb)e2).isWeapon())
				{
					e1.update(Event.WeaponUp);
				}
				e2.update(Event.Death);
			}
			else if (e2 instanceof Player)//A traiter ici ?
			{
				
			}
		}
		else if ((e1 instanceof Monster && e2 instanceof Shot) || (e2 instanceof Monster && e1 instanceof Shot))
		{
			if (e2 instanceof Monster)
			{
				Entity tmp=e2;
				e2=e1;
				e1=tmp;
			}
			
			if(((Shot) e2).getPower()==3)
				e1.update(Event.HealthMinus3);
			else
				e1.update(Event.HealthMinus);
			e2.update(Event.Death);
		}
		else if (e1 instanceof Bomb && e2 instanceof Player)
		{
			if (((Bomb)e1).isWeapon())
			{
				e2.update(Event.WeaponUp);
			}
			e2.update(Event.Death);
		}
	}
}
