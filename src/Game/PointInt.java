package Game;

import org.mini2Dx.core.geom.Point;

/**
 * Classe Point dont les coordonnées sont des entiers.
 * Utiliser des entiers permet de baisser la précision et éviter la détection de faux mouvements.
 * Remplace les points LibGDX.
 * @author Gaëtan
 *
 */
public class PointInt {
	
	private int x;
	private int y;
	
	/**
	 * Constructeur par défaut, donnant une origine de (0,0)
	 */
	public PointInt()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 * Constrcteur de recopie à partir d'un Point LibGDX
	 * @param Point libgdx à convertir
	 */
	public PointInt(Point p)
	{
		x = (int) p.x;
		y = (int) p.y;
	}
	
	/**
	 * Constructeur par paramètres
	 * @param coordonnée x
	 * @param coordonnée y
	 */
	public PointInt(int a, int b)
	{
		x = a;
		y = b;
	}
	
	/**
	 * Constructeur par recopie
	 * @param PointInt
	 */
	public PointInt(PointInt p)
	{
		x = p.getX();
		y = p.getY();
	}
	
	/**
	 * Conversion du PointInt en Point LibGDX
	 * @return Point libgdx
	 */
	public Point pointValue()
	{
		return new Point((float) x, (float) y);
	}
	
	/**
	 * odifie les coordonnées
	 * @param a
	 * @param b
	 */
	public void set(int a, int b)
	{
		x = a;
		y = b;
	}
	
	/**
	 * Converti en chaîne de caractères
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	/**
	 * Donne X
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Modifie X
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Donne Y
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Modifie Y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
}
