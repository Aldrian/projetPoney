package Core;

import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity 
{
	private boolean state;
	private Weapon wp;
	public boolean tir=true;
	public boolean move=true;
	public boolean droite= true;
	public boolean saut=false;
	private boolean air=true;
	public int compteurSaut = 0;
	public PointInt posInitSaut = new PointInt(0,0);
	private int[][] blocks;
	
	/**
	 * Constructeur des joueurs
	 * @param p point de spawn
	 */
	public Player(PointInt p,Terrain terrain) 
	{
		super(p,p,54,54,new AnimatorPlayer(p.pointValue()));
		this.blocks=terrain.blocks;
	}

	
	public boolean canJump(Player player) {
		
		int posX = player.currentPosition.getX();
		int posY = player.currentPosition.getY();
		int ligne = posY/60;
		int colonne = posX/80;
		System.out.println("ligne " + ligne);
		System.out.println("colonne " + colonne);
		
		if (this.droite==true) {
			
			for (int i = 0; i<25;i++) {
				if ((this.blocks[ligne][colonne]==1) || (posX < 0) || ( posX > 800-54) || (posY < 0) || (posY > 600-54)) {
					//System.out.println("Faux !");
					return false;
				}
				else {
					
					posX=posX+2;
					posY=posY+8;
					
					ligne = posY/60;
					colonne = posX/80;
				}

			}
		}
			
		else {
			
			for (int i = 0; i<25;i++) {
				if ((this.blocks[ligne][colonne]==1) || (posX < 0) || (posX > 800-54) || (posY < 0) || (posY > 600-54)) {
					//System.out.println("Faux !");
					return false;
				}
				else {
					posX=posX-2;
					posY=posY+8;
					
					ligne = posY/60;
					colonne = posX/80;
				}
			}
		}
	return true;
	}
	
	//en cours de refonte
	public PointInt jump(PointInt posInit,PointInt mouvement) {
		// jump height = 200p;
		// jump width = 100p;
		
		if (this.compteurSaut < 50) {
			
			if (this.droite) {
				this.move=false;
				this.tir=false;
					
				if(this.compteurSaut<25) {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					mouvement.set(2,8);
					//System.out.println("CompteurSaut = " + compteurSaut);
					System.out.println("position =  " + this.currentPosition.getX() + "   /    " + this.currentPosition.getY() );
					this.compteurSaut++;
					return mouvement;
				}
				
				else {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					mouvement.set(2,-8);
					//System.out.println("CompteurSaut = " + compteurSaut);
					System.out.println("position =  " + this.currentPosition.getX() + "   /    " + this.currentPosition.getY() );
					this.compteurSaut++;
					return mouvement;
				}	
			}
			
			else {
				this.move=false;
				this.tir=false;
				
				if(this.compteurSaut<25) {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=true;
					}
					mouvement.set(-2,8);
					//System.out.println("CompteurSaut = " + compteurSaut);
					System.out.println("position =  " + this.currentPosition.getX() + "   /    " + this.currentPosition.getY() );
					this.compteurSaut++;
					return mouvement;
				}
				
				else {
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					mouvement.set(-2,-8);
					//System.out.println("CompteurSaut = " + compteurSaut);
					System.out.println("position =  " + this.currentPosition.getX() + "   /    " + this.currentPosition.getY() );
					this.compteurSaut++;
					return mouvement;
				}	
			}
		}
		else {
			this.saut=false;
			this.move=true;
			this.setAir(true);
			System.out.println("positionFinSaut =  " + this.currentPosition.getX() + "   /    " + this.currentPosition.getY() );
			//System.out.println("CompteurSautFin = " + compteurSaut);
			this.compteurSaut=0;
			mouvement.set(0,0);
			this.posInitSaut.set(0,0);
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

