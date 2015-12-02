
/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building extends Field
{

    /**
     * Constructor for objects of class Building
     */
    public Building(int  x, int y)
    {
        super(x,y);
        
    }
    
    /**
     * @return String description of Building.
     */
    public String toString()
    {
        return "This area appears to be some kind of ruin.\n"+super.toString();
        
    }
}
