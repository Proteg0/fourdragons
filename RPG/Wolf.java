
/**
 * Write a description of class Wolf here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
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
