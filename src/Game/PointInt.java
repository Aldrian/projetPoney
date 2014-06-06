package Game;

import org.mini2Dx.core.geom.Point;

/**
 * Classe Point dont les coordonn�es sont des entiers.
 * Utiliser des entiers permet de baisser la pr�cision et �viter la d�tection de faux mouvements.
 * Remplace les points LibGDX.
 * @author Ga�tan
 *
 */
public class PointInt {
	
	private int x;
	private int y;
	
	/**
	 * Constructeur par d�faut, donnant une origine de (0,0)
	 */
	public PointInt()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 * Constrcteur de recopie � partir d'un Point LibGDX
	 * @param Point libgdx � convertir
	 */
	public PointInt(Point p)
	{
		x = (int) p.x;
		y = (int) p.y;
	}
	
	/**
	 * Constructeur par param�tres
	 * @param coordonn�e x
	 * @param coordonn�e y
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
	 * odifie les coordonn�es
	 * @param a
	 * @param b
	 */
	public void set(int a, int b)
	{
		x = a;
		y = b;
	}
	
	/**
	 * Converti en cha�ne de caract�res
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
