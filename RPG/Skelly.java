
/**
 * Write a description of class Skelly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
