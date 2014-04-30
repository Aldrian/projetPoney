package Game;

import org.mini2Dx.core.geom.Point;	


public abstract class Entity
{
	protected int ID;
	private static int nbC=0;//Nombre de Character instancié --> ID 
	
	// Postitionnement
	
	protected int width;
	protected int height;
	protected Point previousPosition; // Position précédente
    protected Point currentPosition; // Position actuelle
	
	public Entity()
	{
		ID=nbC++;
	}
	
	
	/** Teste si deux entitées rentre en collision et appelle update() le cas échéant
	 * 
	 * @param e
	 */
	public void collide (Entity e)
	{
		if(this.getEdgeX()>=e.getCPx()||this.getEdgeY()>=e.getCPy()||e.getEdgeX()>=this.getCPx()||e.getEdgeY()>=this.getCPy())
			this.update(e);		
	}
	/** Fonction appelée en cas de collision avec une autre entitée
	 * 
	 * @param e
	 */
	public abstract void update(Entity e);
	
	/**  
	 * @return x l'abscisse de la position actuelle
	 */
	public int getCPx()
	{
		return (int)currentPosition.x;
	}
	
	/**  
	 * @return y l'ordonnée de la position actuelle
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
	 * @return y l'ordonnée du bord haut de la hitbox
	 */
	public int getEdgeY()
	{
		return (int)currentPosition.y+height;
	}
}
 