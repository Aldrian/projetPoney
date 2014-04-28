package Interface;

import org.mini2Dx.core.geom.Point;


public class Move
{

	private Point origin;
	private Point direction;
	
	public Move()
	{
		origin = new Point();
		direction = new Point();
	}
	
	public Move(Point origin, Point direction) {
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
	
	public void incrementDirection(float x, float y){
		origin = new Point(direction);
		direction = new Point(direction.x + x,direction.y + y);
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
