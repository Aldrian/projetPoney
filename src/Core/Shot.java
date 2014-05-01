package Core;

import org.mini2Dx.core.geom.Point;

public class Shot extends Entity
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
