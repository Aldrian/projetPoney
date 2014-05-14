package Core;

import Game.PointInt;

public class Shot extends MovingEntity
{
	@SuppressWarnings("unused")
	private int shotType;
	@SuppressWarnings("unused")
	private boolean laser;
	
	

	public Shot(int shotType) {
		super();
		this.shotType = shotType;
		
		if (shotType > 2) laser = true;
		else laser = false;
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
