package Interface;

import org.mini2Dx.core.geom.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Animation d'un tir de laser
 * Initialise complètement l'animation à partir d'une spriteSheet d'un format connu
 * 
 * @author Gaëtan
 *
 */
public class AnimatorLaserShot extends Animator {

	public AnimatorLaserShot(Point origin) {
		super(origin);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialisation de l'animation
	 */
	@Override
	public void create() {
		FRAME_COLS = 1;
		FRAME_LINES = 7;
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\Tirs\\Laser.png"));

		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);
		
		walkFrames = new Array<TextureRegion>();
		walkAnimation = new Animation[1];
		
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkAnimation[0] = new Animation(1/7f, walkFrames);
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}

}
