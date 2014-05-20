package Core;

import Game.PointInt;

public class Wall extends NotMovingEntity {

	/**
	 * Constructeur de wall
	 * @param p
	 */
	public Wall(PointInt p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Wall(PointInt p, int w, int h) {
		super(p, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Event e) throws Throwable {
		// TODO Auto-generated method stub

	}

}
