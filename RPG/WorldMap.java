import java.util.HashMap;
import java.util.Map.Entry;
/**
 * Write a description of class WorldMap here.
 * 
 * @author Chris Easton 
 * @version Alpha 0.1
 */
public class WorldMap
{
    protected HashMap<Integer, Field> locations;

    /**
     * Creates an array list to hold all rooms we make during creation of the game.
     */
    public WorldMap()
    {
        locations = new HashMap<Integer, Field>();
    }

    /**
     * Adds a room to the array list.
     * @param Room adds a room to the array list 
     */
    public void addField(int loc, Field field)
    {
        
        locations.put(loc, field);
    }
    
    /**
     * Used for when a random room is needed, such as moving from a transporter room.
     *  @param Room returns a random room from the array list.
     */
    public Field getField(int loc)
    {
        
        return locations.get(loc);
    }
    
    /**
     * Updates each existing field.
     */
    public void incrimentLocations()
    {
        for(Entry<Integer,Field> entry: locations.entrySet())
        {
             Field f = entry.getValue();
             f.addTime();
             locations.put(entry.getKey(),f);
             
        }
        
    }
}
