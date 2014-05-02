package Core;

import org.mini2Dx.core.geom.Point;

public class Platform extends Entity {
	
	private boolean isPit;
	
	//on met currentPosition comme étant le centre de la plateforme et on ajoute 1/2 largeur et 1/2 longueur de chaque côté ?

	@Override
	public void update(Event e) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity move(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean moveAllowed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPit() {
		return isPit;
	}

	public void setPit(boolean isPit) {
		this.isPit = isPit;
	}

}
