package Core;

import Game.PointInt;
import Interface.AnimatorPlayer;


public class Player extends MovingEntity
{
	private boolean state;
	private Weapon wp;
	private boolean tir=true;
	private boolean move=true;
	
	/**
	 * Constructeur des joueurs
	 * @param p point de spawn
	 */
	public Player(PointInt p) 
	{
		super(p,p,54,54,new AnimatorPlayer(p.pointValue()));
	}
	
	
	//
	// t = tableau des blocks
	public boolean jump(int[][] t) {
		// jump height = 200p;
		// jump width = 100p;
		
		PointInt posInit = this.currentPosition;
		int ligne = (this.currentPosition.getX())%60;
		int colonne = (this.currentPosition.getY())%80;
		
		if (this.currentPosition.getX() > this.previousPosition.getX()) {
			
			if ( (t[ligne][colonne+3]==1) || (t[ligne+1][colonne+3]==1) || (t[ligne-1][colonne+3]==1) || (t[ligne+2][colonne+1]==1) || (t[ligne+1][colonne+2]==1) || (t[ligne+2][colonne+3]==1) || (t[ligne+1][colonne+3]==1)) {
				return false;
			}
			
			else {
				this.move=false;
				this.tir=false;
				
				while (this.currentPosition.getX()!=posInit.getX() + 50) {
					
					if (this.currentPosition.getY() == posInit.getY() - 20) {
						this.tir=true;
					}
					
					this.currentPosition.setX(this.currentPosition.getX()+2);
					this.currentPosition.setY(this.currentPosition.getY()+4);
				}
				
				while (this.currentPosition.getY() ==posInit.getY()) {
					
					if (this.currentPosition.getY() == posInit.getY() + 180) {
						this.tir=false;
					}
					
					if (this.collideMovingEntity()) {
						//g�rer la chute ou la mort
						return false;
					}
						
					else {
						this.currentPosition.setX(this.currentPosition.getX()+2);
						this.currentPosition.setY(this.currentPosition.getY()-4);
					}
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
		else if (e==Event.PvP)
		{
			//Replacement ? g�rer avant ?
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
	
}
