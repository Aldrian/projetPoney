package Interface;


import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;


public class MyInputProcessor implements InputProcessor {
	Player P;
	
	/*
	 * Constructeur principal prenant en paramètre le joueur associé
	 */
	public MyInputProcessor(Player p)
	{
		this.P = p;
	}
	
	@Override
	public boolean keyDown(int key) {
		
		switch(key)
		{
		case Keys.RIGHT :
			System.out.println("Déplacement à droite demandé");
			P.update(1);
		break;
		case Keys.LEFT : 
			System.out.println("Déplacement à gauche demandé");
			P.update(0);
		break;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int key) {
		return false;
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