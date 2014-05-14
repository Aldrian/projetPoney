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
		super(p,60,80,new AnimatorBigEnnemy(p.pointValue())); //Valeurs brute de la hitbox à modifier en fonction taille des sprites
		health = 3;				
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

	

}
 