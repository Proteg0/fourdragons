
/**
 * Write a description of class Raider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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