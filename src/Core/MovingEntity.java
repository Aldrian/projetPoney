package Core;

import Game.Move;
import Game.PointInt;
import org.mini2Dx.core.graphics.Graphics;
import Interface.Animator;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity extends Entity {
		
	protected PointInt previousPosition; // Position pr�c�dente
	
	protected Animator animation; // Animation associ�e
	protected Move mouvement; // Mouvement courant du personnage
	
	
	// Constructeur ne d�finissant pas l'animation ni la taille de l'entit� de suite
	public MovingEntity(PointInt p,PointInt direction)
	{
		super(p);
		this.previousPosition=p;
		this.mouvement=new Move(p,direction);
		this.animation=null;
	}
	
	// Constructeur d'une entit� statique � sa cr�ation
	public MovingEntity(PointInt p,int w,int h, Animator a)
	{
		super(p,w,h);
		this.previousPosition=p;
		this.mouvement=new Move(p,p);
		this.animation=a;
		animation.create();
	}
	public void move(PointInt p) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * Partie graphique
	 */	


	public void setAnimation(Animator animation) {
		this.animation = animation;
	}

	public void  update(PointInt direction)
	{
		mouvement.incrementDirection(direction.getX(), direction.getY());
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
