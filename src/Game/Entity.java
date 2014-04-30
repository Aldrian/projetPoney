package Game;

import org.mini2Dx.core.geom.Point;	


public abstract class Entity
{
	protected int ID;
	private static int nbC=0;//Nombre de Character instanci� --> ID 
	
	// Postitionnement
	protected Hitbox hb; // Espace occup� par l'entit�
	protected Point previousPosition; // Position pr�c�dente
    protected Point currentPosition; // Position actuelle
	
	public Entity()
	{
		ID=nbC++;
	}
	
	/** Teste si deux entit�es rentre en collision et appelle update() le cas �ch�ant
	 * 
	 * @param e
	 */
	public void collide (Entity e)
	{
		if(this.getEdgeX()>=e.getCPx()||this.getEdgeY()>=e.getCPy()||e.getEdgeX()>=this.getCPx()||e.getEdgeY()>=this.getCPy())
			this.update(e);		
	}
	
	public abstract void update(Entity e); //fonction appel�e en cas de collision avec une autre entit�e
	
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
 