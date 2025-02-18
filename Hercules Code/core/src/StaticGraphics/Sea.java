
package StaticGraphics;

import com.main.Main;
import Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

 
public class Sea extends Sprite{

    private Animation animation;
    private static TextureAtlas atlas=new TextureAtlas("C:\\Users\\Google\\Desktop\\Level Three\\Sea\\J\\Background.pack");
    private float elapsedTime;
    private float x, y;
    
    public Sea(PlayScreen screen) {
        super(atlas.findRegion("Sea"));
        TiledMap map = screen.getMap();
        
        try{
            for (MapObject object : map.getLayers().get("Sea").getObjects().getByType(RectangleMapObject.class)){
                 Rectangle rect = ((RectangleMapObject) object).getRectangle();

                 x = rect.getX() / Main.PPM;
                 y = rect.getY() / Main.PPM;
            }
        } catch(Exception ex){}
        
        setPosition(x, y);
        Array <TextureRegion> frames = new Array<TextureRegion>();
        
        for (int i =0; i < 5; ++i)
            frames.add(new TextureRegion(getTexture(), i*720, 0, 720, 400));
        animation = new Animation(0.2f, frames);
        setBounds(getX(), getY(), 2000/Main.PPM, 1100/Main.PPM);
    }
    
     public void update(float dt){
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        elapsedTime += dt;
       TextureRegion region = (TextureRegion) animation.getKeyFrame(elapsedTime, true);
       return region;
    }
    
}
