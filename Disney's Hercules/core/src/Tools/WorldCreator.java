package Tools;

import Screens.PlayScreen;
import com.Hercules.game.Main;
import HealthAttacker.*;
import MovingObjects.*;
import Sprites.*;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;


public class WorldCreator {
    private PlayScreen screen;
    private World world;
    private TiledMap map;
    private Body body;
    private BodyDef bdef;
    private PolygonShape shape;
    private FixtureDef fdef;
    private Phill phill;
    private Array<Bird> birds;
    private Array<Deer> deers;
    private Array<Ape> apes;
    private Array<BabyDragon> babyDragons;
    private Array<Wagon> wagons;
    private Array<Vulture> vultures;
    private Array<Border> borders;
    /***************************/
    private Array<Coin> coins;
    private Array<Fireball> fireballs;
    private Array<FeatherSack> feathers;
    private Array<Chicken> chickens;
    private Array<Wolf> wolfs;
    private Array<Wall> walls;
    private Array<Letter> letters;
    /***************************/
    
    public WorldCreator(PlayScreen  screen){
        this.screen = screen;
        world = screen.getWorld();
        map = screen.getMap();   
                
        bdef = new BodyDef();
        shape = new PolygonShape() ;
        fdef = new FixtureDef();
        
        birds = new Array<Bird>();
        deers = new Array<Deer>();
        apes = new Array<Ape>();
        babyDragons = new Array<BabyDragon>();
        wagons = new Array<Wagon>();
        vultures = new Array<Vulture>();
        borders = new Array<Border>();
        coins = new Array<Coin>();
        fireballs = new Array<Fireball>();
        feathers = new Array<FeatherSack>();
        chickens = new Array<Chicken>();
        wolfs = new Array<Wolf>();
        walls = new Array<Wall>();
        letters = new Array<Letter>();
        
            Hercules();
            CharactersGround();
            Phill();
            Deer();
            Apes();
            BirdSurface();
            Birds();
            BabyDragonSurface();
            BabyDragons();
            Wagons();
            Vultures();
            Barriers();
            Coins();
            Fireballs();
            Feathers();
            Chickens();
            Wolfs();
            Walls();
            Letters();
    }
    
