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
	

}
