package Core;


public class Collision
{
	Entity e1;
	Entity e2;
	
	/**
	 * Création d'une Collision
	 * @param e1
	 * @param e2
	 */
	public Collision(Entity e1,Entity e2)
	{
		this.e1=e1;
		this.e2=e2;
	}
	
	/**
	 * Fonction déterminant l'issue d'une collision 
	 * Appelle les fonctions update des entités en fonction
	 */
	public void update()
	{
		if (e1 instanceof Player)
		{
			if (e2 instanceof Monster)
			{
				try {
					e1.update(Event.Death);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (e2 instanceof Bomb)
			{
				try {
					e2.update(Event.Death);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (e2 instanceof Box)
			{
				try{
					e1.update(Event.WeaponUp);
				}catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
					e2.update(Event.Death);
				}catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (e2 instanceof Player)//A traiter ici ? Arreter le mouvement des deux joueurs dans la direction
			{
				
			}
		}
		else if ((e1 instanceof Monster && e2 instanceof Shot) || (e2 instanceof Monster && e1 instanceof Shot))
		{
			if (e2 instanceof Monster)
			{
				Entity tmp=e2;
				e2=e1;
				e1=tmp;
			}
			
			try {
				e1.update(Event.HealthMinus);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				e2.update(Event.Death);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (e1 instanceof Bomb && e2 instanceof Player)
		{
				try {
					e1.update(Event.Death);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
