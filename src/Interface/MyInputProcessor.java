package Interface;

import Core.Player;
import Core.Saut;
import Game.PointInt;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Classe de gestion des entrées claviers
 * Est associé à deux joueurs
 * Chacune des directions correspondent à un des joueurs
 * @author Gaëtan
 *
 */
public class MyInputProcessor implements InputProcessor 
{
	private Player P1; // Joueur associé
	private Player P2; // Joueur associé
	private PointInt directionP1; // directionP1 donné au Joueur
	private PointInt directionP2; // directionP1 donné au Joueur

	/**
	 * Constructeur par paramètres
	 * @param p
	 */
	public MyInputProcessor(Player p1, Player p2)
	{
		this.P1 = p1;
		this.P2 = p2;
		directionP1 = new PointInt();
		directionP2 = new PointInt();
	}
	
	/**
	 * Méthode appelée dans la boucle principale du jeu.
	 * De cette façon les joueurs sont mis à jour constamment par la direction qui lui est associée dans cette classe
	 */
	public void keyboardProcessing(){
		
		if (!P1.saut) {
			P1.update(directionP1);
		}
<<<<<<< HEAD
		else P1.update(P1.jump());
		if (!P2.saut) {
			P2.update(directionP2);
		}
		else P2.update(P2.jump());
=======
		if (!P2.saut) {
			P2.update(directionP2);
		}
>>>>>>> 364aebb39ff195ed1fe19b2ed380d5d62038a4c1
		
	}
	
	/**
	 * Méthode des entrées appuis clavier.
	 * A chaque appuie sur une touche, cette méthode est appelée avec comme argument l'entier correspondant à la touche appuyée
	 */
	@Override
	public boolean keyDown(int key) 
	{
		
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("Déplacement à droite demandé");
			directionP1.set(2,0);
			
		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche demandé");
			directionP1.set(-2,0);
			
		break;
		
		/*case Keys.UP :
			System.out.println("Saut demandé");
			if(P1.saut==false) P1.jump(directionP1);
			
		break;*/
		case Keys.D :
			System.out.println("Déplacement à droite demandé");
			directionP2.set(2,0);
			
		break;
		case Keys.Q : 
			System.out.println("Déplacement à gauche demandé");
			directionP2.set(-2,0);
			
		break;
		/*case Keys.Z :
			System.out.println("Saut demandé");
			if(P1.saut==false) P2.jump(directionP2);
			
		break;*/
		}
		return true;
	}
	
	/**
	 * Méthode des entrées retours clavier.
	 * A chaque relachement d'une touche, cette méthode est appelée avec comme argument l'entier correspondant à la touche relâchée
	 */
	@Override
	public boolean keyUp(int key) {
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("Déplacement à droite arrêté");
			directionP1.set(0,0);
			P1.droite=true;
			
		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche arrêté");
			directionP1.set(0,0);
			P1.droite=false;
		break;
		/*case Keys.UP :
			System.out.println("Saut terminé");
			if(P1.saut==true) directionP1.set(0,0);
			P1.saut=false;
		break;*/
		case Keys.D :
			System.out.println("Déplacement à droite arrêté");
			directionP2.set(0,0);
			P2.droite=true;
		break;
		case Keys.Q : 
			System.out.println("Déplacement à gauche arrêté");
			directionP2.set(0,0);
			P2.droite=false;
		break;
		/*case Keys.Z :
			System.out.println("Saut demandé");
			if(P1.saut==true) directionP2.set(0,0);
			P2.saut=false;
			
		break;*/
		}
		return true;
	}


	@Override
	public boolean keyTyped(char arg0) {
		switch(arg0)
		{
		case 'z' :
			System.out.println("Saut demandé");
<<<<<<< HEAD
			P2.saut=true;
=======
			if(P2.saut==false)   {
				Saut sautP2 = new Saut(P2);
				sautP2.jump(directionP2);
			}
			directionP2.set(0, 0);
			P2.saut=false;
>>>>>>> 364aebb39ff195ed1fe19b2ed380d5d62038a4c1
			System.out.println("Saut terminé");
		break;
		
		case 38 /*LE PUTAIN DE CHAR CORRESPONDANT A LA TOUCHE ARROW UP*/:
			System.out.println("Saut demandé");
			if(P1.saut==false)   {
				Saut sautP1 = new Saut(P1);
				sautP1.jump(directionP1);
			}
			directionP1.set(0, 0);
			P1.saut=false;
			System.out.println("Saut terminé");
		break;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}