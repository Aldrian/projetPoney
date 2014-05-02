package Interface;


import org.mini2Dx.core.geom.Point;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Gestion du clavier associé à un joueur
 * @author Gaëtan
 *
 */
public class MyInputProcessor implements InputProcessor 
{
	
	private Player P; // Joueur associé
	private PointRender direction; // Direction donné au Joueur
	
	
	/**
	 * Constructeur principal prenant en paramètre le joueur associé
	 * @param p
	 */
	public MyInputProcessor(Player p)
	{
		this.P = p;
		direction = new PointRender();
	}
	
	public void keyboardProcessing(){
		P.update(direction);
	}
	
	@Override
	public boolean keyDown(int key) 
	{
		
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("Déplacement à droite demandé");
			direction.set(2,0);
			
		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche demandé");
			direction.set(-2,0);
			
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
			direction.set(0,0);
		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche arrêté");
			direction.set(0,0);
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