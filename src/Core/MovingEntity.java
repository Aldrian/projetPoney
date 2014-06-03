package Core;

import Game.Move;
import Game.PointInt;

import org.mini2Dx.core.graphics.Graphics;

import Interface.Animator;

import com.badlogic.gdx.math.Vector2;

/**
 * Entit�s associ�es � une animation. Cette classe factorise Monster et Player afin de rendre plus simple l'utilisation des animations
 * 
 * @author Ga�tan
 *
 */
public abstract class MovingEntity extends Entity {
		
	protected PointInt previousPosition;
	
	/**
	 * Animation associ�e
	 */

	protected Animator animation; 
	/**
	 * Mouvement courant associ�
	 */
	protected Move mouvement;
		
	/**
	 * Constructeur ne permettant pas d'initialiser une animation
	 * Associe juste un mouvement et une position pr�c�dente
	 * Hitbox déterminée plus haut
	 * @param p
	 * @param direction
	 */
	public MovingEntity(PointInt p,PointInt direction)
	{
		super(p);
		this.previousPosition=p;
		this.mouvement=new Move(p,direction);
		this.animation=null;
	}
	
	/**
	 * Constructeur initialisant l'animation
	 * Associe à un mouvement et une position pr�c�dente
	 * @param p
	 * @param w
	 * @param h
	 * @param a
	 */
	public MovingEntity(PointInt p,PointInt direction,int w,int h, Animator a)
	{
		super(p,w,h);
		this.previousPosition=p;
		this.mouvement=new Move(p,direction);
		this.animation=a;
		animation.create();
	}
	
	
	public MovingEntity clone() {
		MovingEntity doublon = null;
		doublon = (MovingEntity) super.clone();
		return doublon;
	}
	
	/** Teste si deux entit고rentrent en collision
	 * Sup곩eur ou ꨡl /!\
	 * @param e
	 * @return Collision
	 */
	public Collision collide (Entity e)
	{		
		if(this.getCPx()>e.getEdgeX())
		{
			//System.out.println("Gauche");
			return null;	
		}
		
		if(this.getCPy()>e.getEdgeY())
		{
			//System.out.println("Bas");
			return null;	
		}
		
		if(this.getEdgeX()<e.getCPx())
		{
			//System.out.println("Droite");
			return null;	
		}
		
		if(this.getEdgeY()<e.getCPy())
		{
			//System.out.println("Haut");
			return null;
		}
		return new Collision(this,e);
	}
	
	
	/**
	 * Fonction appliquant le mouvement
	 * @param p direction du mouvement
	 */
	public void move(PointInt p) {
		// TODO Auto-generated method stub
		
	}
	
	protected boolean collideMovingEntity() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * Partie graphique
	 */
	public void setAnimation(Animator animation) {
		this.animation = animation;
	}

	/**
	 * Met � jour la direction la direction prise par l'entit�
	 * Utilise un PointInt
	 * La direction �gale � la derni�re position donnera un mouvement nul
	 * @param direction
	 */
	public void  update(PointInt direction)
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
		
		this.currentPosition.setX(this.currentPosition.getX()+direction.getX());
		this.currentPosition.setY(this.currentPosition.getY()+direction.getY());
		

	}
	
	
	/**
	 * Interpolation lin�raire de la direction du personnage : permet ainsi de calculer ses coordonn�es de rendu
	 * synchronis�es avec l'horloge du jeu
	 * @param alpha
	 */
	public void interpolate(float alpha) 
	{
		//Use the lerp (linear interpolate) method from LibGDX 
		//to interpolate between the previous and current positions
		//This will return the render coordinates

		Vector2 renderPosition = mouvement.getOrigin().pointValue().lerp(mouvement.getDirection().pointValue(), alpha);
		animation.update(renderPosition.x, renderPosition.y, mouvement);
	}
	
	/**
	 * Rendu graphique. Prend en param�tre le graphic.
	 * @param g
	 */
	public void render(Graphics g) 
	{
		animation.render();
	}
 
}

