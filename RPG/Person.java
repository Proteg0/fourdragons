
/**
 * Abstract class Person
 * This should hold the varrables that are shared across all monsters and players.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public abstract class Person
{
    private String name;
    private int currentHealth;
    private int maxHealth;
    private int level;
    
    /**
     * Constructor for objects of class Person
     */
    public Person(String na, int hp, int lvl)
    {
        name = na;
        currentHealth = hp;
        maxHealth = hp;
        level = lvl;
    
    }
    
    
    
    
    
    //----------------------------Accessors-------------------------------------
    /**
     * @return String the name of person.
     */
    public String getName()
    {return name;}
    
    /**
     * @return int the current health.
     */
    public int getCurrentHealth()
    {return currentHealth;}
    
    /**
     * @return int the max health.
     */
    public int getMaxHealth()
    {return maxHealth;}
    
    /**
     * @return int the current level.
     */
    public int getLevel()
    {return level;}
    
    /**
     * @param int the ammount to be subtracted from the monster health.
     */
    public void takeDamage(int dmg)
    {currentHealth-=dmg;}
    
    /**
     * @param int the ammount to be subtracted from the monster health.
     */
    public void healDamage(int dmg)
    {
        currentHealth+=dmg;
        if(currentHealth>=maxHealth)
        {currentHealth = maxHealth;}
    }
    
    /**
     * @return String description of person.
     */
    public String toString()
    {
        return "The name is "+name+".\nThe level is "+level+".\n";
        
    }
}
