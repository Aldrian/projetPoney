package Interface;

import org.mini2Dx.core.geom.Point;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animator implements ApplicationListener 
{

    private static final int    FRAME_COLS = 4;

    private Animation walkAnimation; // Animation
    private Texture walkSheet; // Chargement de la feuille de sprite
    private Array<TextureRegion> walkFrames; // Stockage des sprites
    private SpriteBatch spriteBatch; // Sprite buffer
    private TextureRegion currentFrame; // sprite courante
    
    private Point position; // Position de l'animation

    private float stateTime;  // temps
    
    
    /**
     * Constructeur par défaut, prenant en paramètre le point où l'animation apparaîtra à sa création
     * @param origin
     */
    public Animator(Point origin)
    {
    	this.position = origin;
    }

    /**
     * initialisation de l'animation
     */
	@Override
    public void create() 
	{
        walkSheet = new Texture(Gdx.files.internal("res\\img\\J1\\1.png"));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight());
    	
        walkFrames = new Array<TextureRegion>();
        
        for (int j = 0; j < FRAME_COLS; j++) {
            walkFrames.add(tmp[0][j]);
        }
        
        walkAnimation = new Animation(0.20f, walkFrames);
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }
	
	/**
	 * Mise à jour des coordonnées courantes de l'animation
	 * @param x
	 * @param y
	 */
	public void update(float x, float y)
	{
		position.x = x;
		position.y = y;
	}

	/**
	 * Rendu graphique de l'animation
	 */
    @Override
    public void render()
    {
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, position.x , position.y);
        spriteBatch.end();
    }

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}
}