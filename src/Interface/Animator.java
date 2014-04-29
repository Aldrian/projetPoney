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
	private static int typeJoueur = 1; // Joueur 1 ou Joeur 2

    private static final int    FRAME_COLS = 4;
    private static final int    FRAME_LINES = 3;

    private Animation walkAnimation[]; // Animation
    private Texture walkSheet; // Chargement de la feuille de sprite
    private Array<TextureRegion> walkFrames; // Stockage des sprites
    private SpriteBatch spriteBatch; // Sprite buffer
    private TextureRegion currentFrame; // sprite courante
    
    private Point position; // Position de l'animation

    private float stateTime;  // temps
    
    private Move mouvement; // Mouvement demandé au joueur (pas de lerp)
    
    private int typeAnimation; // Donne le type d'animation demandé
    
    /**
     * Constructeur par défaut, prenant en paramètre le point où l'animation apparaîtra à sa création
     * @param origin
     */
    public Animator(Point origin)
    {
    	this.position = origin;
    	mouvement = new Move(origin,origin);
    }

    /**
     * initialisation de l'animation
     */
	@Override
    public void create() 
	{
		if(typeJoueur == 1)
		{
			walkSheet = new Texture(Gdx.files.internal("res\\img\\J1\\1.png"));
		}
		else
		{
			walkSheet = new Texture(Gdx.files.internal("res\\img\\J2.png"));
		}
        
		typeJoueur ++;
		
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);
    	
        walkFrames = new Array<TextureRegion>();
        walkAnimation = new Animation[3];
        
        for (int j = 0; j < FRAME_COLS; j++) {
            walkFrames.add(tmp[0][j]);
        }
        walkAnimation[0] = new Animation(0.20f, walkFrames);
        walkFrames.clear();
        
        for (int j = 0; j < FRAME_COLS; j++) {
            walkFrames.add(tmp[1][j]);
        }
        walkAnimation[1] = new Animation(0.20f, walkFrames);
        walkFrames.clear();
        
        walkFrames.add(tmp[2][0]);
        walkAnimation[2] = new Animation(0f, walkFrames);
        
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }
	
	/**
	 * Mise à jour des coordonnées courantes de l'animation
	 * @param x
	 * @param y
	 */
	public void update(float x, float y, Move mouvement)
	{
		position.x = x;
		position.y = y;
		this.mouvement = mouvement;
		
		if(mouvement.isLeft())
		{
			typeAnimation = 1;
		}
		else if(mouvement.isRight())
		{
			typeAnimation = 0;
		}
		else 
		{
			typeAnimation = 2;
		}
	}

	/**
	 * Rendu graphique de l'animation
	 */
    @Override
    public void render()
    {
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = walkAnimation[typeAnimation].getKeyFrame(stateTime, true);
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