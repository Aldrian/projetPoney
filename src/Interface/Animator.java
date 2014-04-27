package Interface;

import org.mini2Dx.core.geom.Point;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animator implements ApplicationListener {

    private static final int    FRAME_COLS = 4;     // #1

    Animation           walkAnimation;      // #3
    Texture             walkSheet;      // #4
    Array<TextureRegion>         walkFrames;     // #5
    SpriteBatch         spriteBatch;        // #6
    TextureRegion           currentFrame;       // #7
    
    Point position;

    float stateTime;                    // #8
    
    public Animator(Point origin)
    {
    	this.position = origin;
    }

	@Override
    public void create() {
        walkSheet = new Texture(Gdx.files.internal("res\\img\\J1\\1.png")); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight());
    	
		/*walkSheet[0] = new Texture(Gdx.files.internal("res\\img\\J1\\stand.png"));
		tmp[0]  = new TextureRegion(walkSheet[0], walkSheet[0].getWidth(), walkSheet[0].getHeight());
		walkSheet[1] = new Texture(Gdx.files.internal("res\\img\\J1\\2.png"));
		tmp[1]  = new TextureRegion(walkSheet[1], walkSheet[1].getWidth(), walkSheet[1].getHeight());
		walkSheet[2] = new Texture(Gdx.files.internal("res\\img\\J1\\3.png"));
		tmp[2]  = new TextureRegion(walkSheet[2], walkSheet[2].getWidth(), walkSheet[2].getHeight());
		walkSheet[3] = new Texture(Gdx.files.internal("res\\img\\J1\\4.png"));
		tmp[3]  = new TextureRegion(walkSheet[3], walkSheet[3].getWidth(), walkSheet[3].getHeight());
		walkSheet[4] = new Texture(Gdx.files.internal("res\\img\\J1\\5.png"));
		tmp[4]  = new TextureRegion(walkSheet[4], walkSheet[4].getWidth(), walkSheet[4].getHeight());*/
		
    	// #10
        walkFrames = new Array<TextureRegion>();
        
        for (int j = 0; j < FRAME_COLS; j++) {
            walkFrames.add(tmp[0][j]);
        }
        
        walkAnimation = new Animation(0.20f, walkFrames);      // #11
        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;                         // #13
    }
	
	public void update(float x, float y)
	{
		position.x = x;
		position.y = y;
	}

    @Override
    public void render() {
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime();           // #15
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, position.x , position.y);             // #17
        spriteBatch.end();
    }

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}