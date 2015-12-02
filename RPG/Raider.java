
/**
 * Write a description of class Raider here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class Raider extends Monster
{

    /**
     * Constructor for objects of class Raider
     */
    public Raider(int lvl)
    {
        super("Raider",(lvl*10),lvl);

    }



    /**
     * @return String description of Skelleton.
     */
    public String toString()
    {
        return "This monster is a Raider.\n"+super.toString();

    }

}