package Core;

import org.mini2Dx.core.geom.Point;

public abstract class MovingEntity extends Entity {
	
	protected Point previousPosition; // Position pr�c�dente

	public abstract Entity  move(Point p);
	
	public abstract boolean moveAllowed(Point p);

	

}
