package Core;

import Game.PointInt;


public class Bomb extends NotMovingEntity
{
	/**
	 * Constructeur de bombes
	 * @param p point d'apparition de la bombe
	 */
	
	public Bomb(PointInt p)
	{
		super(p);

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
