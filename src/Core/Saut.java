package Core;

import Game.PointInt;

public class Saut {
	
	private Player joueur;
	
	public Saut(Player player) {
		this.joueur=player;
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
		
		/*PointInt posInit = this.joueur.currentPosition;
		Player p = (Player) this.clone();
		
		
		if (this.joueur.droite==true) {
			
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
	
	public void jump(PointInt mouvement) {
		// jump height = 200p;
		// jump width = 100p;
		
		PointInt posInit = this.joueur.currentPosition;
		this.joueur.saut=true;
		System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
		
		if (this.canJump()) {
			
			if (this.joueur.droite) {
				System.out.println("Saut à droite en cours");
				this.joueur.move=false;
				this.joueur.tir=false;
				
				for (int i = 0; i<50;i++) {
					if(i<25) {
						if (this.joueur.currentPosition.getY() == posInit.getY() + 180) {
							this.joueur.tir=true;
						}
						
						mouvement.set(2,8);
						this.joueur.update(mouvement);
						System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
					}
					
					else {
						if (this.joueur.currentPosition.getY() == posInit.getY() + 180) {
							this.joueur.tir=false;
						}
						mouvement.set(2,-8);
						this.joueur.update(mouvement);
						System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
					}
				}	
			}
			
			else {
				System.out.println("Saut à gauche en cours");
				System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
				this.joueur.move=false;
				this.joueur.tir=false;
				
				for (int i = 0; i<50;i++) {
					if(i<25) {
						if (this.joueur.currentPosition.getY() == posInit.getY() + 180) {
							this.joueur.tir=true;
						}
						mouvement.set(-2,8);
						this.joueur.update(mouvement);
						System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
					}
					
					else {
						if (this.joueur.currentPosition.getY() == posInit.getY() + 180) {
							this.joueur.tir=false;
						}
						mouvement.set(-2,-8);
						this.joueur.update(mouvement);
						System.out.println("currentPos" + this.joueur.currentPosition.getX() + "  /  " + this.joueur.currentPosition.getY());
					}
				}	
			}
		}
		this.joueur.move=true;
		this.joueur.saut=false;
	}


}
