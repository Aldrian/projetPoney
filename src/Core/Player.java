package Core;

import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity implements Cloneable
{
	private boolean state;
	private Weapon wp;
	private boolean tir=true;
	private boolean move=true;
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
	
	public Player clone() {
		Player o = null;
		try {
			// On r�cup�re l'instance � renvoyer par l'appel de la 
			// m�thode super.clone()
			o = (Player) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous impl�mentons 
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
			while (p.currentPosition.getX() != posInit.getX() + 50) {
				
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
		}*/
	return true;
	}
	
	public void jump(PointInt mouvement) {
		// jump height = 200p;
		// jump width = 100p;
		
		PointInt posInit = this.currentPosition;
		System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
		System.out.println("D�but saut si possible");
		if (this.canJump()) {
			this.saut=true;
			System.out.println("Saut possible");
			System.out.println("saut en cours");
			if (this.droite) {
				System.out.println("Saut � droite en cours");
 				System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
				this.move=false;
				this.tir=false;
				
				for (int i = 0; i<50;i++) {
					if(i<25) {
						if (this.currentPosition.getY() == posInit.getY() + 180) {
							this.tir=true;
						}
						System.out.println("debut update");
						mouvement.set(2,8);
						this.update(mouvement);
						System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
						System.out.println("fin update");
					}
					
					else {
						if (this.currentPosition.getY() == posInit.getY() + 180) {
							this.tir=false;
						}
						mouvement.set(2,-8);
						this.update(mouvement);
					}
				}	
			}
			
			else {
				System.out.println("Saut � gauche en cours");
				System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
				this.move=false;
				this.tir=false;
				
				for (int i = 0; i<50;i++) {
					if(i<25) {
						if (this.currentPosition.getY() == posInit.getY() + 180) {
							this.tir=true;
						}
						System.out.println("debut update");
						mouvement.set(-2,8);
						this.update(mouvement);
						System.out.println("currentPos" + this.currentPosition.getX() + "  /  " + this.currentPosition.getY());
						System.out.println("fin update");
					}
					
					else {
						if (this.currentPosition.getY() == posInit.getY() + 180) {
							this.tir=false;
						}
						mouvement.set(-2,-8);
						this.update(mouvement);
					}
				}	
			}
		}
		System.out.println("Saut impossible");
		this.move=true;
		//this.saut=false;
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

