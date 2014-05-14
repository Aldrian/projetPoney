package Core;


public class Bomb extends NotMovingEntity
{
	public Bomb()
	{
		
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
