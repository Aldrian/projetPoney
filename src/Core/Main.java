package Core;


public class Main {

	
	/* JE LAISSE LE COMMENTAIRE EXPLICATIF MAIS C'EST DEJA FAIT
	 * Fonction update pour entity : si jamais l'objet est d�truit avant que l'autre est pu update lui aussi : PROBLEM !
	 * Bien que je ne sois pas sur que cela puisse arriver
	 * 
	 * Solution propos�e : 
	 * 
	 * Cr�ation d'une classe Collision qui prend les 2 Entity en param�tre et �value ce qu'il doit �tre fait
	 * puis appelle les fonctions correspondante pour chaque Entity
	 * Mise en place de la fonction equals sur cette classe (et les entity aussi je pense)
	 * Pas de doublons de collisions ne seront trait�
	 * 
	 * Cr�ation d'une enum Event ? d�finissant les diff�rentes issues d'une collision ? (Aussi utilisable pour les pop ?)
	 * ainsi la fonction update dans entity prendrait ce type Event en param
	 * 
	 * 
	 * FUTUR MORCEAU DE CODE purement th�orique pour le "Main" :
	 * 
	 * Mode bourrin :
	 * List<Entity> entities
	 * List<MovingEntity> Mentities;
	 * List<NotMovingEntity> NMentities;
	 * for each tick d'horloge
	 * {
	 *		Set<Collision> colls;
	 *		
	 *      ME vs ME
	 *		for (int i=0;i<Mentities.size();i++)
	 *		{
	 *			for(int j=i+1;j<Mentities.size();j++)
	 *			{
	 *				if(Mentities.get(i).collide(Mentities.get(j)))	 
	 *					colls.add(new Collision(Mentities.get(i),Mentities.get(j)));
	 *	 		} 
	 *		}
	 *
	 *		REPEAT ME vs NME
	 *		for ...
	 *
	 *		
	 *
	 *		(... ?) //pops and everything
	 *		for (Collision c:colls)
	 *		{
	 *			c.update();
	 *		}
	 *		//check si game over ?
	 *	}
	 *
	 *	Mode moins bourrin :
	 *	Lists : ME,NME,Player,Monster,Shot,Pit,Wall,Platform // List E ?
	 *
	 *	for ME
	 *		if Player
	 *			NME
	 *			Monster
	 *			Player
	 *		else if Monster
	 *			Shot
	 *			Pit
	 *			Wall
	 *			Platform
	 *		else if Shot
	 *			Wall
	 *			Platform
	 */
	
	
}
