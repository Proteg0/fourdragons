
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    // instance variables - replace the example below with your own
    private int healthGain;
    private SkillList sList;
    private OneHandSkill one;
    private int oneCount;
    private TwoHandSkill two;
    private int twoCount;
    private FireSkill fire;
    private int fireCount;
    private FrostSkill frost;
    private int frostCount;

    /**
     * Constructor for objects of class Player
     * @param String the name for the character.
     * @param int the starting hitpoints the character.
     * @param int the starting level for the character.
     */
    public Player(String na, int hp, int lvl)
    {
        super(na,hp,lvl);
        healthGain = 10;
        setSkills();
    }

    /**
     * Constructor used to add a variable to health gain other than 10.
     * @param String the name for the character.
     * @param int the starting hitpoints the character.
     * @param int the starting level for the character.
     * @param int the health gained per level.
     */
    public Player(String na, int hp, int lvl, int hg)
    {
        super(na,hp,lvl);
        healthGain = hg;
        setSkills();
    }

    
    //------------------------------------------SKILLS-----------------------------------------------
    /**
     * Sets the starting skills.
     */
    public void setSkills()
    {
        sList = new SkillList();
        try{
            one = sList.getOneSkill("Punch");
            two = sList.getTwoSkill("Shove");
            fire = sList.getFireSkill("Burn");
            frost = sList.getFrostSkill("Chill");
        }
        catch(NoSuchSkillException e)
        {
            System.out.println(e);
        }
    }

    /**
     * @return int the damage from the OneHandSkill.
     */
    public int getOneDmg()
    {
        int dmg = one.getDmg();
        oneCount++;
        try
        {
            if(oneCount>=one.getCounter())
            {
                one = sList.getOneSkill(one.getNext());
            }
        }
        catch(NoSuchSkillException e)
        {
            System.out.println(e);
        }
        return dmg;
    }
    
    /**
     * @return int the damage from the TwoHandSkill.
     */
    public int getTwoDmg()
    {
        int dmg = two.getDmg();
        twoCount++;
        try
        {
            if(oneCount>=one.getCounter())
            {
                two = sList.getTwoSkill(two.getNext());
            }
        }
        catch(NoSuchSkillException e)
        {
            System.out.println(e);
        }
        return dmg;
    }
    
    /**
     * @return int the damage from the FireSkill.
     */
    public int getFireDmg()
    {
        int dmg = fire.getDmg();
        fireCount++;
        try
        {
            if(oneCount>=one.getCounter())
            {
                fire = sList.getFireSkill(fire.getNext());
            }
        }
        catch(NoSuchSkillException e)
        {
            System.out.println(e);
        }
        return dmg;
    }
    
    /**
     * @return int the damage from the FrostSkill.
     */
    public int getFrostDmg()
    {
        int dmg = frost.getDmg();
        frostCount++;
        try
        {
            if(oneCount>=one.getCounter())
            {
                frost = sList.getFrostSkill(frost.getNext());
            }
        }
        catch(NoSuchSkillException e)
        {
            System.out.println(e);
        }
        return dmg;
    }
    //------------------------------------------STATS-----------------------------------------------

    /**
     * @return int the health gained per level.
     */
    public int healthGain()
    {
        return healthGain;

    }

}
