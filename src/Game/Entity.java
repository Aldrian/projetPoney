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
	

}
