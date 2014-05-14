package Core;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;
import Interface.AnimatorBigEnnemy;

public class Big extends Monster
{
	public Big()
	{
		health = 3;
		
		mouvement = new Move(new PointInt(0,200),new PointInt(0,200));
		
		// Init l'affichage de l'ennemi
		animation = new AnimatorBigEnnemy(new Point(0,200));
		animation.create();
				
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

	

}
 