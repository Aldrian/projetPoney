package Core;

import Game.PointInt;

public abstract class NotMovingEntity extends Entity {

	/**
	 * Constructeur appelant celui de la super classe
	 * @param p
	 */
	public NotMovingEntity(PointInt p)
	{
		super(p);
	}

	public NotMovingEntity(PointInt p, int w, int h) {
		super(p, w, h);
		// TODO Auto-generated constructor stub
	}
}
