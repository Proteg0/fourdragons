
/**
 * Write a description of class Building here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
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
