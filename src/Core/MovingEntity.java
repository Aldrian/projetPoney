package Core;

import Game.Move;
import Game.PointInt;
import org.mini2Dx.core.graphics.Graphics;
import Interface.Animator;
import com.badlogic.gdx.math.Vector2;

/**
 * Entités associées à une animation. Cette classe factorise Monster et Player afin de rendre plus simple l'utilisation des animations
 * 
 * @author Gaëtan
 *
 */
public abstract class MovingEntity extends Entity {
		
	protected PointInt previousPosition;
	/**
	 * Animation associée
	 */

	protected Animator animation; 
	/**
	 * Mouvement courant associé
	 */
	protected Move mouvement;
	
	/**
	 * Constructeur ne permettant pas d'initialiser une animation
	 * Associe juste un mouveent et une position précédente
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
	 * Associe un mouvement et une position précédente
	 * @param p
	 * @param w
	 * @param h
	 * @param a
	 */
	public MovingEntity(PointInt p,int w,int h, Animator a)
	{
		super(p,w,h);
		this.previousPosition=p;
		this.mouvement=new Move(p,p);
		this.animation=a;
		animation.create();
	}
	
	/**
	 * Fonction appliquant le mouvement
	 * @param p direction du mouvement
	 */
	public void move(PointInt p) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * Partie graphique
	 */
	public void setAnimation(Animator animation) {
		this.animation = animation;
	}

	/**
	 * Met à jour la direction la direction prise par l'entité
	 * Utilise un PointInt
	 * La direction égale à la dernière position donnera un mouvement nul
	 * @param direction
	 */
	public void  update(PointInt direction)
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
	}
	
	
	/**
	 * Interpolation linéraire de la direction du personnage : permet ainsi de calculer ses coordonnées de rendu
	 * synchronisées avec l'horloge du jeu
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
	 * Rendu graphique. Prend en paramètre le graphic.
	 * @param g
	 */
	public void render(Graphics g) 
	{
		animation.render();
	}
 
}

