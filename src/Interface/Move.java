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

	private PointRender origin;
	private PointRender direction;
	
	public Move()
	{
		origin = new PointRender();
		direction = new PointRender();
		
	}
	
	public Move(PointRender origin, PointRender direction) {
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
		return ((direction.getX() > origin.getX()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est dirigé vers la gauche
	 * @return
	 */
	public boolean isLeft()
	{
		return ((direction.getX() < origin.getX()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est statique (i.d. ne bouge pas)
	 * @return
	 */
	public boolean isStatic()
	{
		return ((direction.getX() == origin.getX() && direction.getY() == origin.getY()) ? true : false);
	}
	
	/**
	 * Incrémente : met la direction en origine et ajoute une nouvelle direction
	 * @param x
	 * @param y
	 */
	public void incrementDirection(int x, int y){
		origin = new PointRender(direction);
		direction = new PointRender(direction.getX() + x,direction.getY() + y);

	}
	
	public PointRender getOrigin()
	{
		return origin;
	}
	public void setOrigin(PointRender origin)
	{
		this.origin = origin;
	}
	public PointRender getDirection()
	{
		return direction;
	}
	public void setDirection(PointRender direction)
	{
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "Move [origin=" + origin.toString() + ", direction=" + direction.toString() + "]";
	}
	
}
