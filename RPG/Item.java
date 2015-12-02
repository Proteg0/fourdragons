
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String itemName;
    private int itemLevel;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, int lvl)
    {
        itemName=name;
        itemLevel=lvl;
    }

    /**
     * @return String description of item.
     */
    public String toString()
    {
        return "This item is a(n) "+itemName+".\n";
        
    }
}
