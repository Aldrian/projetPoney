package Core;

import Game.Move;
import Game.PointInt;

import org.mini2Dx.core.graphics.Graphics;

import Interface.Animator;

import com.badlogic.gdx.math.Vector2;

/**
 * Entitï¿½s associï¿½es ï¿½ une animation. Cette classe factorise Monster et Player afin de rendre plus simple l'utilisation des animations
 * 
 * @author Gaï¿½tan
 *
 */
public abstract class MovingEntity extends Entity {
		
	protected PointInt previousPosition;
	
	/**
	 * Animation associï¿½e
	 */

	protected Animator animation; 
	/**
	 * Mouvement courant associï¿½
	 */
	protected Move mouvement;
		
	/**
	 * Constructeur ne permettant pas d'initialiser une animation
	 * Associe juste un mouvement et une position prï¿½cï¿½dente
	 * Hitbox dÃ©terminÃ©e plus haut
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
	 * Associe Ã  un mouvement et une position prï¿½cï¿½dente
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
	
	/** Teste si deux entités rentrent en collision
	 * Supérieur ou égal /!\
	 * @param e
	 * @return Collision
	 */
	public Collision collide (Entity e)
	{
		if(this.getEdgeX()>=e.getCPx()||this.getEdgeY()>=e.getCPy()||e.getEdgeX()>=this.getCPx()||e.getEdgeY()>=this.getCPy())
			return new Collision(this,e);
		return null;		
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
	 * Met ï¿½ jour la direction la direction prise par l'entitï¿½
	 * Utilise un PointInt
	 * La direction ï¿½gale ï¿½ la derniï¿½re position donnera un mouvement nul
	 * @param direction
	 */
	public void  update(PointInt direction)
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
	}
	
	
	/**
	 * Interpolation linï¿½raire de la direction du personnage : permet ainsi de calculer ses coordonnï¿½es de rendu
	 * synchronisï¿½es avec l'horloge du jeu
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
	 * Rendu graphique. Prend en paramï¿½tre le graphic.
	 * @param g
	 */
	public void render(Graphics g) 
	{
		animation.render();
	}
 
}

