
/**
 * Monsters make up all NPC characters in the game.
 * All stats that are unique to monsters 
 * yet held constant between all monsters should be held here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class Monster extends Person
{
    private int dmg;

    /**
     * Constructor for objects of class Monster
     */
    public Monster(String na, int hp, int lvl)
    {
        super(na,hp,lvl);
        dmg = 2*lvl;
    }
    
    /**
     * @return int Damage this monster deals in combat.
     */
    public int getDmg()
    {
        return dmg;
        
    }
   
    
    /**
     * @return String description of Monster.
     */
    public String toString()
    {
        return super.toString();
        
    }
}
