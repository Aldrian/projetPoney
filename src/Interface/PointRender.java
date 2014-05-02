package Interface;

import org.mini2Dx.core.geom.Point;

/**
 * Classe Point remplaçant celle du package mini2dx/libgdx : les coordonnées seront données ici en int
 * 
 * @author Gaëtan
 *
 */
public class PointRender {
	
	private int x;
	private int y;
	
	/**
	 * Origine : (0,0)
	 */
	public PointRender()
	{
		x = 0;
		y = 0;
	}
	
	public PointRender(Point p)
	{
		x = (int) p.x;
		y = (int) p.y;
	}
	
	public PointRender(int a, int b)
	{
		x = a;
		y = b;
	}
	
	public PointRender(PointRender p)
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
