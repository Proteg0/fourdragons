
/**
 * Write a description of class Wolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wolf extends Monster
{
    
    /**
     * Constructor for objects of class Wolf
     */
    public Wolf(int lvl)
    {
        super("Wolf",(lvl*10),lvl);
        
    }

    
    /**
     * @return String description of Wolf.
     */
    public String toString()
    {
        return "This monster is a Wolf.\n"+super.toString();
        
    }
}
