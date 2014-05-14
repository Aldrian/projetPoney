package Core;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;
import Interface.AnimatorBigEnnemy;
import Interface.AnimatorSmallEnnemy;

public class Big extends Monster
{
	public Big(PointInt p)
	{
		super(p,new AnimatorBigEnnemy(p.pointValue()));
		health = 3;				
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

	

}
 