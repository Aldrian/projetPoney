package Interface;

import org.mini2Dx.core.geom.Point;

import Game.Move;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Animation du compte à rebours initial
 * @author Gaëtan
 *
 */
public class AnimatorCountDown extends Animator {

	public AnimatorCountDown(Point origin) {
		super(origin);
		// TODO Auto-generated constructor stub
	}

	/**
	 * initialisation de l'animation
	 */
	@Override
	public void create() {
		FRAME_COLS = 1;
		FRAME_LINES = 7;
		

		TextureRegion[][] tmp = null;
		
		walkFrames = new Array<TextureRegion>();
		walkAnimation = new Animation[1];

		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\1.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\2.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\3.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\4.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\5.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\6.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkSheet = new Texture(Gdx.files.internal("res\\img\\countdown\\7.png"));
		tmp = TextureRegion.split(walkSheet, walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);
		for (int j = 0; j < FRAME_LINES; j++) {
			walkFrames.add(tmp[j][0]);
		}
		
		walkAnimation[0] = new Animation((1.5f)/49f, walkFrames);
		
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
		
		typeAnimation = 0;
		
		renderPosition = new Point(0,0);
	}
	
	/**
	 * Mise à jour des coordonnées courantes de l'animation
	 * @param x
	 * @param y
	 */
	public void update(float x, float y, Move mouvement)
	{
		
	}
	
	/**
	 * Rendu graphique de l'animation
	 */
	@Override
	public void render()
	{
		//Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);end
		stateTime += Gdx.graphics.getDeltaTime();
		
		if(stateTime < (1.5f))
		{
			currentFrame = walkAnimation[0].getKeyFrame(stateTime, false);
			currentFrame.setRegion(currentFrame, 0, 0,walkSheet.getWidth(), walkSheet.getHeight()/FRAME_LINES);

			spriteBatch.begin();
			spriteBatch.draw(currentFrame, renderPosition.x , renderPosition.y);
			spriteBatch.end();
		}
	}

}
