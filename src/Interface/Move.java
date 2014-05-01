package Interface;

import org.mini2Dx.core.geom.Point;
import java.lang.Math;
/**
 * Représente un mouvement quelconque
 * Attention : Toutes les entrées de coordonnées doivent être contrôlées afin que ses coordonnées gardent une précision inférieure à 2 décimale
 * Passer outre entraîne des bugs d'affichage
 * @author Gaëtan
 *
 */
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
	
	/**
	 * Incrémente : met la direction en origine et ajoute une nouvelle direction
	 * @param x
	 * @param y
	 */
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
	
	/**
	 * Aroundi les coordonnées du point à 2 décimales
	 * @param a
	 * @return Point
	 */
	public static void round(Point a)
	{
		float x = a.getX();
		float y = a.getY();
		
		x = x - x %10;
		
		y = y - y %10;
		
		a.set(x, y);
	}
	
	@Override
	public String toString() {
		return "Move [origin=" + origin.toString() + ", direction=" + direction.toString() + "]";
	}
	
}
