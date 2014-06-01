package Core;

import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity implements Cloneable
{
	private boolean state;
	private Weapon wp;
	public boolean tir=true;
	public boolean move=true;
	public boolean droite= true;
	public boolean saut=false;
	private boolean air;
	
	/**
	 * Constructeur des joueurs
	 * @param p point de spawn
	 */
	public Player(PointInt p) 
	{
		super(p,p,54,54,new AnimatorPlayer(p.pointValue()));
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
		else if (e==Event.Stop||e==Event.Land)
		{
			this.update(new PointInt(0,0));
		}
		else if(e==Event.WeaponUp)
		{
			this.setWp(new Laser());
			
		}
		// Pas d'autres cas
	}

	/*
	 * Getters et setters
	 */
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


	/**
	 * M�thode pr�cisant si le mouvement est valable
	 * @param p direction demand�e
	 * @return boolean
	 */
	public boolean moveAllowed(PointInt p) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the air
	 */
	public boolean isAir() {
		return air;
	}

	/**
	 * @param air the air to set
	 */
	public void setAir(boolean air) {
		this.air = air;
	}
	
}

