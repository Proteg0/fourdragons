
/**
 * Write a description of class Skelly here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class Skelly extends Monster
{
    

    /**
     * Constructor for objects of class Skelly
     */
    public Skelly(int lvl)
    {
        super("Skelleton",(lvl*10),lvl);
        
    }
    
    /**
     * @return String description of Skelleton.
     */
    public String toString()
    {
        return "This monster is a Skelleton.\n"+super.toString();
        
    }
}
