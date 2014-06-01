package Display;
import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;

/**
 * @author Julien
 * Classe g�rant un �l�ment pr�sent en fond de jeu.
 * Cet �l�ment pourra �tre : 
 * Une plateforme, un spawner ou une fosse.
 * Cette classe contient les 4 points correspondant aux quatres
 * coins de l'objet, ainsi qu'un objet ElementType correspondant au type de l'�l�ment.
 * 
 */
public class BackgroundElement {
	
	
	private Point hautGauche = new Point();
	private Point hautDroite = new Point();
	private Point basGauche = new Point();
	private Point basDroite = new Point();
	private ElementType type;
	
	

	/**
	 * Constructeur � 4 param�tres cr�ant un objet � partir du point situ� en haut et � 
	 * gauche, de sa largeur et de sa hauteur.
	 * Par d�faut, le type none est initialis�.
	 * @param x
	 * @param y
	 * @param l
	 * @param h
	 */
	public BackgroundElement(int x, int y, int l, int h)
	{
		hautGauche.x = x;
		hautGauche.y = y;
		hautDroite.x = x + l;
		hautDroite.y = y + l;
		basGauche.x = x + h;
		basGauche.y = y + h;
		basDroite.x = x + l + h;
		basDroite.y = y + l + h;
		type = ElementType.None;
	}
	
	/**
	 * Constructeur � 5 param�tres cr�ant un objet � partir du point situ� en haut et � 
	 * gauche, de sa largeur, de sa hauteur et de son type.
	 * @param x
	 * @param y
	 * @param l
	 * @param h
	 * @param t
	 */
	public BackgroundElement(int x, int y, int l, int h, char t)
	{
		hautGauche.x = x;
		hautGauche.y = y;
		hautDroite.x = x + l;
		hautDroite.y = y + l;
		basGauche.x = x + h;
		basGauche.y = y + h;
		basDroite.x = x + l + h;
		basDroite.y = y + l + h;
		System.out.println(t);
		switch(t)
		{
			case '0' : type = ElementType.None; break;
			case '1' :  type = ElementType.Platform; break;
			case '2' :  type = ElementType.Spawner; break;
			case '3' :  type = ElementType.Pit; break;	
			default : type = ElementType.None; break;
		}
	}
	
	
	/******************************************************************/
	/******************************************************************/
	/*****************GETTERS ET SETTERS*******************************/
	/******************************************************************/
	/******************************************************************/

	
	public void setType(ElementType type)	
	{
		this.type = type;
	}
	
	
	public ElementType getType()
	{
		return type;
	}
	
	
	public Point getHautGauche() {
		return hautGauche;
	}

	public Point getHautDroite() {
		return hautDroite;
	}

	public Point getBasGauche() {
		return basGauche;
	}

	public Point getBasDroite() {
		return basDroite;
	}
	
	
	
	
	
	
}
