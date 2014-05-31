package Core;

import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity implements Cloneable
{
	private boolean state;
	private Weapon wp;
	private boolean tir=true;
	private boolean move=true;
	private boolean air;
	
	/**
	 * Constructeur des joueurs
	 * @param p point de spawn
	 */
	public Player(PointInt p) 
	{
		super(p,p,54,54,new AnimatorPlayer(p.pointValue()));
	}
	
	public Object clone() {
		Object o = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return o;
	}
	
	public boolean canJump() {
		
		PointInt posInit = this.currentPosition;
		Player p = (Player) this.clone();
		
		if (this.currentPosition.getX() > this.previousPosition.getX()) {
			while (p.currentPosition.getX()!=posInit.getX() + 50) {
				
				if (p.collideMovingEntity()) {
					return false;
				}
				
				p.currentPosition.setX(p.currentPosition.getX()+2);
				p.currentPosition.setY(p.currentPosition.getY()+4);
			}
		}
		
		else {
			while (p.currentPosition.getX()!=posInit.getX() - 50) {
				
				if (p.collideMovingEntity()) {
					return false;
				}
				
				p.currentPosition.setX(p.currentPosition.getX()-2);
				p.currentPosition.setY(p.currentPosition.getY()+4);
			}
		}
		
	return true;
	}
	//
	
	public boolean jump() {
		// jump height = 200p;
		// jump width = 100p;
		
		PointInt posInit = this.currentPosition;
		
		if (this.currentPosition.getX() > this.previousPosition.getX()) {
			
			if (!canJump()) {
				return false;
			}
			
			else {
				this.move=false;
				this.tir=false;
				
				while (this.currentPosition.getX()!=posInit.getX() + 50) {
					
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					
					this.currentPosition.setX(this.currentPosition.getX()+2);
					this.currentPosition.setY(this.currentPosition.getY()+4);
				}
				
				while (this.currentPosition.getX() ==posInit.getX()+100) {
					
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					
					this.currentPosition.setX(this.currentPosition.getX()+2);
					this.currentPosition.setY(this.currentPosition.getY()-4);
				
				}
				this.move=true;
				
			}
		}
		
		else {
			
			if (!canJump()) {
				return false;
			}
			
			else {
				this.move=false;
				this.tir=false;
				
				while (this.currentPosition.getX()!=posInit.getX() - 50) {
					
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					
					this.currentPosition.setX(this.currentPosition.getX()-2);
					this.currentPosition.setY(this.currentPosition.getY()+4);
				}
				
				while (this.currentPosition.getX() ==posInit.getX()-100) {
					
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					
					this.currentPosition.setX(this.currentPosition.getX()-2);
					this.currentPosition.setY(this.currentPosition.getY()-4);
				
				}
				this.move=true;
				
			}
		}
		return true;
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
		else if (e==Event.Stop)
		{
			//Replacement ? gï¿½rer avant ?
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
	 * Mï¿½thode prï¿½cisant si le mouvement est valable
	 * @param p direction demandï¿½e
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
