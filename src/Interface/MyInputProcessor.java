package Interface;


import org.mini2Dx.core.geom.Point;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Gestion du clavier associ� � un joueur
 * @author Ga�tan
 *
 */
public class MyInputProcessor implements InputProcessor 
{
	
	private Player P; // Joueur associ�
	private PointRender direction; // Direction donn� au Joueur
	
	
	/**
	 * Constructeur principal prenant en param�tre le joueur associ�
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
			System.out.println("D�placement � droite demand�");
			direction.set(2,0);
			
		break;
		case Keys.LEFT : 
			System.out.println("D�placement � gauche demand�");
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
			System.out.println("D�placement � droite arr�t�");
			direction.set(0,0);
		break;
		case Keys.LEFT : 
			System.out.println("D�placement � gauche arr�t�");
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