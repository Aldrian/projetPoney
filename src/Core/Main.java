package Core;


public class Main {

	
	/* JE LAISSE LE COMMENTAIRE EXPLICATIF MAIS C'EST DEJA FAIT
	 * Fonction update pour entity : si jamais l'objet est détruit avant que l'autre est pu update lui aussi : PROBLEM !
	 * Bien que je ne sois pas sur que cela puisse arriver
	 * 
	 * Solution proposée : 
	 * 
	 * Création d'une classe Collision qui prend les 2 Entity en paramètre et évalue ce qu'il doit être fait
	 * puis appelle les fonctions correspondante pour chaque Entity
	 * Mise en place de la fonction equals sur cette classe (et les entity aussi je pense)
	 * Pas de doublons de collisions ne seront traité
	 * 
	 * Création d'une enum Event ? définissant les différentes issues d'une collision ? (Aussi utilisable pour les pop ?)
	 * ainsi la fonction update dans entity prendrait ce type Event en param
	 * 
	 * 
	 * FUTUR MORCEAU DE CODE purement théorique pour le "Main" :
	 * 
	 *	Mode moins bourrin :
	 *	Sets : ME,NME,Player,Monster,Shot,Pit,Wall,Platform // Set E ?
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
	 *
	 *	Appeller sur player et monsters voir si certain doivent tomber.
	 */
	
	
}
