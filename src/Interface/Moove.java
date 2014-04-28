package Interface;

import org.mini2Dx.core.geom.Point;


public class Moove
{

	private Point origin;
	private Point direction;
	
	public Moove()
	{
		origin = new Point();
		direction = new Point();
	}
	
	public Moove(Point origin, Point direction) {
		super();
		this.origin = origin;
		this.direction = direction;
	}

	/**
	 * Retourne vrai si le mouvement est dirigé vers la droite
	 * @return
	 */
	public boolean isRight()
	{
		return ((direction.x > origin.x) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est dirigé vers la gauche
	 * @return
	 */
	public boolean isLeft()
	{
		return ((direction.x < origin.x) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est statique (i.d. ne bouge pas)
	 * @return
	 */
	public boolean isStatic()
	{
		return ((direction.x == origin.x && direction.y == origin.y) ? true : false);
	}
	
	public Point getOrigin()
	{
		return origin;
	}
	public void setOrigin(Point origin)
	{
		this.origin = origin;
	}
	public Point getDirection()
	{
		return direction;
	}
	public void setDirection(Point direction)
	{
		this.direction = direction;
	}
	
	
	
}
