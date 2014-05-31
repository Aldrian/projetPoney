package Core;

import Game.PointInt;

public class Box extends NotMovingEntity {

	/**
	 * Constructeur de Box
	 * @param p spawn point
	 */
	public Box(PointInt p) {
		super(p);
		// TODO Auto-generated constructor stub
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
