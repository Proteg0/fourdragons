import java.util.HashMap;
import java.util.Map.Entry;
/**
 * Write a description of class WorldMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapCase
{
    protected HashMap<Integer, WorldMap> locations;
    public Field currentLocation;

    /**
     * Creates an array list to hold all rooms we make during creation of the game.
     */
    public MapCase()
    {
        locations = new HashMap<Integer, WorldMap>();
        createStart();
        currentLocation = getField(0,0);
    }

    /**
     * The predefined fields in the game. 
     * Later can be used to add special features.
     */
    public void createStart()
    {
        Field a = new Building (0,0);
        Field b = new Building (0,1);
        Field c = new Building (0,-1);
        WorldMap zero = new WorldMap();
        zero.addField(0,a);
        zero.addField(1,b);
        zero.addField(-1,c);
        locations.put(0,zero);
        
        Field d = new Building (1,0);
        Field e = new Building (1,1);
        Field f = new Building (1,-1);
        WorldMap one = new WorldMap();
        one.addField(0,d);
        one.addField(1,e);
        one.addField(-1,f);
        locations.put(1,one);
        
        Field g = new Building (-1,0);
        Field h = new Building (-1,1);
        Field i = new Building (-1,-1);
        WorldMap negOne = new WorldMap();
        negOne.addField(0,g);
        negOne.addField(1,h);
        negOne.addField(-1,i);
        locations.put(-1,negOne);
        
    }
    
    //-----------------------------------------FIELD INFO-------------------------------
    /**
     * Checks if the current field has a monster.
     */
    public boolean hasMonster()
    {
        return currentLocation.hasMonster();
    }
    
    /**
     * @return String description of current field.
     */
    public String getInfo()
    {
        return currentLocation.toString();
        
    }
    
    /**
     * @return int the X position of current field.
     */
    public int getX()
    {
        return currentLocation.getX();
        
    }
    
    /**
     * @return int the Y position of current field.
     */
    public int getY()
    {
        return currentLocation.getY();
        
    }
    
    //-----------------------------------------MOVEMENT-------------------------------
    /**
     * Sets current locatoin to the location to the west.
     */
    public void west()
    {
        
        currentLocation = getField(currentLocation.getX()-1, currentLocation.getY());
        incrimentLocations();
    }
    
    /**
     * Sets current locatoin to the location to the east.
     */
    public void east()
    {
        currentLocation = getField(currentLocation.getX()+1, currentLocation.getY());
        incrimentLocations();
    }
    
    /**
     * Sets current locatoin to the location to the north.
     */
    public void north()
    {
        currentLocation = getField(currentLocation.getX(), currentLocation.getY()+1);
        incrimentLocations();
    }
    
    /**
     * Sets current locatoin to the location to the south.
     */
    public void south()
    {
        currentLocation = getField(currentLocation.getX(), currentLocation.getY()-1);
        incrimentLocations();
    }
    
    /**
     * Updates each existing field.
     */
    public void incrimentLocations()
    {
        for(Entry<Integer,WorldMap> entry: locations.entrySet())
        {
             WorldMap wm = entry.getValue();
             wm.incrimentLocations();
             locations.put(entry.getKey(),wm);
             
        }
    }
    
    
    // May be a good place for a try/catch block
    /**
     * Fetches a field, and creates one if the field does not exist.
     *  @param int the x coordinate of the field.
     *  @param int the y coordinate of the field.
     *  @return Field the field object at the x,y coordinates.
     */
    public Field getField(int x, int y)
    {
        if(locations.get(x)==null)
        {
            
            WorldMap wm = new WorldMap();
            wm.addField(y,generateField(x,y));
            locations.put(x,wm);
            
        }
        
        if(locations.get(x).getField(y)==null)
        {
            WorldMap wm = locations.get(x);
            wm.addField(y,generateField(x,y));
            
        }
       return locations.get(x).getField(y);
    }
    
    /**
     * Creates a new field. 
     */
    public Field generateField(int x, int y)
    {
        
        Field f = new GrassLand(x,y);
        return f;
    }
}
