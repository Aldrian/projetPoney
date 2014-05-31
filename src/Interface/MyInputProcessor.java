package Interface;

import Game.Player;
import Game.PointInt;
import Game.SmallEnnemy;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Gestion du clavier associé à un joueur
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
	 * Constructeur principal prenant en paramètre le joueur associé
	 * @param p
	 */
	public MyInputProcessor(Player p1, Player p2)
	{
		this.P1 = p1;
		this.P2 = p2;
		directionP1 = new PointInt();
		directionP2 = new PointInt();
	}
	
	public void keyboardProcessing(){
		P1.update(directionP1);
		P2.update(directionP2);
	}
	
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
		case Keys.D :
			System.out.println("Déplacement à droite demandé");
			directionP2.set(2,0);
			
		break;
		case Keys.Q : 
			System.out.println("Déplacement à gauche demandé");
			directionP2.set(-2,0);
			
		break;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int key) {
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("Déplacement à droite arrêté");
			directionP1.set(0,0);

		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche arrêté");
			directionP1.set(0,0);
		break;
		case Keys.D :
			System.out.println("Déplacement à droite arrêté");
			directionP2.set(0,0);
		break;
		case Keys.Q : 
			System.out.println("Déplacement à gauche arrêté");
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