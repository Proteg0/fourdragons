import java.util.Random;
/**
 * Abstract class Skill - 
 * Skills are how a player levels and deals damage.
 * All stats that are universal to all skills(such as damage) are held here.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public abstract class Skill
{
    private int minDmg;
    private int maxDmg;
    private String skillName;
    private String nextSkill;
    private int skillCounter;
    private int count;
    

    /**
     * Constructor for objects of class Skill
     */
    public Skill(int min, int max, String name, int count, String next)
    {
        minDmg=min;
        maxDmg=max;
        skillName = name;
        skillCounter = count;
        nextSkill = next;
    }
    
    /**
     * @return int the minimum damage.
     */
    public int getMin()
    {
        return minDmg;
    }
    
    /**
     * @return int the maximum damage.
     */
    public int getMax()
    {
        return maxDmg;
    }
    
    /**
     * @return int the maximum damage.
     */
    public int getCounter()
    {
        return skillCounter;
    }
    
    /**
     * @return String the Name of the skill.
     */
    public String getName()
    {
        return skillName;
    }
    
    /**
     * @return String the Name of the next skill.
     */
    public String getNext()
    {
        return nextSkill;
    }
    
    /**
     * @return int the maximum damage.
     */
    public int getDmg()
    {
        //Upgrade this method later to enhance combat. 
        //for now all attack do max.
        return maxDmg;
    }
    
    //-----------------------SKILL LEVEL UP-----------------------------
    
    public boolean skillUP()
    {
        if(count>=getCounter())
            {return true; }
        else
            {count++; return false;}
    }
}
