package Core;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity
{
	private boolean state;
	private Weapon wp;
	
	/**
	 * Constructeur venant de Game.Player
	 */
	public Player() 
	{
		mouvement = new Move(new PointInt(400,200),new PointInt(400,200));

		mouvement = new Move(new PointInt(0,60),new PointInt(0,60));

		// Init l'affichage du joueur
		animation = new AnimatorPlayer(new Point(0,60));
		animation.create();
	}
	
	@Override
	public void update(Event e)
	{
		if (e==Event.Death)
		{
				try {
					finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if (e==Event.PvP)
		{
			//Replacement ? gérer avant ?
		}
		else if(e==Event.WeaponUp)
		{
			this.setWp(new Laser());
			
		}
		// Pas d'autres cas
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public Weapon getWp() {
		return wp;
	}


	public void setWp(Weapon wp) {
		this.wp = wp;
	}


	@Override
	public void move(PointInt p) {
		// TODO Auto-generated method stub
	}


	
	public boolean moveAllowed(PointInt p) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