    private void Hercules(){
        for(MapObject object : map.getLayers().get("Hercules Ground").getObjects().getByType(RectangleMapObject.class)){
            Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;
            
                bdef.type = BodyDef.BodyType.StaticBody ;
                bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
                body =world.createBody(bdef) ;
                shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
                fdef.filter.categoryBits = Main.GROUND_BIT;
                fdef.shape =shape ;
                body.createFixture(fdef ) ;
             } 
         }
    private void CharactersGround(){
          try{      
                for(MapObject object : map.getLayers().get("Characters Ground").getObjects().getByType(RectangleMapObject.class)){
                 Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;

                 bdef.type = BodyDef.BodyType.StaticBody ;
                 bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
                 body =world.createBody(bdef) ;
                 shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
                 fdef.shape =shape ;
                 fdef.filter.categoryBits = Main.CHARACTERS_GROUND_BIT;
                 body.createFixture(fdef ) ;
             }
          }catch(Exception ex){}
      }
    private void BirdSurface(){
        try{
            for(MapObject object : map.getLayers().get("Birds Surface").getObjects().getByType(RectangleMapObject.class)){
             Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;

             bdef.type = BodyDef.BodyType.StaticBody ;
             bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
             body =world.createBody(bdef) ;
             shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
             fdef.shape =shape ;
             fdef.filter.categoryBits = Main.BIRDS_GROUND_BIT;
             body.createFixture(fdef ) ;
         }
        } catch(Exception ex){}
      }
    private void BabyDragonSurface(){
          try{
                for(MapObject object : map.getLayers().get("Baby Dragon Surface").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;

                bdef.type = BodyDef.BodyType.StaticBody ;
                bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
                body =world.createBody(bdef) ;
                shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
                fdef.filter.categoryBits = Main.BABYDRAGONS_SURFACE_BIT;
                fdef.shape =shape ;
                body.createFixture(fdef ) ;
            } 
         
            for(MapObject object : map.getLayers().get("Sky Border").getObjects().getByType(RectangleMapObject.class)){
               Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;

               bdef.type = BodyDef.BodyType.StaticBody ;
               bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
               body =world.createBody(bdef) ;
               shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
               fdef.filter.categoryBits = Main.SKY_BORDER_BIT;
               fdef.shape =shape ;
               body.createFixture(fdef ) ;
           }
        } catch(Exception ex){}
      }
    private void Phill(){
        try{
                for(MapObject object : map.getLayers().get("Phill").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                phill = new Phill(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM);
            }
        } catch(Exception ex){}
    }
    private void Birds(){
        try{
                for(MapObject object : map.getLayers().get("Birds").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                birds.add(new Bird(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
          }
        } catch(Exception ex){}
    }
    private void Deer(){
        try{
            for(MapObject object : map.getLayers().get("Deer").getObjects().getByType(RectangleMapObject.class)){
            Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
            deers.add(new Deer(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
            }
        } catch(Exception ex){}
    }
    private void Apes(){
        try{
                for(MapObject object : map.getLayers().get("Apes").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;
                apes.add(new Ape(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
          }
        } catch(Exception ex){}
    }
    private void BabyDragons(){
        try{
                for(MapObject object : map.getLayers().get("Baby Dragons").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;
                babyDragons.add(new BabyDragon(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
          }
        } catch(Exception ex){}
    }
    private void Wagons(){
        try{
                for(MapObject object : map.getLayers().get("Wagons").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                wagons.add(new Wagon(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
            }
        } catch(Exception ex){}
    }
    private void Vultures() {
        try{
                for(MapObject object : map.getLayers().get("Vultures").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                vultures.add(new Vulture(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
            }
                
                for(MapObject object : map.getLayers().get("Vulture Borders").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                borders.add(new Border(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
            }
                
        } catch(Exception ex){}
    }
    private void Barriers() {
        try{
        for(MapObject object : map.getLayers().get("Obstacless").getObjects().getByType(RectangleMapObject.class)){
            Rectangle  rec = ((RectangleMapObject) object ).getRectangle() ;
            
                bdef.type = BodyDef.BodyType.StaticBody ;
                bdef.position.set((rec.getX() + rec.getWidth() /2) / Main.PPM  , (rec.getY()+ rec.getHeight()/2) / Main.PPM  ) ;
                body =world.createBody(bdef) ;
                shape.setAsBox( (rec.getWidth()/2 ) / Main.PPM , (rec.getHeight() /2) / Main.PPM );
                fdef.shape =shape ;
                body.createFixture(fdef ) ;
                
                
                new Slider(screen);
             } 
        } catch (Exception ex){}
    }
    private void Coins() {
        try{
                for(MapObject object : map.getLayers().get("Golden Coins").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                coins.add (new GoldenCoin(screen, rec.getX(), rec.getY()));
            }
        } catch(Exception ex){}
        try{
                for(MapObject object : map.getLayers().get("Silver Coins").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                coins.add (new SilverCoin(screen, rec.getX(), rec.getY()));
            }
        } catch(Exception ex){}
    }
    private void Fireballs() {
        try{
                for(MapObject object : map.getLayers().get("Fireballs").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                fireballs.add (new Fireball(rec.getX(), rec.getY(), screen.getPlayer()));
            }
        } catch(Exception ex){}
    }
    private void Feathers() {
        try{
                for(MapObject object : map.getLayers().get("Feather Sacks").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                feathers.add (new FeatherSack(rec.getX() / Main.PPM, rec.getY() / Main.PPM, screen));
                }
        } catch(Exception ex){}
        try{
                int cnt=0, order=1;
                for(MapObject object : map.getLayers().get("Moving Feather Sacks").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle(); cnt++; if(cnt==5)order=2;
                feathers.add (new MovingFeather(rec.getX() / Main.PPM, rec.getY() / Main.PPM, screen, order));
                
            }
        } catch(Exception ex){}
    }
    private void Chickens() {
        try{
                for(MapObject object : map.getLayers().get("Chickens").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                chickens.add (new Chicken(rec.getX(), rec.getY()));
                }
        } catch(Exception ex){}
    }
    private void Wolfs() {
        try{
                for(MapObject object : map.getLayers().get("Wolfs").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                wolfs.add (new Wolf(screen, rec.getX(), rec.getY(), 2500f));
                }
        } catch(Exception ex){}
    }
    private void Walls() {
        try{
                for(MapObject object : map.getLayers().get("Walls").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                walls.add (new Wall(screen, rec.getX(), rec.getY()));
                }
        } catch(Exception ex){}
    }
    private void Letters() {
        try{
                for(MapObject object : map.getLayers().get("Letters").getObjects().getByType(RectangleMapObject.class)){
                Rectangle  rec = ((RectangleMapObject) object ).getRectangle();
                letters.add (new Letter(screen, rec.getX() / Main.PPM, rec.getY() / Main.PPM));
                }
        } catch(Exception ex){}
    }
    
    public Phill getPhill() {return phill;}
    public Array<Bird> getBirds() {return birds;}
    public Array<Deer> getDeers() {return deers;}
    public Array<Ape> getApes() {return apes;}
    public Array<BabyDragon> getBabyDragons() {return babyDragons;}
    public Array<Wagon> getWagons() {return wagons;}
    public Array<Vulture> getVultures() {return vultures;}
    public Array<Border> getBorders() {return borders;}
    public Array<Coin> getCoins() {return coins;}
    public Array<Fireball> getFireballs() {return fireballs;}
    public Array<FeatherSack> getFeathers() {return feathers;}
    public Array<Chicken> getChickens() {return chickens;}
    public Array<Wolf> getWolfs() {return wolfs;}
    public Array<Wall> getWalls() {return walls;}
    public Array<Letter> getLetters() {return letters;}
    
}