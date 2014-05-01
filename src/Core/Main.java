package Core;

import java.util.Set;

public class Main {

	
	/* JE LAISSE LE COMMENTAIRE EXPLICATIF MAIS C'EST DEJA FAIT
	 * Fonction update pour entity : si jamais l'objet est d�truit avant que l'autre est pu update lui aussi : PROBLEM !
	 * Bien que je ne sois pas sur que cela puisse arriv�
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
	 * FUTUR MORCEAU DE CODE purement th�orique pour le Main :
	 * 
	 * Set<Entities> entities
	 * for each tick d'horloge
	 * {
	 *		Set<Collision> colls;
	 *
	 *		for (Entity e1:entities)
	 *		{
	 *			for(Entity e2:entities)
	 *			{
	 *				if(!(e1.equals(e2))&&e1.collide(e2))	 
	 *					colls.add(new Collision(e1, e2));
	 *	 		}
	 *		}
	 *		(... ?) //pops and everything
	 *		for (Collision c:colls)
	 *		{
	 *			c.update();
	 *		}
	 *		//check si game over ?
	 *	}
	 */
	
	
}
