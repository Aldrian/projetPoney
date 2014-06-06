package Interface;

import java.awt.event.KeyEvent;

import Core.Player;
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
	 * Méthode appelée dans la boucle principale du jeu.
	 * De cette façon les joueurs sont mis à jour constamment par la direction qui lui est associée dans cette classe
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
	 * Méthode des entrées appuis clavier.
	 * A chaque appuie sur une touche, cette méthode est appelée avec comme argument l'entier correspondant à la touche appuyée
	 * @param entier correspondant à la touche tapée
	 */
	@Override
	public boolean keyDown(int key) 
	{
		
		switch(key)
		{
		case Keys.RIGHT :
			//System.out.println("Déplacement à droite demandé");
			if (P1.move){
				directionP1.set(2,0);
				
			}
			
			
		break;
		case Keys.LEFT : 
			//System.out.println("Déplacement à gauche demandé");
			if (P1.move){
				directionP1.set(-2,0);
				//P1.setAir(true);
			}
			
		break;
		case Keys.UP :
			//System.out.println("Déplacement à droite demandé");
			P1.move=false;
			directionP1.set(0,2);
			
			
		break;
		case Keys.D :
			//System.out.println("Déplacement à droite demandé");
			if (P2.move) {
				directionP2.set(2,0);
				//P2.setAir(true);
			}
			
			
		break;
		case Keys.Q : 
			//System.out.println("Déplacement à gauche demandé");
			if (P2.move) {
				directionP2.set(-2,0);
				//P2.setAir(true);
			}
			
		break;
		case Keys.Z :
			//System.out.println("Déplacement à droite demandé");
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
	 * Méthode des entrées retours clavier.
	 * A chaque relachement d'une touche, cette méthode est appelée avec comme argument l'entier correspondant à la touche relâchée
	 * @param entier correspondant à la touche tapée
	 */
	@Override
	public boolean keyUp(int key) {
		switch(key)
		{
		case Keys.RIGHT :
			//System.out.println("Déplacement à droite arrêté");
			if (P1.move) {
				directionP1.set(0,0);
				P1.droite=true;
				//P1.setAir(true);
			}
			
			
		break;
		case Keys.LEFT : 
			//System.out.println("Déplacement à gauche arrêté");
			if (P1.move) {
				directionP1.set(0,0);
				P1.droite=false;
				//P1.setAir(true);
			}
			
		break;
		case Keys.UP :
			//System.out.println("Déplacement à droite demandé");
			P1.move=true;
			directionP1.set(0,0);
			
			
		break;
		case Keys.D :
			//System.out.println("Déplacement à droite arrêté");
			if (P2.move){
				directionP2.set(0,0);
				P2.droite=true;
				//P2.setAir(true);
			}
			
		break;
		case Keys.Q : 
			//System.out.println("Déplacement à gauche arrêté");
			if (P2.move){
				directionP2.set(0,0);
				P2.droite=false;
				//P2.setAir(true);
			}
		break;
		case Keys.Z :
			//System.out.println("Déplacement à droite demandé");
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