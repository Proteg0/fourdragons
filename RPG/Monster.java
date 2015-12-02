
/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
