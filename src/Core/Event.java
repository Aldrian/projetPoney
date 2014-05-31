package Core;

public enum Event {
	Death, //Mort de l'entity
	HealthMinus, //Retrait d'un PV
	WeaponUp, // On prend le laser
	Repop, // Repop d'un monstre ayant atteint le Pit
	Otherside, //Replace un monstre lorsqu'il traverse le mur
	Stop; //Arrêt du mouvement de l'entité
	

}
