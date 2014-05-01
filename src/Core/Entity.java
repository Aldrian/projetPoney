package Core;

import org.mini2Dx.core.geom.Point;	


public abstract class Entity
{
	protected int ID;
	private static int nbC=0;//Nombre de Character instanci� --> ID 
	
	// Postitionnement
	
	protected int width;
	protected int height;
	protected Point previousPosition; // Position pr�c�dente
    protected Point currentPosition; // Position actuelle
	
	public Entity()
	{
		ID=nbC++;
	}
	
	
	/** Teste si deux entit�s rentrent en collision et appelle update() le cas �ch�ant
	 * 
	 * @param e
	 * @return 
	 */
	public Collision collide (Entity e)
	{
		if(this.getEdgeX()>=e.getCPx()||this.getEdgeY()>=e.getCPy()||e.getEdgeX()>=this.getCPx()||e.getEdgeY()>=this.getCPy())
			return new Collision(this,e);
		return null;		
	}
	
	/** Fonction appel�e en cas de collision avec une autre entit�
	 * 
	 * @param e
	 * @throws Throwable 
	 */
	public abstract void update(Event e) throws Throwable;
	
	/**  
	 * @return x l'abscisse de la position actuelle
	 */
	
	public abstract Entity  move(Point p);
	
	public abstract boolean moveAllowed(Point p);
	
	public int getCPx()
	{
		return (int)currentPosition.x;
	}
	
	/**  
	 * @return y l'ordonn�e de la position actuelle
	 */
	public int getCPy()
	{
		return (int)currentPosition.y;
	}
	
	/**  
	 * @return x l'abscisse du bord droit de la hitbox
	 */
	public int getEdgeX()
	{
		return (int)currentPosition.x+width;
	}
	
	/** 
	 * @return y l'ordonn�e du bord haut de la hitbox
	 */
	public int getEdgeY()
	{
		return (int)currentPosition.y+height;
	}
}
 