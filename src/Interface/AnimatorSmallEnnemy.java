package Interface;

import org.mini2Dx.core.geom.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Classe dérivée d'animation d'un petit ennemi sur le spritSheet correspondant
 * @author Gaëtan
 *
 */
public class AnimatorSmallEnnemy extends Animator {

	public AnimatorSmallEnnemy(Point origin) {
		super(origin);
		// TODO Auto-generated constructor stub
	}

	/**
	 * initialisation de l'animation
	 */
	@Override
	public void create() {
		
		FRAME_COLS = 3;
		FRAME_LINES = 2;
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\Ennemy\\ennemySheet.png"));

		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);
		
		walkFrames = new Array<TextureRegion>();
		walkAnimation = new Animation[4];
		
		for (int j = 0; j < FRAME_COLS; j++) {
			walkFrames.add(tmp[0][j]);
		}
		walkAnimation[0] = new Animation(0.33f, walkFrames);
		walkFrames.clear();

		for (int j = 0; j < FRAME_COLS; j++) {
			walkFrames.add(tmp[1][j]);
		}
		walkAnimation[1] = new Animation(0.33f, walkFrames);
		walkFrames.clear();
		
		walkFrames.add(tmp[0][0]);
		walkAnimation[2] = new Animation(0f, walkFrames);
		walkFrames.clear();

		walkFrames.add(tmp[1][0]);
		walkAnimation[3] = new Animation(0f, walkFrames);
		
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}

}
