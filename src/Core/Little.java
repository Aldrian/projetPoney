package Core;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;
import Interface.AnimatorSmallEnnemy;

public class Little extends Monster
{
	
	public Little()
	{
		health = 1;
		
		mouvement = new Move(new PointInt(200,400),new PointInt(200,400));
		
		// Init l'affichage de l'ennemi
		animation = new AnimatorSmallEnnemy(new Point(200,400));
		animation.create();
				
	}

	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}

		
}
