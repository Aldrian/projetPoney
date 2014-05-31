package Core;

import Game.PointInt;


public class Player extends MovingEntity
{
	private boolean state;
	private Weapon wp;
	
	
	//
	// t = tableau des blocks
	private boolean jump(int[][] t) {
		// jump height = 200p;
		// jump width = 100p;
		
		PointInt posInit = this.currentPosition;
		int ligne = (this.currentPosition.getX())%60;
		int colonne = (this.currentPosition.getY())%80;
		
		if ( (t[ligne+1][colonne]==1) || (t[ligne+2][colonne]==1) || (t[ligne+1][colonne+1]==1) || (t[ligne+2][colonne+1]==1) || (t[ligne+1][colonne+2]==1) || (t[ligne+2][colonne+3]==1) || (t[ligne+1][colonne+3]==1)) {
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
					//gérer la chute ou la mort
					return false;
				}
					
				else {
					this.currentPosition.setX(this.currentPosition.getX()+2);
					this.currentPosition.setY(this.currentPosition.getY()-4);
				}
			}
			this.move=true;
			
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
