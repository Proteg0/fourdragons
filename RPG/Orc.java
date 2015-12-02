
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
