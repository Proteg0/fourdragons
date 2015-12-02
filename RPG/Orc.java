
/**
 * Write a description of class Orc here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class Orc extends Monster
{
    
    /**
     * Constructor for objects of class Orc
     */
    public Orc(int lvl)
    {
        super("Orc",(lvl*10),lvl);
        
    }

    
    
    /**
     * @return String description of Orc.
     */
    public String toString()
    {
        return "This monster is an Orc.\n"+super.toString();
        
    }
}
