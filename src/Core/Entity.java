package Core;

import Game.PointInt;	


public abstract class Entity
{
	protected int ID;
	private static int nbE=0;//Nombre d'Entity instanci�es --> ID 
	
	// Postitionnement
	
	protected int width;
	protected int height;
	
    protected PointInt currentPosition; // Position actuelle
	
	public Entity(PointInt p)
	{
		ID=nbE++;
		this.currentPosition=p;
	}
	
	public Entity(PointInt p,int w, int h)
	{
		this(p);
		width=w;
		height=h;
	}
	
	
	
	public int getWidth() {
		return width;
	}




	public void setWidth(int width) {
		this.width = width;
	}




	public int getHeight() {
		return height;
	}




	public void setHeight(int height) {
		this.height = height;
	}




	/** Teste si deux entit�s rentrent en collision et appelle update() le cas �ch�ant
	 * 
	 * @param e
	 * @return Collision
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
		
	public int getCPx()
	{
		return currentPosition.getX();
	}
	
	/**  
	 * @return y l'ordonn�e de la position actuelle
	 */
	public int getCPy()
	{
		return (int)currentPosition.getY();
	}
	
	/**  
	 * @return x l'abscisse du bord droit de la hitbox
	 */
	public int getEdgeX()
	{
		return (int)currentPosition.getX()+width;
	}
	
	/** 
	 * @return y l'ordonn�e du bord haut de la hitbox
	 */
	public int getEdgeY()
	{
		return (int)currentPosition.getY()+height;
	}


	@Override
	public int hashCode() {
		return ID;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	
	
}
 