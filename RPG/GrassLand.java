/**
 * Write a description of class GrassLand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassLand extends Field
{
    

    /**
     * Constructor for objects of class GrassLand
     */
    public GrassLand(int x, int y)
    {
       super(x,y);
    }

    /**
     * @return String description of Grassland.
     */
    public String toString()
    {
        return "This area appears to be grassland.\n"+super.toString();
        
    }
}
