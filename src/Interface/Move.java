package Interface;

/**
 * Repr�sente un mouvement quelconque
 * Attention : Toutes les entr�es de coordonn�es doivent �tre contr�l�es afin que ses coordonn�es gardent une pr�cision inf�rieure � 2 d�cimale
 * Passer outre entra�ne des bugs d'affichage
 * @author Ga�tan
 *
 */
public class Move
{

	private PointInt origin;
	private PointInt direction;
	
	public Move()
	{
		origin = new PointInt();
		direction = new PointInt();
		
	}
	
	public Move(PointInt origin, PointInt direction) {
		super();
		this.origin = origin;
		this.direction = direction;
	}

	/**
	 * Retourne vrai si le mouvement est dirig� vers la droite
	 * @return
	 */
	public boolean isRight()
	{
		return ((direction.getX() > origin.getX()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est dirig� vers la gauche
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
	 * Retourne vrai si le mouvement est un saut (i.d. dirig� vers le haut)
	 * @return
	 */
	public boolean isJump()
	{
		return ((direction.getY() > origin.getY()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est une chute (i.d. dirig� vers le bas)
	 * @return
	 */
	public boolean isFall()
	{
		return ((direction.getY() < origin.getY()) ? true : false);
	}
	
	/**
	 * Incr�mente : met la direction en origine et ajoute une nouvelle direction
	 * @param x
	 * @param y
	 */
	public void incrementDirection(int x, int y){
		origin = new PointInt(direction);
		direction = new PointInt(direction.getX() + x,direction.getY() + y);

	}
	
	public PointInt getOrigin()
	{
		return origin;
	}
	public void setOrigin(PointInt origin)
	{
		this.origin = origin;
	}
	public PointInt getDirection()
	{
		return direction;
	}
	public void setDirection(PointInt direction)
	{
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "Move [origin=" + origin.toString() + ", direction=" + direction.toString() + "]";
	}
	
}
