package Core;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;
import Interface.AnimatorSmallEnnemy;

public class Little extends Monster
{
	
	public Little(PointInt p)
	{
		super(p,60,80,new AnimatorSmallEnnemy(p.pointValue()));// Valeurs brutes de la hitbox à préciser !
		health = 1;
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

		
}
