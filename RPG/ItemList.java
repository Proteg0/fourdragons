import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class ItemList here.
 * 
 * @author Chris Easton 
 * @version Alpha 0.1
 */
public class ItemList
{
    private HashMap<Integer, ArrayList> list;
    private ArrayList<Item> lvlOne;
    private ArrayList<Item> lvlTwo;
    private ArrayList<Item> lvlThree;
    private ArrayList<Item> lvlFour;
    private ArrayList<Item> lvlFive;
    

    /**
     * Constructor for objects of class ItemList
     */
    public ItemList()
    {
        list = new HashMap<Integer, ArrayList>();
        fillList();
    }

    /**
     * Creates the HashMap for the item lists.
     */
    public void fillList()
    {
        lvlOne = new ArrayList<Item>();
        arrayOne();
        lvlTwo = new ArrayList<Item>();
        arrayTwo();
        lvlThree = new ArrayList<Item>();
        arrayThree();
        lvlFour = new ArrayList<Item>();
        arrayFour();
        lvlFive = new ArrayList<Item>();
        arrayFive();
    
    
    
    }
    
    /**
     * Creates the ArrayList for the level one items.
     */
    public void arrayOne()
    {
        int lvl =1;
        lvlOne.add(new Armor("Cloth Robe", lvl));
        lvlOne.add(new Armor("Cloth Gloves", lvl));
        lvlOne.add(new Armor("Cloth Hat", lvl));
        lvlOne.add(new Weapon("Wooden Dagger", lvl));
        lvlOne.add(new Weapon("Wooden Short-Sword", lvl));
        lvlOne.add(new Weapon("Wooden Shield", lvl));
        list.put(lvl,lvlOne);
    }
    
    /**
     * Creates the ArrayList for the level one items.
     */
    public void arrayTwo()
    {
        int lvl =2;
        lvlTwo.add(new Armor("Cloth Robe", lvl));
        lvlTwo.add(new Armor("Cloth Gloves", lvl));
        lvlTwo.add(new Armor("Cloth Hat", lvl));
        lvlTwo.add(new Weapon("Wooden Dagger", lvl));
        lvlTwo.add(new Weapon("Wooden Short-Sword", lvl));
        lvlTwo.add(new Weapon("Wooden Shield", lvl));
        list.put(lvl,lvlTwo);
    }
    
    /**
     * Creates the ArrayList for the level one items.
     */
    public void arrayThree()
    {
        int lvl =3;
        lvlThree.add(new Armor("Cloth Robe", lvl));
        lvlThree.add(new Armor("Cloth Gloves", lvl));
        lvlThree.add(new Armor("Cloth Hat", lvl));
        lvlThree.add(new Weapon("Wooden Dagger", lvl));
        lvlThree.add(new Weapon("Wooden Short-Sword", lvl));
        lvlThree.add(new Weapon("Wooden Shield", lvl));
        list.put(lvl,lvlThree);
    }
    
    /**
     * Creates the ArrayList for the level one items.
     */
    public void arrayFour()
    {
        int lvl =4;
        lvlFour.add(new Armor("Cloth Robe", lvl));
        lvlFour.add(new Armor("Cloth Gloves", lvl));
        lvlFour.add(new Armor("Cloth Hat", lvl));
        lvlFour.add(new Weapon("Wooden Dagger", lvl));
        lvlFour.add(new Weapon("Wooden Short-Sword", lvl));
        lvlFour.add(new Weapon("Wooden Shield", lvl));
        list.put(lvl,lvlFour);
    }
    
    /**
     * Creates the ArrayList for the level one items.
     */
    public void arrayFive()
    {
        int lvl =5;
        lvlFive.add(new Armor("Cloth Robe", lvl));
        lvlFive.add(new Armor("Cloth Gloves", lvl));
        lvlFive.add(new Armor("Cloth Hat", lvl));
        lvlFive.add(new Weapon("Wooden Dagger", lvl));
        lvlFive.add(new Weapon("Wooden Short-Sword", lvl));
        lvlFive.add(new Weapon("Wooden Shield", lvl));
        list.put(lvl,lvlFive);
    }
    
    
    
}
