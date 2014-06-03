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
		//System.out.println(toString());
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
				//Collision entre le bas de e1 et le haut de e2
				if(e1.getCPy()<=e2.getEdgeY())
				{
					if(e1.previousPosition.getY()>e1.getCPy()) // le joueur était dans les airs avant
					{
						//System.out.println("LAND");
						e1.update(Event.Land);
					}
					//System.out.println("plateforme touch");
					((Player) e1).setAir(false);
				}
				
				//Gauche ou droite
				else if (e1.getCPx()==e2.getEdgeX() || e1.getEdgeX()==e2.getCPx())
				{
					 e1.update(Event.Stop);
				}
			}
			else if (e2 instanceof Wall)
			{
				e1.update(Event.Stop);
			}
		}
		
		else if (e1 instanceof Monster)
		{
			if (e2 instanceof Shot)
			{
				e1.update(Event.HealthMinus);
				e2.update(Event.HealthMinus);
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
				//Collision entre le bas de e1 et le haut de e2
				if(e1.getCPy()==e2.getEdgeY())
				{
					if(e1.previousPosition.getY()>e1.getCPy()) // le monstre était dans les airs avant
					{
						e1.update(Event.Land);
					}
					((Monster) e1).setAir(false);
				}
				
				//Gauche ou droite
				else if (e1.getCPx()==e2.getEdgeX() || e1.getEdgeX()==e2.getCPx())
				{
					 e1.update(Event.Stop);
				}
			}
		}
		
		else if (e1 instanceof Shot)
		{
			//On a en e2 forcément un Wall ou une plateforme (on n'effectue pas d'autres tests)
			e1.update(Event.Death);			
		}
	}

	@Override
	public String toString() {
		return "=========================Collision====================================\nEntity1(ID="+e1.ID+" Class="+e1.getClass().getName() +": CPX,CPy,EdgeX,EdgeY      "+e1.getCPx()+","+e1.getCPy()+","+e1.getEdgeX()+","+e1.getEdgeY()+"\nEntity2(ID="+e2.ID+" Class="+e2.getClass().getName() +": CPX,CPy,EdgeX,EdgeY      "+e2.getCPx()+","+e2.getCPy()+","+e2.getEdgeX()+","+e2.getEdgeY()+"\n";
	}
	
	
}
