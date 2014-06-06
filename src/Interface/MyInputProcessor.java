package Interface;

import java.awt.event.KeyEvent;

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
	 * @param Joueur 1
	 * @param Joueur 2
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
		
		if (!P1.saut) {
			P1.update(directionP1);
		}
		else P1.update(P1.jump(P1.posInitSaut,directionP1));
		
		if (!P2.saut) {
			P2.update(directionP2);
		}
		else P2.update(P2.jump(P2.posInitSaut,directionP2));
	}
	
	/**
	 * M�thode des entr�es appuis clavier.
	 * A chaque appuie sur une touche, cette m�thode est appel�e avec comme argument l'entier correspondant � la touche appuy�e
	 * @param entier correspondant � la touche tap�e
	 */
	@Override
	public boolean keyDown(int key) 
	{
		
		switch(key)
		{
		case Keys.RIGHT :
			//System.out.println("D�placement � droite demand�");
			if (P1.move){
				directionP1.set(2,0);
				
			}
			
			
		break;
		case Keys.LEFT : 
			//System.out.println("D�placement � gauche demand�");
			if (P1.move){
				directionP1.set(-2,0);
				//P1.setAir(true);
			}
			
		break;
		case Keys.UP :
			//System.out.println("D�placement � droite demand�");
			P1.move=false;
			directionP1.set(0,2);
			
			
		break;
		case Keys.D :
			//System.out.println("D�placement � droite demand�");
			if (P2.move) {
				directionP2.set(2,0);
				//P2.setAir(true);
			}
			
			
		break;
		case Keys.Q : 
			//System.out.println("D�placement � gauche demand�");
			if (P2.move) {
				directionP2.set(-2,0);
				//P2.setAir(true);
			}
			
		break;
		case Keys.Z :
			//System.out.println("D�placement � droite demand�");
			P2.move=false;
			directionP2.set(0,2);
			
			
		break;
		/*case Keys.F : 
			P2.shot();
		break;
		case Keys.M : 
			P1.shot();
		break;*/
		}
		return true;
	}
	
	/**
	 * M�thode des entr�es retours clavier.
	 * A chaque relachement d'une touche, cette m�thode est appel�e avec comme argument l'entier correspondant � la touche rel�ch�e
	 * @param entier correspondant � la touche tap�e
	 */
	@Override
	public boolean keyUp(int key) {
		switch(key)
		{
		case Keys.RIGHT :
			//System.out.println("D�placement � droite arr�t�");
			if (P1.move) {
				directionP1.set(0,0);
				P1.droite=true;
				//P1.setAir(true);
			}
			
			
		break;
		case Keys.LEFT : 
			//System.out.println("D�placement � gauche arr�t�");
			if (P1.move) {
				directionP1.set(0,0);
				P1.droite=false;
				//P1.setAir(true);
			}
			
		break;
		case Keys.UP :
			//System.out.println("D�placement � droite demand�");
			P1.move=true;
			directionP1.set(0,0);
			
			
		break;
		case Keys.D :
			//System.out.println("D�placement � droite arr�t�");
			if (P2.move){
				directionP2.set(0,0);
				P2.droite=true;
				//P2.setAir(true);
			}
			
		break;
		case Keys.Q : 
			//System.out.println("D�placement � gauche arr�t�");
			if (P2.move){
				directionP2.set(0,0);
				P2.droite=false;
				//P2.setAir(true);
			}
		break;
		case Keys.Z :
			//System.out.println("D�placement � droite demand�");
			P2.move=true;
			directionP2.set(0,0);
			
			
		break;

		}
		return true;
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


	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}