package Interface;
import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;


public class BackgroundElement {
	private Point hautGauche = new Point();
	private Point hautDroite = new Point();
	private Point basGauche = new Point();
	private Point basDroite = new Point();
	
	
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
	}
	
	public void render(Graphics g) 
	{
		g.fillRect(hautGauche.getX(), hautGauche.getY(), hautGauche.getDistanceTo(hautDroite), hautGauche.getDistanceTo(basGauche));
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
