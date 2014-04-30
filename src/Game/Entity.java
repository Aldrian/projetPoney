package Game;

import org.mini2Dx.core.geom.Point;	


public abstract class Entity
{
	protected int ID;
	private static int nbC=0;//Nombre de Character instancié --> ID 
	
	// Postitionnement
	protected Hitbox hb; // Espace occupé par l'entité
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
	
	public abstract void update(Entity e); //fonction appelée en cas de collision avec une autre entitée
	
	public int getCPx()
	{
		return (int)currentPosition.x;
	}
	
	public int getCPy()
	{
		return (int)currentPosition.y;
	}
	
	public int getEdgeX()
	{
		return (int)currentPosition.x+hb.getW();
	}
	
	public int getEdgeY()
	{
		return (int)currentPosition.y+hb.getH();
	}
}
 