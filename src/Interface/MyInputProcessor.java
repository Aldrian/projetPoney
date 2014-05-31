package Interface;

import Core.Player;
import Game.PointInt;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Classe de gestion des entr�es claviers
 * Est associ� � deux joueurs
 * Chacune des directions correspondent � un des joueurs
 * @author Ga�tan
 *
 */
public class MyInputProcessor implements InputProcessor 
{
	private Player P1; // Joueur associ�
	private Player P2; // Joueur associ�
	private PointInt directionP1; // directionP1 donn� au Joueur
	private PointInt directionP2; // directionP1 donn� au Joueur

	/**
	 * Constructeur par param�tres
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
	 * M�thode appel�e dans la boucle principale du jeu.
	 * De cette fa�on les joueurs sont mis � jour constamment par la direction qui lui est associ�e dans cette classe
	 */
	public void keyboardProcessing(){
		P1.update(directionP1);
		P2.update(directionP2);
	}
	
	/**
	 * M�thode des entr�es appuis clavier.
	 * A chaque appuie sur une touche, cette m�thode est appel�e avec comme argument l'entier correspondant � la touche appuy�e
	 */
	@Override
	public boolean keyDown(int key) 
	{
		
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("D�placement � droite demand�");
			directionP1.set(2,0);
			
		break;
		case Keys.LEFT : 
			System.out.println("D�placement � gauche demand�");
			directionP1.set(-2,0);
			
		break;
		
		case Keys.UP :
			System.out.println("Saut demand�");
			P1.jump();
			
		break;
		case Keys.D :
			System.out.println("D�placement � droite demand�");
			directionP2.set(2,0);
			
		break;
		case Keys.Q : 
			System.out.println("D�placement � gauche demand�");
			directionP2.set(-2,0);
			
		break;
		case Keys.Z :
			System.out.println("Saut demand�");
			P2.jump();
			
		break;
		}
		return true;
	}
	
	/**
	 * M�thode des entr�es retours clavier.
	 * A chaque relachement d'une touche, cette m�thode est appel�e avec comme argument l'entier correspondant � la touche rel�ch�e
	 */
	@Override
	public boolean keyUp(int key) {
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("D�placement � droite arr�t�");
			directionP1.set(0,0);
		break;
		case Keys.LEFT : 
			System.out.println("D�placement � gauche arr�t�");
			directionP1.set(0,0);
		break;
		case Keys.UP :
			System.out.println("Saut termin�");
			directionP1.set(0,0);
		break;
		case Keys.D :
			System.out.println("D�placement � droite arr�t�");
			directionP2.set(0,0);
		break;
		case Keys.Q : 
			System.out.println("D�placement � gauche arr�t�");
			directionP2.set(0,0);
		break;
		case Keys.Z :
			System.out.println("Saut termin�");
			directionP2.set(0,0);
		break;
		}
		return true;
	}


	@Override
	public boolean keyTyped(char arg0) {
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