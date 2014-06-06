package Game;


/**
 * Repr�sente un mouvement quelconque.
 * Comporte un point d'origine et un point d'arriv�e.
 * Des m�thodes permettent de conna�tre la nature du mouvement, ou savoir si celui-ci est statique.
 * Conversion en Point version LibGDX.
 * @author Ga�tan
 *
 */
public class Move
{

	private PointInt origin;
	private PointInt direction;
	
	/**
	 * Constructeur par d�faut
	 */
	public Move()
	{
		origin = new PointInt();
		direction = new PointInt();
		
	}
	
	/**
	 * Constructeur par param�tres
	 * @param point d'origine
	 * @param point donnant la direction
	 */
	public Move(PointInt origin, PointInt direction) {
		super();
		this.origin = origin;
		this.direction = direction;
	}

	/**
	 * Retourne vrai si le mouvement est dirig� vers la droite
	 * @return vrai si le mouvement est dirig� vers la droite
	 */
	public boolean isRight()
	{
		return ((direction.getX() > origin.getX()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est dirig� vers la gauche
	 * @return vrai si le mouvement est dirig� vers la gauche
	 */
	public boolean isLeft()
	{
		return ((direction.getX() < origin.getX()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est statique (i.d. ne bouge pas)
	 * @return vrai si le mouvement est statique (i.d. ne bouge pas)
	 */
	public boolean isStatic()
	{
		return ((direction.getX() == origin.getX() && direction.getY() == origin.getY()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est un saut (i.d. dirig� vers le haut)
	 * @return vrai si le mouvement est un saut (i.d. dirig� vers le haut)
	 */
	public boolean isJump()
	{
		return ((direction.getY() > origin.getY()) ? true : false);
	}
	
	/**
	 * Retourne vrai si le mouvement est une chute (i.d. dirig� vers le bas)
	 * @return vrai si le mouvement est une chute (i.d. dirig� vers le bas)
	 */
	public boolean isFall()
	{
		return ((direction.getY() < origin.getY()) ? true : false);
	}
	
	/**
	 * Incr�mente : met la direction en origine et ajoute une nouvelle direction
	 * @param coordonn�e x de la nouvelle direction
	 * @param coordonn�e y de la nouvelle direction
	 */
	public void incrementDirection(int x, int y){
		origin = new PointInt(direction);
		direction = new PointInt(direction.getX() + x,direction.getY() + y);

	}
	
	/**
	 * Donne l'origine
	 * @return l'origine
	 */
	public PointInt getOrigin()
	{
		return origin;
	}
	
	/**
	 * Modifie l'origine
	 * @param origin
	 */
	public void setOrigin(PointInt origin)
	{
		this.origin = origin;
	}
	
	/**
	 * Donne la direction
	 * @return direction
	 */
	public PointInt getDirection()
	{
		return direction;
	}
	
	/**
	 * Modifie la direction
	 * @param direction
	 */
	public void setDirection(PointInt direction)
	{
		this.direction = direction;
	}
	
	/**
	 * ToString() auto-g�n�r�
	 */
	@Override
	public String toString() {
		return "Move [origin=" + origin.toString() + ", direction=" + direction.toString() + "]";
	}
}