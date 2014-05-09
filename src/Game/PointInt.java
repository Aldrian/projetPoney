package Game;

import org.mini2Dx.core.geom.Point;

/**
 * Classe Point rempla�ant celle du package mini2dx/libgdx : les coordonn�es seront donn�es ici en int
 * 
 * @author Ga�tan
 *
 */
public class PointInt {
	
	private int x;
	private int y;
	
	/**
	 * Origine : (0,0)
	 */
	public PointInt()
	{
		x = 0;
		y = 0;
	}
	
	public PointInt(Point p)
	{
		x = (int) p.x;
		y = (int) p.y;
	}
	
	public PointInt(int a, int b)
	{
		x = a;
		y = b;
	}
	
	public PointInt(PointInt p)
	{
		x = p.getX();
		y = p.getY();
	}
	
	public Point pointValue()
	{
		return new Point((float) x, (float) y);
	}
	
	public void set(int a, int b)
	{
		x = a;
		y = b;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
