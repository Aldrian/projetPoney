package Core;


public class Collision
{
	MovingEntity e1;
	Entity e2;
	
	/**
	 * Création d'une Collision
	 * @param e1
	 * @param e2
	 */
	public Collision(MovingEntity e1,Entity e2)
	{
		this.e1=e1;
		this.e2=e2;
	}
	
	/**
	 * Fonction déterminant l'issue d'une collision 
	 * Appelle les fonctions update des entités en fonction
	 * @throws Throwable 
	 */
	public void update() throws Throwable
	{
		if (e1 instanceof Player)
		{
			if (e2 instanceof Monster)
			{				
				e1.update(Event.Death);
			}
			
			else if (e2 instanceof Player)
			{
				 e1.update(Event.Stop);
				 e2.update(Event.Stop);
			}
			else if (e2 instanceof Bomb)
			{
				e2.update(Event.Death);
			}
			else if (e2 instanceof Box)
			{
				e1.update(Event.WeaponUp);
				e2.update(Event.Death);
			}
			else if (e2 instanceof Pit)
			{
				e1.update(Event.Death);
			}
			else if (e2 instanceof Platform)
			{
				/* Tester les != cas : 
				 * Le joueur marche sur la plateforme
				 * Le joueur rentre sur le coté d'une plateforme
				 * 			Il tombe ou non ?
				*/
			}
			else if (e2 instanceof Wall)
			{
				e1.update(Event.Stop);
				
				//Tester si le joueur tombe ou non et faire un update du mouvement en fonction
			}
		}
		
		else if (e1 instanceof Monster)
		{
			if (e2 instanceof Shot)
			{
				
			}
			
			else if (e2 instanceof Pit)
			{
				e1.update(Event.Repop);
			}
			
			else if (e2 instanceof Wall)
			{
				e1.update(Event.Otherside);
			}
			
			else if (e2 instanceof Platform)
			{
				/* Tester les != cas
				* vient d'atterir ?
				* touche le coté ?
				* commence à tomber ?
				*/
			}
		}
		
		else if (e1 instanceof Shot)
		{
			//On a en e2 forcément un Wall ou une plateforme (on n'effectue pas d'autres tests)
			e1.update(Event.Death);			
		}
	}
}
