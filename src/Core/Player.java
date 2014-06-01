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
	public int compteurSaut = 0;
	public PointInt posInitSaut = new PointInt(0,0);
	
	/**
	 * Constructeur des joueurs
	 * @param p point de spawn
	 */
	public Player(PointInt p) 
	{
		super(p,p,54,54,new AnimatorPlayer(p.pointValue()));
	}
	
	public Player clone() {
		Player o = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			o = (Player) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return o;
	}
	
	public boolean canJump() {
		
		/*PointInt posInit = this.currentPosition;
		Player p = (Player) this.clone();
		
		
		if (this.droite==true) {
			
			for (int i = 0; i<25;i++) {
				if (p.collideMovingEntity()) {
					return false;
				}
					
				p.currentPosition.setX(p.currentPosition.getX()+2);
				p.currentPosition.setY(p.currentPosition.getY()+4);
			}
		}
			
		else {
			
			for (int i = 0; i<25;i++) {
				if (p.collideMovingEntity()) {
					return false;
				}
					
				p.currentPosition.setX(p.currentPosition.getX()-2);
				p.currentPosition.setY(p.currentPosition.getY()+4);
			}
		}*/
	return true;
	}
	
	//en cours de refonte
	public PointInt jump(PointInt posInit,PointInt mouvement) {
		// jump height = 200p;
		// jump width = 100p;
		
		if (this.currentPosition.getX() <= posInit.getX()+100) {
			
			if (this.droite) {
				System.out.println("Saut à droite en cours");
				this.move=false;
				this.tir=false;
					
				if(this.compteurSaut<25) {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					mouvement.set(2,8);
					this.compteurSaut++;
					return(mouvement);
				}
				
				else {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					mouvement.set(2,-8);
					this.compteurSaut++;
					return(mouvement);
				}	
			}
			
			else {
				System.out.println("Saut à gauche en cours");
				System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
				this.move=false;
				this.tir=false;
				
				if(this.compteurSaut<25) {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					mouvement.set(-2,8);
					this.compteurSaut++;
					System.out.println("compteurSaut = " + this.compteurSaut);
					return(mouvement);
				}
				
				else {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					mouvement.set(-2,-8);
					this.compteurSaut++;
					return mouvement;
				}	
			}
		}
		else {
			this.saut=false;
			this.posInitSaut.set(0, 0);
			mouvement.set(0, 0);
			System.out.println("Saut terminé");
			return (mouvement);
		}
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

